
package algorithms;

import domain.Edge;
import data_management.GraphData;
import domain.UnionFind;
import java.util.PriorityQueue;

/**
 * Kruskal's algorithm is implemented in this class. 
 */
public class Kruskal {
    private UnionFind unionFind;
    private PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
    
    public Kruskal(int maxVertice) {
        unionFind = new UnionFind(maxVertice);
    }
    
    public int execute(GraphData graphData) {
        initEdges(graphData);
        
        int sumOfEdges = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            //Check if the polled edge only connects two vertices which are
            //already included in the tree. If yes, discard it, else the 
            //new vertex will be added to the tree and the sum will be 
            //incremented by the length of the edge.
            
            if (unionFind.sameParent(edge.getStart(), edge.getEnd())) {
                continue;
            }
            unionFind.addConnection(edge.getStart(), edge.getEnd());
            sumOfEdges += edge.getLength();
        }
        return sumOfEdges;
    }
    
    public void initEdges(GraphData graphData) {
        //Add every edge to the priority queue
        for(int i = 0; i < graphData.getCounter(); i++) {
            edges.add(new Edge(graphData.getSourceOf(i), graphData.getDestinationOf(i), graphData.getValueOf(i)));
        }
    }
}
