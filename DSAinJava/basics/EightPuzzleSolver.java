package DSAinJava.basics;
import java.util.*;

public class EightPuzzleSolver {
    public static class Node {

        public Node parent;
        public int[][] matrix;

        public int x, y;

        public int cost;
        public int estimatedCost;

        public int level;

        public Node(int[][] matrix, int x, int y, int newX, int newY, int level, Node parent,int estimatedCost) {
            this.parent = parent;
            this.matrix = new int[matrix.length][];
            for (int i = 0; i < matrix.length; i++) {
                this.matrix[i] = matrix[i].clone();
            }

            this.matrix[x][y] = this.matrix[x][y] + this.matrix[newX][newY];
            this.matrix[newX][newY] = this.matrix[x][y] - this.matrix[newX][newY];
            this.matrix[x][y] = this.matrix[x][y] - this.matrix[newX][newY];

            this.cost = Integer.MAX_VALUE;
            this.estimatedCost=estimatedCost;
            this.level = level;
            this.x = newX;
            this.y = newY;
        }

    }

    public int dimension = 3;

    int[] row = {1, 0, -1, 0};
    int[] col = {0, -1, 0, 1};

    public int calculateCost(int[][] initial, int[][] goal) {
        int count = 0;
        int n = initial.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (initial[i][j] != 0 && initial[i][j] != goal[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
    public int calculateManhattanDistance(int[][] matrix, int[][] goal) {
        int distance = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                if (value != 0) {
                    int goalX = (value - 1) / n;
                    int goalY = (value - 1) % n;
                    distance += Math.abs(i - goalX) + Math.abs(j - goalY);
                }
            }
        }
        return distance;
    }

    public void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isSafe(int x, int y) {
        return (x >= 0 && x < dimension && y >= 0 && y < dimension);
    }

    public void printPath(Node root) {
        if (root == null) {
            return;
        }
        printPath(root.parent);
        printMatrix(root.matrix);
        System.out.println("Level: " + root.level);
        System.out.println();
    }


    public boolean isSolvable(int[][] matrix) {
        int count = 0;
        List<Integer> array = new ArrayList<>();

        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                array.add(ints[j]);
            }
        }

        Integer[] anotherArray = new Integer[array.size()];
        array.toArray(anotherArray);

        for (int i = 0; i < anotherArray.length - 1; i++) {
            for (int j = i + 1; j < anotherArray.length; j++) {
                if (anotherArray[i] != 0 && anotherArray[j] != 0 && anotherArray[i] > anotherArray[j]) {
                    count++;
                }
            }
        }

        return count % 2 == 0;
    }

    public Set<Node> solve(int[][] initial, int[][] goal, int x, int y) {
        PriorityQueue<Node> pq = new PriorityQueue<>(1000, Comparator.comparingInt(a -> (a.cost + a.level + a.estimatedCost)));
        Node root = new Node(initial, x, y, x, y, 0, null, calculateManhattanDistance(initial, goal));
        root.cost = calculateCost(initial, goal);
        pq.add(root);

        Set<String> visitedStates = new HashSet<>();
        Set<Node> solutionPaths = new HashSet<>();

        while (!pq.isEmpty()) {
            Node min = pq.poll();
            if (min.cost == 0) {
                // Check if the state has been visited before
                String stateKey = Arrays.deepToString(min.matrix);
                if (!visitedStates.contains(stateKey)) {
                    visitedStates.add(stateKey);
                    solutionPaths.add(min);
                    printPath(min);
                }
            }

            for (int i = 0; i < 4; i++) {
                if (isSafe(min.x + row[i], min.y + col[i])) {
                    Node child = new Node(
                            min.matrix,
                            min.x,
                            min.y,
                            min.x + row[i],
                            min.y + col[i],
                            min.level + 1,
                            min,
                            calculateManhattanDistance(min.matrix, goal) // Calculate heuristic cost
                    );
                    child.cost = calculateCost(child.matrix, goal);
                    pq.add(child);
                }
            }
        }

        return solutionPaths;
    }

    public static void main(String[] args) {
        int[][] initial = {{1, 8, 2}, {0, 4, 3}, {7, 6, 5}};
        int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int x = 1, y = 0;
        EightPuzzleSolver puzzle = new EightPuzzleSolver();
        if (puzzle.isSolvable(initial)) {
            Set<Node> set = puzzle.solve(initial, goal, x, y);
            List<Node> solutionPaths = new ArrayList<>(set);
            for (int i = 0; i < solutionPaths.size(); i++) {
                System.out.println("Solution Path " + (i + 1) + ":");
                Node solutionNode = solutionPaths.get(i);
                puzzle.printPath(solutionNode);
                int estimatedCost = solutionNode.level;
                System.out.println("Estimated Cost (Number of Moves): " + estimatedCost);
                System.out.println();
            }
            if (solutionPaths.size() > 1) {
                System.out.println("Alternative Solution Paths:");
                for (int i = 1; i < solutionPaths.size(); i++) {
                    System.out.println("Alternative Path " + i + ":");
                    puzzle.printPath(solutionPaths.get(i));
                }
            }
        } else {
            System.out.println("The given initial state is impossible to solve.");
        }
    }
}
