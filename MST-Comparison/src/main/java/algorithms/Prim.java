
package algorithms;

import domain.Edge;
import data_management.GraphData;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Prim's algorithm is implemented in this class. 
 */
public class Prim {
    int numberOfEdges;
    PriorityQueue<Edge>[] edgesFromStart;
    
    public Prim(int numberOfEdges) {
        this.numberOfEdges = numberOfEdges;
        //An array of priority queues, the index represents the source vertex
        //of the edge.
        this.edgesFromStart = new PriorityQueue[numberOfEdges];
    }
    
    public int execute(GraphData graphData) {
        if(graphData.getNumberOfVertices() == 0) {
            return 0;
        }
        
        initEdges(graphData);
        
        //List of visited vertices.
        ArrayList<Integer> visited = new ArrayList<Integer>();
        
        //Priority queue for the edge options that are currently reachable.
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<Edge>();
        
        
        int sumOfEdges = 0;
        
        //Start from vertex number 1.
        visited.add(1);
        for (Edge e : edgesFromStart[0]) {
            priorityQueue.add(e);
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
                for (Edge e : edgesFromStart[smallest.getEnd() - 1]) {
                    priorityQueue.add(e);
                }
            }
        }
    }
    
    public void initEdges(GraphData graphData) {
        for (int i = 0; i < edgesFromStart.length; i++) {
            edgesFromStart[i] = new PriorityQueue<Edge>();
        }
        
        for(int i = 0; i < graphData.getCounter(); i++) {
            edgesFromStart[graphData.getSourceOf(i) - 1].add(new Edge(graphData.getSourceOf(i), graphData.getDestinationOf(i), graphData.getValueOf(i)));
            edgesFromStart[graphData.getDestinationOf(i) - 1].add(new Edge(graphData.getDestinationOf(i), graphData.getSourceOf(i), graphData.getValueOf(i)));
        }
    }
}
