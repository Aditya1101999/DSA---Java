package DSAinJava.basics;
import java.util.*;
public class FWGCProblem {

    private final String[] moves = { "F", "FW", "FS", "FC" };
    private final ArrayList<Node> queue;
    private ArrayList<Node> solutions;
    private Node root;

    public FWGCProblem() {
        queue = new ArrayList<>();
        solutions = new ArrayList<>();
    }

    private record State(String bank, TreeSet<String> left, TreeSet<String> right) {

        private boolean checkAllowBank(TreeSet<String> b) {
                return (!b.contains("W") || !b.contains("S") || (b.contains("F"))) && (!b.contains("S") || !b.contains("C") || (b.contains("F")));
            }

            public boolean isAllow() {
                return checkAllowBank(left) && checkAllowBank(right);
            }

            public boolean isSolution() {
                return left.isEmpty() && right.contains("W") && right.contains("S") && right.contains("C")
                        && right.contains("F");
            }

            public State transits(String move) {
                String nbank;
                TreeSet<String> nleft = new TreeSet<>();
                TreeSet<String> nright = new TreeSet<>();

                if (bank.equalsIgnoreCase("left"))
                    nbank = "right";
                else
                    nbank = "left";

                copylist(right, nright);
                copylist(left, nleft);

                for (int i = 0; i < move.length(); i++) {
                    String item = move.substring(i, i + 1);
                    if (bank.equalsIgnoreCase("left")) {
                        if (nleft.remove(item))
                            nright.add(item);
                        else
                            return null;
                    } else {
                        if (nright.remove(item))
                            nleft.add(item);
                        else
                            return null;
                    }
                }
                return new State(nbank, nleft, nright);
            }

            private void copylist(TreeSet<String> src, TreeSet<String> dst) {
                dst.addAll(src);
            }

            public boolean compare(State s) {
                TreeSet<String> temp;
                if (!s.bank().equalsIgnoreCase(bank))
                    return false;

                temp = s.left();
                for (String e : left) {
                    if (!temp.contains(e))
                        return false;
                }
                temp = s.right();
                for (String e : right) {
                    if (!temp.contains(e))
                        return false;
                }
                return true;
            }

            @Override
            public String toString() {
                StringBuilder ret = new StringBuilder();
                ret.append("{L:");
                for (String e : left)
                    ret.append(e);

                ret.append(" ");
                ret.append("R:");

                for (String e : right)
                    ret.append(e);

                ret.append("}");
                return ret.toString();
            }

        }

    private static class Node {
        public Node parent;
        public State data;
        public ArrayList<Node> adj;
        public int level;
        public String move;


        public Node(State data) {
            parent = null;
            this.data = data;
            adj = new ArrayList<>();
            level = 0;
            move = "";
        }

        public boolean isAncestor() {
            Node n = parent;
            boolean flag = false;
            while (n != null) {
                if (data.compare(n.data)) {
                    flag = true;
                    break;
                }
                n = n.parent;
            }

            return flag;
        }

    }

    public void startBreadthFirstSearch() {
        solutions = new ArrayList<>();
        TreeSet<String> left = new TreeSet<>();
        left.add("W");
        left.add("S");
        left.add("C");
        left.add("F");

        State inits = new State("left", left, new TreeSet<>());
        root = new Node(inits);
        root.level = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            Node n = queue.remove(0);
            System.out.println("Processing Level " + n.level + " " + n.data);
            for (String m : moves) {

                State s = n.data.transits(m);

                if (s != null && s.isAllow()) {
                    Node child = new Node(s);
                    child.parent = n;
                    child.level = n.level + 1;
                    child.move = m + " moves " + child.data.bank();

                    if (!child.isAncestor()) {
                        n.adj.add(child);

                        if (!child.data.isSolution()) {
                            queue.add(child);
                            System.out.println("Adding state " + child.data);
                        } else {
                            solutions.add(child);
                            System.out.println("Found solution " + child.data);

                        }
                    }
                }
            }
        }
    }

    public void printBFSGraph() {
        ArrayList<Node> queue = new ArrayList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            Node n = queue.remove(0);
            System.out.println("Level " + n.level + " " + n.data);

            ArrayList<Node> adj = n.adj;
            queue.addAll(adj);
        }
    }

    public void printSolution() {
        System.out.println("No. of solutions:  " + solutions.size());
        ArrayList<Node> stack;

        Iterator<Node> it = solutions.iterator();
        int i = 1;
        while (it.hasNext()) {
            stack = new ArrayList<>();
            Node n = it.next();
            stack.add(n);

            n = n.parent;
            while (n != null) {
                stack.add(n);
                n = n.parent;
            }
            System.out.println("Solution " + i);
            printSequence(stack);
            i++;
        }
    }

    private void printSequence(ArrayList<Node> stack) {
        StringBuilder buf = new StringBuilder();
        buf.append("No. of moves: ");
        buf.append(stack.size() - 1);
        buf.append("\n");
        for (int i = stack.size() - 1; i >= 0; i--) {
            Node n = stack.get(i);
            buf.append(n.data.toString());
            if (i != 0) {
                buf.append("--");
                buf.append(stack.get(i - 1).move);
                buf.append("->>");
            }
        }

        System.out.println(buf);
    }

    public static void main(String[] args) {
        FWGCProblem obj = new FWGCProblem();

        System.out.println("Creating State Graph using Breadth First Search");
        obj.startBreadthFirstSearch();

        System.out.println("\n\nState Graph in Breadth first order");
        obj.printBFSGraph();
        System.out.println("\n\n");

        System.out.println("Solutions to the River Crossing Puzzle BFS");
        obj.printSolution();
    }
}
