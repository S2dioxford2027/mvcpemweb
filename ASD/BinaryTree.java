import java.util.*;

class Node {
    int data;
    Node nodeKiri, nodeKanan;

    public Node(int data) {
        this.data = data;
        nodeKiri = nodeKanan = null;
    }
}

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }

    public void buildTree(int[] values, int[] parents) {
        Node[] nodes = new Node[values.length];
        for (int i = 0; i < values.length; i++) {
            nodes[i] = new Node(values[i]);
        }

        for (int i = 0; i < values.length; i++) {
            if (parents[i] == 0) {
                root = nodes[i];
            } else {
                Node parent = nodes[parents[i] - 1];
                if (parent.nodeKiri == null) {
                    parent.nodeKiri = nodes[i];
                } else {
                    parent.nodeKanan = nodes[i];
                }
            }
        }
    }

    public void preorderTraversal(List<Integer> result) {
        preorder(root, result);
    }

    private void preorder(Node node, List<Integer> result) {
        if (node == null) return;
        result.add(node.data);
        preorder(node.nodeKiri, result);
        preorder(node.nodeKanan, result);
    }

    public void inorderTraversal(List<Integer> result) {
        inorder(root, result);
    }

    private void inorder(Node node, List<Integer> result) {
        if (node == null) return;
        inorder(node.nodeKiri, result);
        result.add(node.data);
        inorder(node.nodeKanan, result);
    }

    public void postorderTraversal(List<Integer> result) {
        postorder(root, result);
    }

    private void postorder(Node node, List<Integer> result) {
        if (node == null) return;
        postorder(node.nodeKiri, result);
        postorder(node.nodeKanan, result);
        result.add(node.data);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] values = new int[n];
        int[] parents = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        for (int i = 0; i < n; i++) {
            parents[i] = scanner.nextInt();
        }

        BinaryTree tree = new BinaryTree();
        tree.buildTree(values, parents);

        List<Integer> preOrderResult = new ArrayList<>();
        List<Integer> inOrderResult = new ArrayList<>();
        List<Integer> postOrderResult = new ArrayList<>();

        tree.preorderTraversal(preOrderResult);
        tree.inorderTraversal(inOrderResult);
        tree.postorderTraversal(postOrderResult);

        System.out.println(join(preOrderResult));
        System.out.println(join(inOrderResult));
        System.out.println(join(postOrderResult));

        scanner.close();
    }

    private static String join(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) sb.append(" ");
        }
        return sb.toString();
    }
}

