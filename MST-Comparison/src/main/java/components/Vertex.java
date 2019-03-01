
package components;

import data_structures.EdgeHeap;

/**
 * An abstraction of the vertices in the graph. 
 */
public class Vertex {
    
    private int value;
    private EdgeHeap edges;
    private boolean visited;
    
    public Vertex(int value) {
        this.value = value;
        this.edges = new EdgeHeap(100);
        this.visited = false;
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

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
