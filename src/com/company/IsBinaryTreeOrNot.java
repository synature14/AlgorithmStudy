/*
class Tree {
    class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }
    Node root;
    int size;
    Tree(int size) {
        this.size = size;
        root = makeBinarySearchNode(0, size-1);
    }

    Node makeBinarySearchNode(int start, int end) {
        if (start > end) return null;       // 종료조건

        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBinarySearchNode(start, mid-1);
        node.right = makeBinarySearchNode(mid+1, end);
        return node;
    }

    boolean isBinaryTree() {
        int[] array = new int[size];
        inorder(root, array);

        for(int i=0; i<size-1; i++) {
            if(array[i] > array[i+1]) {
                return false;
            }
        }
        return true;
    }

    int index = 0;
    void inorder(Node root, int[] array) {
        if (root != null) {
            inorder(root.left, array);      // 왼쪽
            array[index] = root.data;       // 루트
            index++;

            inorder(root.right, array);     // 오른쪽
        }
    }

}


public class IsBinaryTreeOrNot {
    public static void main(String[] args) {
        Tree tree = new Tree(10);
        System.out.println("using Inorder: " + tree.isBinaryTree());
    }
}
*/