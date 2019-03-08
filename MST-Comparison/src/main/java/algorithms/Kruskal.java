package algorithms;

import components.Edge;
import data_management.GraphData;
import data_structures.EdgeHeap;
import data_structures.UnionFind;

/**
 * Kruskal's algorithm is implemented in this class.
 */
public class Kruskal {

    private UnionFind unionFind;
    private EdgeHeap edges = new EdgeHeap(99999999);

    public Kruskal(int maxVertice) {
        unionFind = new UnionFind(maxVertice);
    }

    /**
     * Executes the Kruskal's algorithm.
     * 
     * @param graphData Data source.
     * @see #initEdges(data_management.GraphData) 
     * @return Returns the sum of edges of the minimum spanning tree.
     */
    public int execute(GraphData graphData) {
        if (graphData.getNumberOfVertices() == 0) {
            return 0;
        }

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

    /**
     * Adds all of the edges to the EdgeHeap from the GraphData.
     *
     * @param graphData The data source.
     */
    public void initEdges(GraphData graphData) {
        //Add every edge to the priority queue
        for (int i = 0; i < graphData.getCounter(); i++) {
            edges.add(new Edge(graphData.getSourceOf(i), graphData.getDestinationOf(i), graphData.getValueOf(i)));
        }
    }
}
