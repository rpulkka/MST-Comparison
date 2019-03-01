
package components;

import data_structures.ObjectList;

/**
 * The Component class represents the the components that are used in Boruvka's
 * algorithm. The algorithm divides forms components from the vertices and the
 * edges between them and merges them into bigger components in the cheapest
 * way that is possible. The class includes a parent node and the other vertices
 * that belong to the component.
 */
public class Component {
    
    private int parent;
    private ObjectList vertices;
    private boolean deleted;
    
    public Component(int parent) {
        this.parent = parent;
        this.vertices = new ObjectList();
        vertices.add(new Vertex(parent));
        this.deleted = false;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public ObjectList getVertices() {
        return vertices;
    }

    public void setVertices(ObjectList vertices) {
        this.vertices = vertices;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
