
package algorithms;

import data_management.GraphData;
import algorithms.Kruskal;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KruskalTest {
    
    Kruskal kruskal;
    GraphData graphData;
    
    public KruskalTest() {
    }
    
    @Before
    public void setUp() {
        kruskal = new Kruskal(10000);
        graphData = new GraphData(new int[99999999], new int[99999999], new int[99999999]);
    }
    
    @Test
    public void emptyGraphEqualsZero() {
        int result = kruskal.execute(graphData);
        assertEquals(result, 0);
    }
    
    @Test
    public void singleVertexTest() {
        graphData.update(1, 2, 5);
        int result = kruskal.execute(graphData);
        assertEquals(result, 5);
    }
    
    @Test
    public void mstOfMstEqualsSum() {
        graphData.update(1, 2, 10);
        graphData.update(2, 3, 10);
        graphData.update(3, 4, 10);
        int result = kruskal.execute(graphData);
        assertEquals(result, 30);
    }
    
    @Test
    public void correctResultFromTestGraph1() {
        graphData.update(1, 2, 7);
        graphData.update(1, 4, 5);
        graphData.update(1, 6, 3);
        graphData.update(2, 4, 11);
        graphData.update(2, 5, 9);
        graphData.update(2, 3, 10);
        graphData.update(3, 5, 1);
        graphData.update(3, 8, 8);
        graphData.update(4, 6, 4);
        graphData.update(4, 7, 10);
        graphData.update(5, 7, 12);
        graphData.update(5, 8, 3);
        graphData.update(6, 7, 6);
        graphData.update(7, 8, 13);
        int result = kruskal.execute(graphData);
        assertEquals(result, 33);
    }
    
    @Test
    public void correctResultFromTestGraph2() {
        graphData.update(1, 2, 7);
        graphData.update(1, 5, 8);
        graphData.update(2, 5, 3);
        graphData.update(2, 6, 5);
        graphData.update(6, 5, 7);
        graphData.update(5, 8, 5);
        graphData.update(8, 6, 2);
        graphData.update(3, 6, 2);
        graphData.update(7, 6, 8);
        graphData.update(9, 7, 5);
        graphData.update(6, 9, 4);
        graphData.update(7, 3, 3);
        graphData.update(4, 7, 4);
        graphData.update(4, 3, 1);
        int result = kruskal.execute(graphData);
        assertEquals(result, 27);
    }
}
