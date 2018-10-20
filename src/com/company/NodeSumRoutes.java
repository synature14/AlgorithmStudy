package com.company;

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
    Tree(int size) {
        this.root = makeBinaryTree(0, size-1);
    }

    Node makeBinaryTree(int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        Node node = new Node(mid);
        node.left = makeBinaryTree(start, mid - 1);
        node.right = makeBinaryTree(mid + 1, end);

        return node;
    }

    int countPathsWithSum(int targetSum) {
        return countPathsWithSum(root, targetSum);
    }

    int countPathsWithSum(Node root, int targetSum) {
        if(root == null) return 0;
        int pathsFromRoot = countPathsWithSumStartFrom(root, targetSum, 0);
        int pathsOnLeft = countPathsWithSum(root.left, targetSum);
        int pathsOnRight = countPathsWithSum(root.right, targetSum);

        return pathsFromRoot + pathsOnLeft + pathsOnRight;
    }

    // 특정 노드를 시작점으로 경로의 개수 찾기
    int countPathsWithSumStartFrom(Node currentNode, int targetSum, int currentSum) {
        if (currentNode == null) return 0;      // 트리의 가장 끝에 도착하면 더이상 진행할수없으므로 리턴 0
        // 노드에 도착하면 그 노드의 (데이터 + 현재까지의 합)
        currentSum += currentNode.data;

        int totalPaths = 0;
        if(currentSum == targetSum) {
            totalPaths++;
        }

        totalPaths += countPathsWithSumStartFrom(currentNode.left, targetSum, currentSum);
        totalPaths += countPathsWithSumStartFrom(currentNode.right, targetSum, currentSum);
        return totalPaths;
    }
}

public class NodeSumRoutes {
    public static void main(String[] args) {
        Tree tree = new Tree(10);
        System.out.print(tree.countPathsWithSum(6));
    }
}
