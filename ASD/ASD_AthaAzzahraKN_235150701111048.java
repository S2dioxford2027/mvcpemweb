import java.util.Arrays;

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        this.key = item;
        this.left = null;
        this.right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);
        return root;
    }

    void printTree() {
        printTreeRec(root, "", true);
    }

    void printTreeRec(Node root, String indent, boolean isRight) {
        if (root != null) {
            printTreeRec(root.right, indent + (isRight ? "        " : " |      "), true);
            System.out.println(indent + (isRight ? " /-- " : " \\-- ") + root.key);
            printTreeRec(root.left, indent + (isRight ? " |      " : "        "), false);
        }
    }
}

class MaxHeap {
    private final int[] heap;
    private int size;
    private final int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[this.maxSize + 1];
        this.heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private void swap(int fpos, int spos) {
        int tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    public void insert(int element) {
        if (size >= maxSize) {
            System.out.println("Heap penuh");
            return;
        }
        heap[++size] = element;
        int current = size;
        while (heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void printHeap() {
        System.out.println(Arrays.toString(Arrays.copyOfRange(heap, 1, size + 1)));
    }
}

public class ASD_AthaAzzahraKN_235150701111048 {
    public static void main(String[] args) {
        int[] numbers = {13, 4, 7, 21, 15, 25, 31, 9, 43};

        MaxHeap maxHeap = new MaxHeap(numbers.length);
        for (int num : numbers) {
            maxHeap.insert(num);
        }
        System.out.print("Heap Tree: ");
        maxHeap.printHeap();

        BinarySearchTree bst = new BinarySearchTree();
        for (int num : numbers) {
            bst.insert(num);
        }
        System.out.println("BST dalam bentuk pohon:");
        bst.printTree();
    }
}
