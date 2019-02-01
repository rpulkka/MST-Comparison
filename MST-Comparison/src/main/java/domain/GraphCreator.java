
package domain;

import data_management.GraphData;
import java.util.Random;

public class GraphCreator {
    
    public GraphData createGraph() {
        GraphData graphData = new GraphData(new int[1000000], new int[1000000], new int[1000000]);
        Random rand = new Random();

        for(int i = 0; i < 100; i++) {
            int randomSource = rand.nextInt(20) + 1;
            int randomDestination = rand.nextInt(20) + 1;
            int randomLength = rand.nextInt(20) + 1;
            graphData.update(randomSource, randomDestination, randomLength);
            System.out.println(randomSource + " " + randomDestination + " " + randomLength);
        }
        
        return graphData;
    }
}
