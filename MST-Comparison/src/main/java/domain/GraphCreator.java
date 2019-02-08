
package domain;

import data_management.GraphData;
import java.util.Random;

public class GraphCreator {
    
    public GraphData createGraph() {
        GraphData graphData = new GraphData(new int[99999999], new int[99999999], new int[99999999]);
        Random rand = new Random();

        for(int i = 0; i < 100000; i++) {
            int randomSource = rand.nextInt(20000) + 1;
            int randomDestination = randomSource;
            while(randomDestination == randomSource) {
                randomDestination = rand.nextInt(20000) + 1;
            }
            int randomLength = rand.nextInt(20000) + 1;
            graphData.update(randomSource, randomDestination, randomLength);
            System.out.println(randomSource + " " + randomDestination + " " + randomLength);
        }
        
        return graphData;
    }
}
