import java.util.Scanner;
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
        root = makeBinaryTree(1, size);
    }

    Node makeBinaryTree(int start, int end) {
        // 종료조건
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBinaryTree(start, mid - 1);
        node.right = makeBinaryTree(mid + 1, end);
        return node;
    }

    void isBinaryTree() {
        int[] array = new int[size];    // preorder 데이터 담을 빈배열 준비
        preorder(root, array);

        for(int i=0; i<size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    int index = 0;
    void preorder(Node root, int[] array) {
        if(root != null) {
            array[index] = root.data;       // root
            index++;
            preorder(root.left, array);     // left
            preorder(root.right, array);    // right
        }
    }
}


public class isBinaryTree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int level = scan.nextInt();
        int size = (int) Math.pow(2, level) - 1;
        Tree tree = new Tree(size);
        tree.isBinaryTree();
    }
}
*/
