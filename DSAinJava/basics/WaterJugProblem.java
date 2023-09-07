package DSAinJava.basics;
import java.util.*;

public class WaterJugProblem{
    static class Pair {
        int a, b;
        List<Pair> path;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
            path = new ArrayList<>();
        }

        Pair(int a, int b, List<Pair> _path) {
            this.a = a;
            this.b = b;

            path = new ArrayList<>();
            path.addAll(_path);
            path.add(new Pair(this.a, this.b));
        }
    }
    public static void main(String[] args) {
        int x = 4;
        int y = 3;
        int target = 2;
        findAndDisplayPaths(x, y, target);
    }

    private static void findAndDisplayPaths(int x, int y, int target) {
        boolean[][] visited = new boolean[x + 1][y + 1];
        Queue<Pair> queue = new LinkedList<>();
        List<List<Pair>> solutions = new ArrayList<>();

        Pair initialState = new Pair(0, 0);
        initialState.path.add(new Pair(0, 0));
        queue.offer(initialState);

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();

            if (curr.a == target || curr.b == target) {
                if (curr.a == target) {
                    curr.path.add(new Pair(curr.a, 0));
                } else {
                    curr.path.add(new Pair(0, curr.b));
                }
                solutions.add(curr.path);
                continue; //more solutions
            }

            visited[curr.a][curr.b] = true;

            Pair[] newStates = {
                    new Pair(x, curr.b, curr.path),
                    new Pair(curr.a, y, curr.path),
                    new Pair(0, curr.b, curr.path),
                    new Pair(curr.a, 0, curr.path),
                    new Pair(curr.a - Math.min(curr.a, y - curr.b), curr.b + Math.min(curr.a, y - curr.b), curr.path),
                    new Pair(curr.a + Math.min(curr.b, x - curr.a), curr.b - Math.min(curr.b, x - curr.a), curr.path)
            };

            for (Pair newState : newStates) {
                if (newState.a >= 0 && newState.a <= x && newState.b >= 0 && newState.b <= y && !visited[newState.a][newState.b]) {
                    queue.offer(newState);
                }
            }
        }

        if (solutions.isEmpty()) {
            System.out.println("No solution found.");
        } else {
            System.out.println("All solution paths:");
            for (List<Pair> solution : solutions) {
                for (Pair state : solution) {
                    System.out.println(state.a + " , " + state.b);
                }
                System.out.println("----");
            }
        }
    }
}
