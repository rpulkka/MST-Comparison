package algorithms;

import components.Edge;
import components.Vertex;
import data_management.GraphData;
import data_structures.EdgeHeap;
import data_structures.ObjectList;

/**
 * Prim's algorithm is implemented in this class.
 */
public class Prim {

    int numberOfVertices;
    int numberOfEdges;
    ObjectList[] edgesFromStart;
    int[] indexOf;

    public Prim(int numberOfVertices, int numberOfEdges) {
        this.numberOfVertices = numberOfVertices;
        this.numberOfEdges = numberOfEdges;
        this.edgesFromStart = new ObjectList[numberOfVertices];
        this.indexOf = new int[numberOfVertices];
    }

    public int execute(GraphData graphData) {
        if (graphData.getNumberOfVertices() == 0) {
            return 0;
        }

        initEdges(graphData);

        //Set of vertices.
        Vertex[] vertices = graphData.getVertices();

        //Priority queue for the edge options that are currently reachable.
        EdgeHeap edgeHeap = new EdgeHeap(numberOfEdges * 2);

        int sumOfEdges = 0;

        //Start from the first existing vertex.
        int firstVertex = 1;
        while (true) {
            if (!graphData.getVertexSet().contains(firstVertex)) {
                firstVertex++;
            } else {
                break;
            }
        }
        vertices[firstVertex].setVisited(true);
        for (int i = 0; i < edgesFromStart[0].size(); i++) {
            edgeHeap.add((Edge) edgesFromStart[0].get(i));
        }

        Edge smallest;
        while (true) {
            //When there's no reachable edge left, return the sum.
            if (edgeHeap.isEmpty()) {
                return sumOfEdges;
            }
            //Poll the smallest reachable edge and if the destination vertex is
            //already visited, discard the edge, else add the edge's length
            //to the sum and add the destination vertex to visited list and
            //then add new edge options to the priority queue.
            smallest = edgeHeap.poll();
            if (vertices[smallest.getEnd()].isVisited()) {
                continue;
            } else {
                sumOfEdges += smallest.getLength();
                vertices[smallest.getEnd()].setVisited(true);
                for (int i = 0; i < edgesFromStart[smallest.getEnd() - 1].size(); i++) {
                    edgeHeap.add((Edge) edgesFromStart[smallest.getEnd() - 1].get(i));
                }
            }
        }
    }

    public void initEdges(GraphData graphData) {
        for (int i = 0; i < edgesFromStart.length; i++) {
            edgesFromStart[i] = new ObjectList();
        }

        for (int i = 0; i < graphData.getCounter(); i++) {
            edgesFromStart[graphData.getSourceOf(i) - 1].add(new Edge(graphData.getSourceOf(i), graphData.getDestinationOf(i), graphData.getValueOf(i)));
            edgesFromStart[graphData.getDestinationOf(i) - 1].add(new Edge(graphData.getDestinationOf(i), graphData.getSourceOf(i), graphData.getValueOf(i)));
        }
    }
}
