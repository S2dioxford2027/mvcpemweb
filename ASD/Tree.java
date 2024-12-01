import java.util.*;

public class Tree<T> {
    Node<T> root;

    public Tree(Node<T> root){
        this.root = root;
    }

    public Tree (T data){
        root = new Node<T>(data);
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void add (T dataParent, T data) {
        Node<T> node = getNode(root, dataParent);
        if (node != null)
            node.childs.add(new Node(data));
        else
            System.out.println("Mode Parent tidak ditemukan");
    }

    public Node getNode (Node<T> node, T data) {
        if (node.data.equals(data))
            return node;

        for (Object currNode : node.childs) {
            Node<T> returnNode = getNode((Node) currNode, data);
            if (returnNode != null)
                return returnNode;
        }

        return null;
    }

    public void access(){
        System.out.print(root.data);
        access(root, " ");
    }

    private void access(Node<T> node, String space){
        System.out.println("");
        for (Object currNode: node.childs){
            System.out.print(space + "->" + ((Node) currNode).data);
            access((Node) currNode, space + " ");
        }
        return;
    }
}

class Node<T>{
    T data;
    List<Node> childs;

    public Node(T data){
        this.data = data;
        childs = new LinkedList<Node>();
    }
}