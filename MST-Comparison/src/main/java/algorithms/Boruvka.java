package algorithms;

import domain.Component;
import domain.Edge;
import data_management.GraphData;
import domain.UnionFind;
import domain.Vertex;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Boruvka's algorithm is implemented in this class.
 */
public class Boruvka {

    private UnionFind unionFind;
    private PriorityQueue<Edge>[] edges;
    private int numberOfVertices;
    private ArrayList<Integer> vertices;
    private ArrayList<Component> components;
    private int sumOfEdges;
    private boolean firstLap;

    public Boruvka(int numOfVertices, int numOfEdges) {
        unionFind = new UnionFind(numOfVertices);
        numberOfVertices = numOfVertices;
        edges = new PriorityQueue[numOfEdges];
        vertices = new ArrayList<Integer>();
        components = new ArrayList<Component>();
        sumOfEdges = 0;
        firstLap = true;

        for (int i = 1; i <= numberOfVertices; i++) {
            vertices.add(i);
            components.add(new Component(i));
        }
    }

    public int execute(GraphData graphData) {
        for (int i = 1; i <= numberOfVertices; i++) {
            edges[i] = new PriorityQueue<Edge>();
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
            if(components.get(graphData.getSourceOf(i) - 1).getVertices().get(0).getEdges().contains(new Edge(graphData.getSourceOf(i), graphData.getDestinationOf(i), graphData.getValueOf(i)))) {
                continue;
            }
            if(components.get(graphData.getDestinationOf(i) - 1).getVertices().get(0).getEdges().contains(new Edge(graphData.getDestinationOf(i), graphData.getSourceOf(i), graphData.getValueOf(i)))) {
                continue;
            }
            components.get(graphData.getSourceOf(i) - 1).getVertices().get(0).
                    addEdge(new Edge(graphData.getSourceOf(i), graphData.getDestinationOf(i), graphData.getValueOf(i)));
            components.get(graphData.getDestinationOf(i) - 1).getVertices().get(0).
                    addEdge(new Edge(graphData.getDestinationOf(i), graphData.getSourceOf(i), graphData.getValueOf(i)));
        }
    }

    public ArrayList<Edge> newEdges() {
        ArrayList<Edge> addedEdges = new ArrayList<Edge>();
        for (Component component : components) {
            if (component.isDeleted()) {
                continue;
            }
            PriorityQueue<Edge> smallestEdges = new PriorityQueue<Edge>();
            for (Vertex vertex : component.getVertices()) {
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
                    unionFind.setGroupSize(component.getVertices().get(0).getValue(), 0);
                    if(component.getVertices().get(0).getValue() > 1) {
                        unionFind.addConnection(component.getVertices().get(0).getValue(), component.getVertices().get(0).getValue() - 1);
                    } else {
                        unionFind.addConnection(component.getVertices().get(0).getValue(), component.getVertices().get(0).getValue() + 1);
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

            ArrayList<Vertex> migration = components.get(source - 1).getVertices();
            for (Vertex v : migration) {
                components.get(destination - 1).getVertices().add(v);
            }
            components.get(source - 1).setDeleted(true);
            sumOfEdges += edge.getLength();
        }
    }
}
