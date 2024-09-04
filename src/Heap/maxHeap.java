package Heap;
import java.util.*;

public class maxHeap {
    private Node root; // root of the heap

    // constructor
    public maxHeap() {
        root = null;
    }

    public void insert(int data) {
        root = insertRec(root, data);
        heapify(root);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) { // if root node is null
            return new Node(data);
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.left == null) {
                curr.left = new Node(data);
                heapify(curr);
                return root;
            } else if (curr.right == null) {
                curr.right = new Node(data);
                heapify(curr);
                return root;
            }
            queue.add(curr.left);
            queue.add(curr.right);
        }
        heapify(root);
        return root;
    }

    private void heapify(Node node) {
        if (node == null) return;

        Node largest = node;

        if (node.left != null && node.left.data > largest.data) {
            largest = node.left;
        }
        if (node.right != null && node.right.data > largest.data) {
            largest = node.right;
        }

        if (largest != node) {
            int temp = node.data;
            node.data = largest.data;
            largest.data = temp;
            heapify(largest);
        }

    }

    public int peek() {
        return root.data;
    }

    public int remove() {

        if (root == null) {
            throw new RuntimeException("Heap is empty");
        }
        root = removeRec(root);
        return root.data;
    }

    private Node removeRec(Node root) {
        if (root == null) return null;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        Node lastNode = null;
        Node parent = null;
        while (!queue.isEmpty()) {
            lastNode = queue.poll();
            if (lastNode.left != null) {
                parent = lastNode;
                queue.add(lastNode.left);
            }
            if (lastNode.right != null) {
                parent = lastNode;
                queue.add(lastNode.right);
            }
        }
        if (lastNode != null) {
            root.data = lastNode.data;
            if (parent != null && parent.left == lastNode) {
                parent.left = null;
            } else if (parent != null && parent.right == lastNode) {
                parent.right = null;
            }
        } else {
            root = null;
        }

        heapify(root);
        return root;
    }

    private void printRec(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        printRec(root.left);
        printRec(root.right);
    }
    public void print(){
        printRec(root);
    }

}
