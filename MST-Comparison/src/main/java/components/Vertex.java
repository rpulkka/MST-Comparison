
package components;

import data_structures.EdgeHeap;


public class Vertex {
    
    private int value;
    private EdgeHeap edges;
    
    public Vertex(int value) {
        this.value = value;
        this.edges = new EdgeHeap(100);
    }
    
    public void addEdge(Edge e) {
        edges.add(e);
    }
    
    public EdgeHeap getEdges() {
        return edges;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
