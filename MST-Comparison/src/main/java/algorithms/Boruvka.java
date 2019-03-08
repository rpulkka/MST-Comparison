package algorithms;

import components.Component;
import components.Edge;
import data_management.GraphData;
import data_structures.EdgeHeap;
import data_structures.ObjectList;
import data_structures.UnionFind;
import components.Vertex;

/**
 * Boruvka's algorithm is implemented in this class.
 */
public class Boruvka {

    private UnionFind unionFind;
    private EdgeHeap[] edges;
    private int numberOfVertices;
    private ObjectList vertices;
    private ObjectList components;
    private int sumOfEdges;
    private boolean firstLap;

    public Boruvka(int numOfVertices, int numOfEdges) {
        unionFind = new UnionFind(numOfVertices);
        numberOfVertices = numOfVertices;
        edges = new EdgeHeap[numOfVertices];
        vertices = new ObjectList();
        components = new ObjectList();
        sumOfEdges = 0;
        firstLap = true;

        for (int i = 1; i <= numberOfVertices; i++) {
            vertices.add(i);
            components.add(new Component(i));
        }
    }

    /**
     * Executes the Boruvka's algorithm with the help of newEdges() and
     * mergeComponents() methods.
     * 
     * @param graphData Data source.
     * @see #initComponents(data_management.GraphData) 
     * @see #addedEdges() 
     * @see #mergeComponents(java.util.ArrayList) 
     * @return Returns the sum of edges of the minimum spanning tree.
     */
    public int execute(GraphData graphData) {
        if(graphData.getNumberOfVertices() == 0) {
            return 0;
        }
        
        //Initialize the array of EdgeHeaps. The limit is 10000 edges per 
        //vertice, which might potentially cause problems, but if the limit was
        //the number of edges, there would be outOfMemoryError with the larger
        //test files.
        for (int i = 0; i < numberOfVertices; i++) {
            edges[i] = new EdgeHeap(10000);
        }

        initComponents(graphData);

        //While there are over one components left, find out the smallest edges
        //coming from each component and merge the components based on those
        //edges. Return the sum of edges after there's only one component.
        while (components.size() > 1) {
            ObjectList addedEdges = addedEdges();
            if (addedEdges.size() == 0) {
                return sumOfEdges;
            }
            mergeComponents(addedEdges);
        }

        return sumOfEdges;
    }

    /**
     * Adds all of the edges to the EdgeHeaps of the corresponding components.
     *
     * @param graphData The data source.
     */
    public void initComponents(GraphData graphData) {
        for (int i = 0; i < graphData.getCounter(); i++) {
            Component componentS = (Component) components.get(graphData.getSourceOf(i) - 1);
            Vertex vertexS = (Vertex) componentS.getVertices().get(0);
            Component componentD = (Component) components.get(graphData.getDestinationOf(i) - 1);
            Vertex vertexD = (Vertex) componentD.getVertices().get(0);
            if(vertexS.getEdges().contains(new Edge(graphData.getSourceOf(i), graphData.getDestinationOf(i), graphData.getValueOf(i)))) {
                continue;
            }
            vertexS.addEdge(new Edge(graphData.getSourceOf(i), graphData.getDestinationOf(i), graphData.getValueOf(i)));
            vertexD.addEdge(new Edge(graphData.getDestinationOf(i), graphData.getSourceOf(i), graphData.getValueOf(i)));
        }
    }

    /**
     * Finds out the smallest edges of each component.
     *
     * @return The smallest edges starting from each component.
     */
    public ObjectList addedEdges() {
        ObjectList addedEdges = new ObjectList();
        
        //Loop through each existing component.
        for (int j = 0; j < components.size(); j++) {
            Component component = (Component) components.get(j);
            if (component.isDeleted()) {
                continue;
            }
            
            //Make an EdgeHeap where the smallest edge of each vertex in the
            //component will be placed.
            EdgeHeap smallestEdges = new EdgeHeap(edges.length);
            
            //Loop through each vertex of the component.
            for(int i = 0; i < component.getVertices().size(); i++) {
                Vertex vertex = (Vertex) component.getVertices().get(i);
                Edge smallestEdgeOfVertex = null;
                
                //Peek the smallest edge of this vertex, if it only connects
                //two vertices of the same component, poll it out and continue
                //until an edge which connects two vertices of different 
                //components is found. Peek this edge and add it to the EdgeHeap
                //of smallest edges in the component.
                while (!vertex.getEdges().isEmpty()) {
                    Edge peeked = vertex.getEdges().peek();
                    if (this.unionFind.sameParent(peeked.getStart(), peeked.getEnd())) {
                        vertex.getEdges().poll();
                        continue;
                    } else {
                        smallestEdgeOfVertex = peeked;
                        break;
                    }
                }
                if (smallestEdgeOfVertex != null) {
                    smallestEdges.add(smallestEdgeOfVertex);
                }
            }

            //If no edges that connect to vertices outside the component were 
            //found and it is the first iteration of the algorithm, it means 
            //that the graph itself consists of many components meaning that
            //the graph is defective. Then the component is added to some other
            //component, just to not make the program fail. Else we return the
            //empty list.
            if (smallestEdges.isEmpty()) {
                if(firstLap) {
                    Vertex vertex = (Vertex)component.getVertices().get(0);
                    unionFind.setGroupSize(vertex.getValue(), 0);
                    if(vertex.getValue() > 1) {
                        unionFind.addConnection(vertex.getValue(), vertex.getValue() - 1);
                    } else {
                        unionFind.addConnection(vertex.getValue(), vertex.getValue() + 1);
                    }
                    component.setDeleted(true);
                    continue;
                }
                addedEdges = new ObjectList();
                return addedEdges;
            }
            
            //Poll out the smallest edge of the component and add it to the
            //list of added edges.
            Edge smallest = smallestEdges.poll();
            addedEdges.add(smallest);
        }
        firstLap = false;
        
        //Return the added edges of each component.
        return addedEdges;
    }

    /**
     * Merge the components that are connected by the smallest edges of each
     * component.
     *
     * @param addedEdges The smallest edges starting from each component.
     */
    public void mergeComponents(ObjectList addedEdges) {
        //Loop through the list of added edges.
        for (int i = 0; i < addedEdges.size(); i++) {
            Edge edge  = (Edge) addedEdges.get(i);
            
            //If the edge doesn't connect any different components, continue.
            if (this.unionFind.sameParent(edge.getStart(), edge.getEnd())) {
                continue;
            }
            
            //Before merging, find out which component is bigger and what are
            //the parents of the source component and destination component, to
            //know how to merge them.
            int parentA = unionFind.parent(edge.getStart());
            int parentB = unionFind.parent(edge.getEnd());
            int parentAB = unionFind.addConnection(edge.getStart(), edge.getEnd());
            int source;
            int destination;
            if (parentAB == parentA) {
                destination = parentA;
                source = parentB;
            } else {
                destination = parentB;
                source = parentA;
            }
            
            if(source == destination) {
                continue;
            }
            
            //Migrate the vertices of the source component to the destination
            //component in order to merge the components. Set the source
            //component as deleted. Add the connecting edge's length to the
            //sum.
            Component sourceComponent = (Component) components.get(source - 1);
            Component destinationComponent = (Component) components.get(destination - 1);
            ObjectList migration = sourceComponent.getVertices();
            for (int j = 0; j < migration.size(); j++) {
                destinationComponent.getVertices().add((Vertex)migration.get(j));
            }
            sourceComponent.setDeleted(true);
            sumOfEdges += edge.getLength();
        }
    }
}
