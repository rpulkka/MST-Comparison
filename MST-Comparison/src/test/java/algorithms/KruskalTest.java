
package algorithms;

import data_management.GraphData;
import algorithms.Kruskal;
import data_management.FileHandler;
import java.io.IOException;
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
        reader = new FileHandler();
    }
    
    @Test
    public void emptyGraphEqualsZero() throws IOException {
        graphData = new GraphData(new int[0], new int[0], new int[0]);
        URL url = getClass().getResource("/emptyGraph.csv");
        reader.readFile(url.getPath(), graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 0);
    }
    
    @Test
    public void singleEdgeTest() throws IOException {
        graphData = new GraphData(new int[1], new int[1], new int[1]);
        URL url = getClass().getResource("/singleEdge.csv");
        reader.readFile(url.getPath(), graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 5);
    }
    
    @Test
    public void mstOfMstEqualsSum() throws IOException {
        graphData = new GraphData(new int[3], new int[3], new int[3]);
        URL url = getClass().getResource("/preMadeMST.csv");
        reader.readFile(url.getPath(), graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 30);
    }
    
    @Test
    public void simpleTest1() throws IOException {
        graphData = new GraphData(new int[30], new int[30], new int[30]);
        URL url = getClass().getResource("/simpleTest1.csv");
        reader.readFile(url.getPath(), graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 33);
    }
    
    @Test
    public void simpleTest2() throws IOException {
        graphData = new GraphData(new int[30], new int[30], new int[30]);
        URL url = getClass().getResource("/simpleTest2.csv");
        reader.readFile(url.getPath(), graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 27);
    }
    
    @Test
    public void nonConnectedVertexTest() throws IOException {
        graphData = new GraphData(new int[50], new int[50], new int[50]);
        URL url = getClass().getResource("/nonConnectedVertex.csv");
        reader.readFile(url.getPath(), graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 31);
    }
    
    @Test
    public void overlappingEdgesTest() throws IOException {
        graphData = new GraphData(new int[50], new int[50], new int[50]);
        URL url = getClass().getResource("/overlappingEdges.csv");
        reader.readFile(url.getPath(), graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 14);
    }
    
    @Test
    public void identicalEdgesTest() throws IOException {
        graphData = new GraphData(new int[50], new int[50], new int[50]);
        URL url = getClass().getResource("/twoIdenticalEdges.csv");
        reader.readFile(url.getPath(), graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 14);
    }
    
    @Test
    public void largeTest1() throws IOException {
        graphData = new GraphData(new int[9999999], new int[9999999], new int[9999999]);
        URL url = getClass().getResource("/largeTest1.csv");
        reader.readFile(url.getPath(), graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 48115963);
    }
    
    @Test
    public void largeTest2() throws IOException {
        graphData = new GraphData(new int[9999999], new int[9999999], new int[9999999]);
        URL url = getClass().getResource("/largeTest2.csv");
        reader.readFile(url.getPath(), graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 47871438);
    }
    
    @Test
    public void largeTest3() throws IOException {
        graphData = new GraphData(new int[9999999], new int[9999999], new int[9999999]);
        URL url = getClass().getResource("/largeTest3.csv");
        reader.readFile(url.getPath(), graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 48037916);
    }
    
    @Test
    public void largeTest4() throws IOException {
        graphData = new GraphData(new int[9999999], new int[9999999], new int[9999999]);
        URL url = getClass().getResource("/largeTest4.csv");
        reader.readFile(url.getPath(), graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 48118534);
    }
    
    @Test
    public void largeTest5() throws IOException {
        graphData = new GraphData(new int[9999999], new int[9999999], new int[9999999]);
        URL url = getClass().getResource("/largeTest5.csv");
        reader.readFile(url.getPath(), graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 48029485);
    }
}
