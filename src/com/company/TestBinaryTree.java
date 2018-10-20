/*
class Tree {
    class Node {
        int data;
        Node left;
        Node right;
        Node (int data) {
            this.data = data;
        }
    }

    Node root;

    public void makeTree(int[] a) {
        root = makeSubTree(a, 0, a.length - 1);
    }

    public Node makeSubTree(int[] a, int start, int end) {
        if(start > end) return null;
        int mid = (start + end) / 2;
        Node newNode = new Node(a[mid]);
        newNode.left = makeSubTree(a, start, mid - 1);
        newNode.right = makeSubTree(a, mid + 1, end);
        return newNode;
    }

    public void searchBinaryTree(Node node, int search) {
        if (search > node.data ) {
            System.out.println("Data is bigger than " + node.data);
            searchBinaryTree(node.right, search);
        } else if (search < node.data) {
            System.out.println("Data is smaller than " + node.data);
            searchBinaryTree(node.left, search);
        } else {
            System.out.println("Found out!");
        }
    }
}


public class TestBinaryTree {
    public static void main(String[] args) {
        int[] number = {0, 1, 2, 5, 6, 8, 9, 11, 14};
        Tree tree = new Tree();
        tree.makeTree(number);
        System.out.println("Tree.Root : " + tree.root.data);
        tree.searchBinaryTree(tree.root, 8);
    }
}
//          6
//     1          9
//   0   2      8   11
//         5           14

*/