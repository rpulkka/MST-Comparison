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
    private Edge error;
    boolean found;

    public Boruvka(int numOfVertices, int numOfEdges) {
        unionFind = new UnionFind(numOfVertices);
        numberOfVertices = numOfVertices;
        edges = new PriorityQueue[numOfEdges];
        vertices = new ArrayList<Integer>();
        components = new ArrayList<Component>();
        sumOfEdges = 0;
        found = false;

        for (int i = 1; i <= numberOfVertices; i++) {
            vertices.add(i);
            components.add(new Component(i));
        }

        error = null;
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
            components.get(graphData.getSourceOf(i) - 1).getVertices().get(0).
                    addEdge(new Edge(graphData.getSourceOf(i), graphData.getDestinationOf(i), graphData.getValueOf(i)));
            components.get(graphData.getDestinationOf(i) - 1).getVertices().get(0).
                    addEdge(new Edge(graphData.getDestinationOf(i), graphData.getSourceOf(i), graphData.getValueOf(i)));
        }
    }

    public ArrayList<Edge> newEdges() {
        System.out.println("");
        System.out.println("adding");
        ArrayList<Edge> addedEdges = new ArrayList<Edge>();
        for (Component component : components) {
            if (component.isDeleted()) {
                continue;
            }
            PriorityQueue<Edge> smallestEdges = new PriorityQueue<Edge>();
            for (Vertex vertex : component.getVertices()) {
                System.out.println("new vertex");
                if (addedEdges.contains(error)) {
                    System.out.println("CONTAINS ERROR");
                }
                Edge smallestEdgeOfVertex = null;
                while (!vertex.getEdges().isEmpty()) {
                    Edge peeked = vertex.getEdges().peek();
                    if (peeked.getStart() == 17 && peeked.getEnd() == 13) {
                        System.out.println("!!!!!!!! FOUND IT");
                        error = peeked;
                        found = true;
                    }
                    if (this.unionFind.sameParent(peeked.getStart(), peeked.getEnd())) {
                        vertex.getEdges().poll();
                        System.out.println("discarded " + "s " + peeked.getStart() + " e " + peeked.getEnd() + " l " + peeked.getLength());
                        continue;
                    } else {
                        smallestEdgeOfVertex = peeked;
                        System.out.println("chosen " + "s " + smallestEdgeOfVertex.getStart() + " e " + smallestEdgeOfVertex.getEnd() + " l " + smallestEdgeOfVertex.getLength());
                        break;
                    }
                }
                if (smallestEdgeOfVertex != null) {
                    smallestEdges.add(smallestEdgeOfVertex);
                }
            }

            if (smallestEdges.isEmpty()) {
                addedEdges = new ArrayList<Edge>();
                return addedEdges;
            }
            for (Edge edge : smallestEdges) {
                System.out.println("contenders " + "s " + edge.getStart() + " e " + edge.getEnd() + " l " + edge.getLength());
            }
            Edge smallest = smallestEdges.poll();
            addedEdges.add(smallest);
            System.out.println("smallest " + "s " + smallest.getStart() + " e " + smallest.getEnd() + " l " + smallest.getLength());
        }

        for (Edge edge : addedEdges) {
            if (edge.getStart() == 17 && edge.getEnd() == 13) {
                System.out.println("FOUND IT");
            }
        }
        return addedEdges;
    }

    public void mergeComponents(ArrayList<Edge> addedEdges) {
        System.out.println("");
        System.out.println("merging");
        for (Edge edge : addedEdges) {
            if (this.unionFind.sameParent(edge.getStart(), edge.getEnd())) {
                //System.out.println("discarded: " + "s " + edge.getStart() + " e " + edge.getEnd() + " l " + edge.getLength());
                continue;
            }
            //System.out.println("processed: " + "s " + edge.getStart() + " e " + edge.getEnd() + " l " + edge.getLength());
            int parentA = unionFind.parent(edge.getStart());
            int parentAB = unionFind.addConnection(edge.getStart(), edge.getEnd());
            int source;
            int destination;
            if (parentAB == parentA) {
                destination = edge.getStart();
                source = edge.getEnd();
            } else {
                destination = edge.getEnd();
                source = edge.getStart();
            }

            ArrayList<Vertex> migration = components.get(source - 1).getVertices();
            for (Vertex v : migration) {
                components.get(destination - 1).getVertices().add(v);
            }
            components.get(source - 1).setDeleted(true);

            System.out.println("s " + edge.getStart() + " e " + edge.getEnd() + " l " + edge.getLength());

            sumOfEdges += edge.getLength();

        }
    }
}
