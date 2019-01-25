
package com.domain;

import java.util.PriorityQueue;

/**
 * Kruskal's algorithm is implemented in this class. 
 */
public class Kruskal {
    private UnionFind unionFind;
    private PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
    
    public Kruskal() {
        unionFind = new UnionFind(100);
    }
    
    public int execute(GraphData graphData) {
        //Add every edge to the priority queue
        for(int i = 0; i <= graphData.getCounter(); i++) {
            edges.add(new Edge(graphData.getSourceOf(i), graphData.getDestinationOf(i), graphData.getValueOf(i)));
        }
        
        int sumOfEdges = 0;
        while (!edges.isEmpty()) {
            Edge e = edges.poll();
            //Check if the polled edge only connects two vertices which are
            //already included in the tree. If yes, discard it, else the 
            //new vertex will be added to the tree and the sum will be 
            //incremented by the length of the edge.
            if (unionFind.sameParent(e.getStart(), e.getEnd())) {
                continue;
            }
            unionFind.addConnection(e.getStart(), e.getEnd());
            sumOfEdges += e.getLength();
        }
        return sumOfEdges;
    }
}
