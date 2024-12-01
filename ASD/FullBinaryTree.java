public class FullBinaryTree {

    static class Node {
        String data;
        Node left, right;

        public Node(String data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node("Akar");
        root.left = new Node("Cabang1");
        root.right = new Node("Cabang2");

        root.left.left = new Node("Cabang3");
        root.left.right = new Node("Cabang4");
        root.right.left = new Node("Cabang5");
        root.right.right = new Node("Cabang6");

        root.left.left.left = new Node("Daun1");
        root.left.left.right = new Node("Daun2");
        root.left.right.left = new Node("Daun3");
        root.left.right.right = new Node("Daun4");
        root.right.left.left = new Node("Daun5");
        root.right.left.right = new Node("Daun6");
        root.right.right.left = new Node("Daun7");
        root.right.right.right = new Node("Daun8");

        root.left.left.left.left = new Node("Daun9");
        root.left.left.left.right = new Node("Daun10");
        root.left.left.right.left = new Node("Daun11");
        root.left.left.right.right = new Node("Daun12");
        root.left.right.left.left = new Node("Daun13");
        root.left.right.left.right = new Node("Daun14");
        root.left.right.right.left = new Node("Daun15");
        root.left.right.right.right = new Node("Daun16");
        root.right.left.left.left = new Node("Daun17");
        root.right.left.left.right = new Node("Daun18");
        root.right.left.right.left = new Node("Daun19");
        root.right.left.right.right = new Node("Daun20");
        root.right.right.left.left = new Node("Daun21");
        root.right.right.left.right = new Node("Daun22");
        root.right.right.right.left = new Node("Daun23");
        root.right.right.right.right = new Node("Daun24");

        printTree(root, 0);
    }

    public static void printTree(Node node, int level) {
        if (node == null) return;
        System.out.println(" ".repeat(level * 4) + node.data);
        printTree(node.left, level + 1);
        printTree(node.right, level + 1);
    }
}
