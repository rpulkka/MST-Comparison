package performance_testing;

import algorithms.*;
import data_management.GraphData;

public class PerformanceTester {

    public PerformanceTester() {

    }

    public void testPerformance(Kruskal kruskal, Prim prim, Boruvka boruvka, GraphData graphData) {
        long[] kruskalResults = new long[100];
        long[] primResults = new long[100];
        long[] boruvkaResults = new long[100];

        for (int i = 0; i <= kruskalResults.length; i++) {
            long kruskalStartTime = System.currentTimeMillis();
            int kruskalResult = kruskal.execute(graphData);
            long kruskalEndTime = System.currentTimeMillis();
            long primStartTime = System.currentTimeMillis();
            int primResult = prim.execute(graphData);
            long primEndTime = System.currentTimeMillis();
            long boruvkaStartTime = System.currentTimeMillis();
            int boruvkaResult = boruvka.execute(graphData);
            long boruvkaEndTime = System.currentTimeMillis();
            
            //Doesn't include the first execution.
            if(i == 0) {
                continue;
            }
            
            kruskalResults[i - 1] = (kruskalEndTime - kruskalStartTime);
            primResults[i - 1] = (primEndTime - primStartTime);
            boruvkaResults[i - 1] = (boruvkaEndTime - boruvkaStartTime);
        }
        
        long kruskalSum = 0;
        long primSum = 0;
        long boruvkaSum = 0;
        
        for(int i = 0; i < kruskalResults.length; i++) {
            kruskalSum += kruskalResults[i];
            primSum += primResults[i];
            boruvkaSum += boruvkaResults[i];
        }
        
        long kruskalAvg = kruskalSum / kruskalResults.length;
        long primAvg = primSum / primResults.length;
        long boruvkaAvg = boruvkaSum / boruvkaResults.length;
        
        System.out.println("Kruskal's Average Time: " + kruskalAvg + "ms");
        System.out.println("Prim's Average Time: " + primAvg + "ms");
        System.out.println("Boruvka's Average Time: " + boruvkaAvg + "ms");
    }
}
