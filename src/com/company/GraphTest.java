package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
    class Node {
        int data;
        LinkedList<Node> adjacentNode;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacentNode = new LinkedList<Node>();
        }
    }

    Node[] nodes;

    Graph(int size) {
        nodes = new Node[size];
        for (int i=0; i<size; i++) {
            nodes[i] = new Node(i);     // 0 ~ size-1까지의 데이터를 가진 노드 생성
        }
    }

    // 노드의 관계를 저장하는 함수
    void addEdge(int index1, int index2) {
        Node n1 = nodes[index1];
        Node n2 = nodes[index2];

        if(!n1.adjacentNode.contains(n2)) {
            n1.adjacentNode.add(n2);
        }
        if (!n2.adjacentNode.contains(n1)) {
            n2.adjacentNode.add(n1);
        }
    }

    // DFS
    void dfs() {
        dfs(0);
    }

    void dfs(int index) {
        Node root = nodes[index];
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        root.marked = true;

        // stack에 데이터가 없을때지 반복
        while(!stack.isEmpty()) {
            Node node = stack.pop();
            for (Node child : node.adjacentNode) {
                if (child.marked == false) {    // stack에 추가되지 않은 노드들만 추가함
                    child.marked = true;
                    stack.push(child);
                }
            }
            printVisit(node);
        }
    }


    // BFS
    void bfs() {
        bfs(0);
    }

    void bfs(int index) {
        Node root = nodes[index];
        Queue<Node> queue = new LinkedList<Node>();
        root.marked = true;
        queue.add(root);

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            for(Node neighbor: node.adjacentNode) {
                if(neighbor.marked == false) {
                    neighbor.marked = true;
                    queue.add(neighbor);
                }
            }
            printVisit(node);
        }
    }

    // 재귀함수 DFS
    void recursiveDFS(Node node) {
        if (node == null) return;   // 종료조건

        node.marked = true;
        printVisit(node);

        for(Node child : node.adjacentNode) {
            if (child.marked == false) {
                recursiveDFS(child);
            }
        }
    }

    void callDFS(int index) {
        Node startNode = nodes[index];
        recursiveDFS(startNode);
    }

    void printVisit(Node node) {
        System.out.println("Visited : " + node.data);
    }
}


public class GraphTest {
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0,1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

        graph.callDFS(3);
    }
}