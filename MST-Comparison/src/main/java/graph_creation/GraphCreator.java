
package graph_creation;

import data_management.GraphData;

/**
 * The GraphCreator class creates new graphs. An edge is made by generating 3 
 * 'random' numbers that represent the source node, destination node and the
 * length of the edge. These 'randomized' edges form new graphs.
 */
public class GraphCreator {
    
    public GraphData createGraph(int numberOfEdges, int numberOfVertices, int maxLength) {
        GraphData graphData = new GraphData(new int[numberOfEdges], new int[numberOfEdges], new int[numberOfEdges]);

        for(int i = 0; i < numberOfEdges; i++) {
            int randomSource = (int) generateRandomNumber(numberOfVertices);
            int randomDestination = randomSource;
            //Ensures that edge doesn't start and end to the same vertex.
            while(randomDestination == randomSource) {
                randomDestination = (int) generateRandomNumber(numberOfVertices);
            }
            int randomLength = (int) generateRandomNumber(maxLength);
            graphData.update(randomSource, randomDestination, randomLength);
            System.out.println(graphData.getSource()[i] + " " + graphData.getDestination()[i] + " " + graphData.getValue()[i]);
        }
        
        return graphData;
    }
    
    public long generateRandomNumber(int modulus) {
        long nanoTime = System.nanoTime();
        long random = nanoTime % modulus;
        random++;
        return random;
    }
}
