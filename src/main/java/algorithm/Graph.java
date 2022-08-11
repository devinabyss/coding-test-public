package algorithm;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
@Getter
public class Graph {

    protected Node[] nodes;
    protected List<Node> useList = new ArrayList<>();

    public Graph(int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    public void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if (!n1.adjacent.contains(n2)) n1.adjacent.add(n2);
        if (!n2.adjacent.contains(n1)) n2.adjacent.add(n1);
    }

    public List<Node> dfs(int startIdx) {

        List<Node> useList = new ArrayList<>();

        Node start = nodes[startIdx];
        start.marked = true;

        Stack<Node> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            for (Node child : cur.adjacent) {
                if (!child.marked) {
                    stack.push(child);
                    child.marked = true;
                }
            }
            useList.add(cur);
        }

        return useList;
    }

    public List<Node> dfsRecursive(int startIdx) {

        List<Node> useList = new ArrayList<>();

        dfsRecursivePriv(startIdx, useList);

        return useList;
    }

    private void dfsRecursivePriv(int startIdx, List<Node> useList) {

        Node cur = nodes[startIdx];
        cur.marked = true;
        useList.add(cur);

        cur.adjacent.stream().filter(node -> !node.marked).forEach(node -> {
            dfsRecursivePriv(node.data, useList);
        });

    }

    public List<Node> bfs(int startIdx) {
        List<Node> useList = new ArrayList<>();

        Node start = nodes[startIdx];
        start.marked = true;

        Queue<Node> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            cur.marked = true;

            for (Node node : cur.adjacent) {
                if (!node.marked) {
                    node.marked = true;
                    queue.add(node);
                }
            }

            useList.add(cur);
        }


        return useList;

    }


    static class Node {
        int data;
        LinkedList<Node> adjacent;
        boolean marked;

        Node(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }

        public String toString() {
            return String.valueOf(data);
        }
    }


}

