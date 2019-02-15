package algorithms;

import domain.Edge;
import data_management.GraphData;
import data_structures.EdgeHeap;
import java.util.ArrayList;

/**
 * Prim's algorithm is implemented in this class.
 */
public class Prim {
    int numberOfVertices;
    int numberOfEdges;
    Edge[][] edgesFromStart;
    int[] indexOf;

    public Prim(int numberOfVertices, int numberOfEdges) {
        this.numberOfVertices = numberOfVertices;
        this.numberOfEdges = numberOfEdges;
        //An array of priority queues, the index represents the source vertex
        //of the edge.
        this.edgesFromStart = new Edge[numberOfVertices][numberOfEdges];
        this.indexOf = new int[numberOfVertices];
    }

    public int execute(GraphData graphData) {
        if (graphData.getNumberOfVertices() == 0) {
            return 0;
        }

        initEdges(graphData);

        //List of visited vertices.
        ArrayList<Integer> visited = new ArrayList<Integer>();

        //Priority queue for the edge options that are currently reachable.
        EdgeHeap priorityQueue = new EdgeHeap(numberOfEdges);

        int sumOfEdges = 0;

        //Start from vertex number 1.
        visited.add(1);
        for (int i = 0; i < indexOf[0] - 1; i++) {
            priorityQueue.add(edgesFromStart[0][i]);
        }

        Edge smallest;
        while (true) {
            //When there's no reachable edge left, return the sum.
            if (priorityQueue.isEmpty()) {
                return sumOfEdges;
            }
            //Poll the smallest reachable edge and if the destination vertex is
            //already visited, discard the edge, else add the edge's length
            //to the sum and add the destination vertex to visited list and
            //then add new edge options to the priority queue.
            smallest = priorityQueue.poll();
            if (visited.contains(smallest.getEnd())) {
                continue;
            } else {
                sumOfEdges += smallest.getLength();
                visited.add(smallest.getEnd());
                for (int i = 0; i < indexOf[smallest.getEnd() - 1]; i++) {
                    priorityQueue.add(edgesFromStart[smallest.getEnd() - 1][i]);
                }
            }
        }
    }

    public void initEdges(GraphData graphData) {
        for (int i = 0; i < graphData.getCounter(); i++) {
            int sourceIndex = indexOf[graphData.getSourceOf(i) - 1];
            int endIndex = indexOf[graphData.getDestinationOf(i) - 1];
            edgesFromStart[graphData.getSourceOf(i) - 1][sourceIndex] = new Edge(graphData.getSourceOf(i), graphData.getDestinationOf(i), graphData.getValueOf(i));
            edgesFromStart[graphData.getDestinationOf(i) - 1][endIndex] = new Edge(graphData.getDestinationOf(i), graphData.getSourceOf(i), graphData.getValueOf(i));
            indexOf[graphData.getSourceOf(i) - 1]++;
            indexOf[graphData.getDestinationOf(i) - 1]++;
        }
    }

//    int numberOfVertices;
//    int numberOfEdges;
//    EdgeHeap[] edgesFromStart;
//
//    public Prim(int numberOfVertices, int numberOfEdges) {
//        this.numberOfVertices = numberOfVertices;
//        this.numberOfEdges = numberOfEdges;
//        //An array of priority queues, the index represents the source vertex
//        //of the edge.
//        this.edgesFromStart = new EdgeHeap[numberOfVertices];
//    }
//
//    public int execute(GraphData graphData) {
//        if (graphData.getNumberOfVertices() == 0) {
//            return 0;
//        }
//
//        initEdges(graphData);
//
//        //List of visited vertices.
//        ArrayList<Integer> visited = new ArrayList<Integer>();
//
//        //Priority queue for the edge options that are currently reachable.
//        EdgeHeap priorityQueue = new EdgeHeap(numberOfEdges + 1);
//
//        int sumOfEdges = 0;
//
//        //Start from vertex number 1.
//        visited.add(1);
//        for (int i = 1; i <= edgesFromStart[0].getSize(); i++) {
//            priorityQueue.add(edgesFromStart[0].getHeap()[i]);
//        }
//
//        Edge smallest;
//        while (true) {
//            //When there's no reachable edge left, return the sum.
//            if (priorityQueue.isEmpty()) {
//                return sumOfEdges;
//            }
//            //Poll the smallest reachable edge and if the destination vertex is
//            //already visited, discard the edge, else add the edge's length
//            //to the sum and add the destination vertex to visited list and
//            //then add new edge options to the priority queue.
//            smallest = priorityQueue.poll();
//            if (visited.contains(smallest.getEnd())) {
//                continue;
//            } else {
//                sumOfEdges += smallest.getLength();
//                visited.add(smallest.getEnd());
//                for (int i = 1; i <= edgesFromStart[smallest.getEnd() - 1].getSize(); i++) {
//                    priorityQueue.add(edgesFromStart[smallest.getEnd() - 1].getHeap()[i]);
//                }
//            }
//        }
//    }
//
//    public void initEdges(GraphData graphData) {
//        for (int i = 0; i < edgesFromStart.length; i++) {
//            edgesFromStart[i] = new EdgeHeap(1000);
//        }
//
//        for (int i = 0; i < graphData.getCounter(); i++) {
//            edgesFromStart[graphData.getSourceOf(i) - 1].add(new Edge(graphData.getSourceOf(i), graphData.getDestinationOf(i), graphData.getValueOf(i)));
//            edgesFromStart[graphData.getDestinationOf(i) - 1].add(new Edge(graphData.getDestinationOf(i), graphData.getSourceOf(i), graphData.getValueOf(i)));
//        }
//    }
}
