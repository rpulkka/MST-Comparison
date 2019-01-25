
package domain;

import com.domain.GraphData;
import com.domain.Kruskal;
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
        kruskal = new Kruskal();
        graphData = new GraphData(new int[1000], new int[1000], new int[1000]);
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
        graphData.update(2, 1, 7);
        graphData.update(1, 4, 5);
        graphData.update(4, 1, 5);
        graphData.update(1, 6, 3);
        graphData.update(6, 1, 3);
        graphData.update(2, 4, 11);
        graphData.update(4, 2, 11);
        graphData.update(2, 5, 9);
        graphData.update(5, 2, 9);
        graphData.update(2, 3, 10);
        graphData.update(3, 2, 10);
        graphData.update(3, 5, 1);
        graphData.update(5, 3, 1);
        graphData.update(3, 8, 8);
        graphData.update(8, 3, 8);
        graphData.update(4, 6, 4);
        graphData.update(6, 4, 4);
        graphData.update(4, 7, 10);
        graphData.update(7, 4, 10);
        graphData.update(5, 7, 12);
        graphData.update(7, 5, 12);
        graphData.update(5, 8, 3);
        graphData.update(8, 5, 3);
        graphData.update(6, 7, 6);
        graphData.update(7, 6, 6);
        graphData.update(7, 8, 13);
        graphData.update(8, 7, 13);
        int result = kruskal.execute(graphData);
        assertEquals(result, 33);
    }
    
    @Test
    public void correctResultFromTestGraph2() {
        graphData.update(1, 2, 7);
        graphData.update(2, 1, 7);
        graphData.update(1, 5, 8);
        graphData.update(5, 1, 8);
        graphData.update(2, 5, 3);
        graphData.update(5, 2, 3);
        graphData.update(2, 6, 5);
        graphData.update(6, 2, 5);
        graphData.update(6, 5, 7);
        graphData.update(5, 6, 7);
        graphData.update(5, 8, 5);
        graphData.update(8, 5, 5);
        graphData.update(8, 6, 2);
        graphData.update(6, 8, 2);
        graphData.update(3, 6, 2);
        graphData.update(6, 3, 2);
        graphData.update(7, 6, 8);
        graphData.update(6, 7, 8);
        graphData.update(9, 7, 5);
        graphData.update(7, 9, 5);
        graphData.update(6, 9, 4);
        graphData.update(9, 6, 4);
        graphData.update(7, 3, 3);
        graphData.update(3, 7, 3);
        graphData.update(4, 7, 4);
        graphData.update(7, 4, 4);
        graphData.update(4, 3, 1);
        graphData.update(3, 4, 1);
        int result = kruskal.execute(graphData);
        assertEquals(result, 27);
    }
}
