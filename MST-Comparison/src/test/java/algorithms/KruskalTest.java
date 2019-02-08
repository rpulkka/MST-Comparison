
package algorithms;

import data_management.GraphData;
import algorithms.Kruskal;
import data_management.FileHandler;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KruskalTest {
    
    Kruskal kruskal;
    GraphData graphData;
    FileHandler reader;
    
    public KruskalTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void emptyGraphEqualsZero() throws IOException, URISyntaxException {
        kruskal = new Kruskal(0);
        graphData = new GraphData(new int[0], new int[0], new int[0]);
        URL url = getClass().getResource("/emptyGraph.csv");
        URI uri = url.toURI();
        reader.readFile(uri.getPath(), graphData);
        int result = kruskal.execute(graphData);
        assertEquals(result, 0);
    }
    
    @Test
    public void singleVertexTest() throws IOException, URISyntaxException {
        kruskal = new Kruskal(2);
        graphData = new GraphData(new int[1], new int[1], new int[1]);
        //URL url = new URL("file:///src/test/resources/emptyGraph.csv");
        File testFile = new File(this.getClass().getResource("/singleEdge.csv").getFile());
        URL url = new URL("file://"+testFile.getPath());
        System.out.println(url.getPath());
        URI uri = url.toURI();
        reader.readFile(uri.getPath(), graphData);
        graphData.update(1, 2, 5);
        int result = kruskal.execute(graphData);
        assertEquals(result, 5);
    }
    
    @Test
    public void mstOfMstEqualsSum() {
        kruskal = new Kruskal(4);
        graphData = new GraphData(new int[3], new int[3], new int[3]);
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
