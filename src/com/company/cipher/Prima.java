package com.company.cipher;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Prima {
    private static class Edge {
        private int a;
        private int b;
        private int weight;

        public Edge(int a, int b, int weight) {
            this.a = a;
            this.b = b;
            this.weight = weight;
        }

        public Edge(Edge edge) {
            this.a = edge.a;
            this.b = edge.b;
            this.weight = edge.weight;
        }

        public int getV() {
            return a;
        }

        public int getW() {
            return b;
        }

        public int getWeight() {
            return weight;
        }

        public int getOther(int x) {
            assert x == a || x == b;
            return x == a ? b : a;
        }

        @Override
        public String toString() {
            return String.format("%d-%d: %d", a, b, weight);
        }

    }


    private int vertexNum;

    private int edgeNum;

    private List<Edge>[] graph;

    private boolean directed;

    public  Prima(int vertexNum, boolean directed) {
        this.vertexNum = vertexNum;
        this.directed = directed;
        graph = (LinkedList<Edge>[]) new LinkedList[vertexNum];
        for (int i = 0; i < vertexNum; i++) {
            graph[i] = new LinkedList<Edge>();
        }
    }

    public int getVertexNum() {
        return vertexNum;
    }

    public int getEdgeNum() {
        return edgeNum;
    }

    public List<Edge>[] getGraph() {
        return graph;
    }
    public void addEdge(int w, int v, int weight) {
        assert w >= 0 && w < vertexNum && v >= 0 && v < vertexNum;

        List<Edge> edges1 = graph[w];
        Edge newEdge1 = new Edge(w, v, weight);
        edges1.add(newEdge1);
        if (!directed) {
            List<Edge> edges2 = graph[v];
            Edge newEdge2 = new Edge(v, w, weight);
            edges2.add(newEdge2);
        }
        edgeNum++;
    }
    public void print() {
        System.out.println(String.format("Количество вершин:% d, Количество ребер:% d", vertexNum, edgeNum));
        for (int i = 0; i < graph.length; i++) {
            List<Edge> edges = graph[i];
            Iterator<Edge> iterator = edges.iterator();
            StringBuilder str = new StringBuilder(i + "-\t");
            while (iterator.hasNext()) {
                Edge edge = iterator.next();
                System.out.println(String.format("%d - %d : %d", edge.a, edge.b, edge.weight));
            }
        }
    }
}
