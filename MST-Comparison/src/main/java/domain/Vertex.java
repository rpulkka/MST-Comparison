
package domain;

import java.util.PriorityQueue;

public class Vertex {
    
    private int value;
    private PriorityQueue<Edge> edges;
    
    public Vertex(int value) {
        this.value = value;
        this.edges = new PriorityQueue<Edge>();
    }
    
    public void addEdge(Edge e) {
        edges.add(e);
    }
    
    public PriorityQueue<Edge> getEdges() {
        return edges;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
