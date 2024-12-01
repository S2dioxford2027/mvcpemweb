import java.util.LinkedList;
import java.util.List;

public class AthaAzzahraKhairunNisa_235150701111048<T> {
    Node<T> root;

    public AthaAzzahraKhairunNisa_235150701111048(Node<T> root) {
        this.root = root;
    }

    public AthaAzzahraKhairunNisa_235150701111048(T data) {
        root = new Node<>(data);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(T dataParent, T data) {
        Node<T> node = getNode(root, dataParent);
        if (node != null) {
            node.childs.add(new Node<>(data));
        } else {
            System.out.println("Node Parent tidak ditemukan");
        }
    }

    public Node<T> getNode(Node<T> node, T data) {
        if (node.data.equals(data)) {
            return node;
        }
        for (Node<T> child : node.childs) {
            Node<T> returnNode = getNode(child, data);
            if (returnNode != null) {
                return returnNode;
            }
        }
        return null;
    }

    public void access() {
        System.out.print(root.data);
        access(root, " ");
    }

    private void access(Node<T> node, String space) {
        System.out.println();
        for (Node<T> currNode : node.childs) {
            System.out.print(space + " -> " + currNode.data);
            access(currNode, space + " ");
        }
        return;
    }

    public static void main(String[] args) {
        AthaAzzahraKhairunNisa_235150701111048<String> tree = new AthaAzzahraKhairunNisa_235150701111048<>("A");
        tree.add("A", "B");
        tree.add("A", "C");
        tree.add("B", "D");
        tree.add("B", "E");
        tree.add("C", "F");
        tree.add("C", "G");

        tree.access();
    }
}

class Node<T> {
    T data;
    List<Node<T>> childs;

    public Node(T data) {
        this.data = data;
        childs = new LinkedList<>();
    }
}
