public class SkewedBinaryTree {

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
        root.right = new Node("Cabang1");
        root.right.right = new Node("Cabang2");
        root.right.right.right = new Node("Cabang3");
        root.right.right.right.right = new Node("Cabang4");

        printTree(root, 0);
    }

    public static void printTree(Node node, int level) {
        if (node == null) return;
        System.out.println(" ".repeat(level * 4) + node.data);
        printTree(node.left, level + 1);
        printTree(node.right, level + 1);
    }
}
