
package domain;

import java.util.ArrayList;

public class Component {
    
    private int parent;
    private ArrayList<Vertex> vertices;
    private boolean deleted;
    
    public Component(int parent) {
        this.parent = parent;
        this.vertices = new ArrayList<Vertex>();
        vertices.add(new Vertex(parent));
        this.deleted = false;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public ArrayList<Vertex> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertex> vertices) {
        this.vertices = vertices;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
