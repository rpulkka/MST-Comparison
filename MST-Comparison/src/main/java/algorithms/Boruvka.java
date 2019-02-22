package algorithms;

import domain.Component;
import domain.Edge;
import data_management.GraphData;
import data_structures.EdgeHeap;
import data_structures.ObjectList;
import domain.UnionFind;
import domain.Vertex;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Boruvka's algorithm is implemented in this class.
 */
public class Boruvka {

    private UnionFind unionFind;
    private EdgeHeap[] edges;
    private int numberOfVertices;
    private ObjectList vertices;
    private ArrayList<Component> components;
    private int sumOfEdges;
    private boolean firstLap;

    public Boruvka(int numOfVertices, int numOfEdges) {
        unionFind = new UnionFind(numOfVertices);
        numberOfVertices = numOfVertices;
        edges = new EdgeHeap[numOfVertices];
        vertices = new ObjectList();
        components = new ArrayList<Component>();
        sumOfEdges = 0;
        firstLap = true;

        for (int i = 1; i <= numberOfVertices; i++) {
            vertices.add(i);
            components.add(new Component(i));
        }
    }

    public int execute(GraphData graphData) {
        if(graphData.getNumberOfVertices() == 0) {
            return 0;
        }
        
        for (int i = 0; i < numberOfVertices; i++) {
            edges[i] = new EdgeHeap(10000);
        }

        initComponents(graphData);

        while (components.size() > 1) {
            ArrayList<Edge> addedEdges = newEdges();
            if (addedEdges.size() == 0) {
                return sumOfEdges;
            }
            mergeComponents(addedEdges);
        }

        return sumOfEdges;
    }

    public void initComponents(GraphData graphData) {
        for (int i = 0; i < graphData.getCounter(); i++) {
            Vertex vertexS = (Vertex) components.get(graphData.getSourceOf(i) - 1).getVertices().get(0);
            Vertex vertexD = (Vertex) components.get(graphData.getDestinationOf(i) - 1).getVertices().get(0);
            if(vertexS.getEdges().contains(new Edge(graphData.getSourceOf(i), graphData.getDestinationOf(i), graphData.getValueOf(i)))) {
                continue;
            }
//            if(components.get(graphData.getDestinationOf(i) - 1).getVertices().get(0).getEdges().contains(new Edge(graphData.getDestinationOf(i), graphData.getSourceOf(i), graphData.getValueOf(i)))) {
//                continue;
//            }
            vertexS.addEdge(new Edge(graphData.getSourceOf(i), graphData.getDestinationOf(i), graphData.getValueOf(i)));
            vertexD.addEdge(new Edge(graphData.getDestinationOf(i), graphData.getSourceOf(i), graphData.getValueOf(i)));
        }
    }

    public ArrayList<Edge> newEdges() {
        ArrayList<Edge> addedEdges = new ArrayList<Edge>();
        for (Component component : components) {
            if (component.isDeleted()) {
                continue;
            }
            PriorityQueue<Edge> smallestEdges = new PriorityQueue<Edge>();
            for(int i = 0; i < component.getVertices().size(); i++) {
                Vertex vertex = (Vertex) component.getVertices().get(i);
                Edge smallestEdgeOfVertex = null;
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
                addedEdges = new ArrayList<Edge>();
                return addedEdges;
            }
            Edge smallest = smallestEdges.poll();
            addedEdges.add(smallest);
        }
        firstLap = false;
        return addedEdges;
    }

    public void mergeComponents(ArrayList<Edge> addedEdges) {
        for (Edge edge : addedEdges) {
            if (this.unionFind.sameParent(edge.getStart(), edge.getEnd())) {
                continue;
            }
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
            
            ObjectList migration = components.get(source - 1).getVertices();
            for (int i = 0; i < migration.size(); i++) {
                components.get(destination - 1).getVertices().add((Vertex)migration.get(i));
            }
            components.get(source - 1).setDeleted(true);
            sumOfEdges += edge.getLength();
        }
    }
}
