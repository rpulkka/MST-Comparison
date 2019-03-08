
package algorithms;

import data_management.GraphData;
import algorithms.Kruskal;
import data_management.FileHandler;
import java.io.IOException;
import java.io.InputStream;
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
        InputStream stream = getClass().getResourceAsStream("/emptyGraph.csv");
        reader.readFile(stream, graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 0);
    }
    
    @Test
    public void singleEdgeTest() throws IOException {
        graphData = new GraphData(new int[1], new int[1], new int[1]);
        InputStream stream = getClass().getResourceAsStream("/singleEdge.csv");
        reader.readFile(stream, graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 5);
    }
    
    @Test
    public void mstOfMstEqualsSum() throws IOException {
        graphData = new GraphData(new int[3], new int[3], new int[3]);
        InputStream stream = getClass().getResourceAsStream("/preMadeMST.csv");
        reader.readFile(stream, graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 30);
    }
    
    @Test
    public void simpleTest1() throws IOException {
        graphData = new GraphData(new int[30], new int[30], new int[30]);
        InputStream stream = getClass().getResourceAsStream("/simpleTest1.csv");
        reader.readFile(stream, graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 33);
    }
    
    @Test
    public void simpleTest2() throws IOException {
        graphData = new GraphData(new int[30], new int[30], new int[30]);
        InputStream stream = getClass().getResourceAsStream("/simpleTest2.csv");
        reader.readFile(stream, graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 27);
    }
    
    @Test
    public void overlappingEdgesTest() throws IOException {
        graphData = new GraphData(new int[50], new int[50], new int[50]);
        InputStream stream = getClass().getResourceAsStream("/overlappingEdges.csv");
        reader.readFile(stream, graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 14);
    }
    
    @Test
    public void identicalEdgesTest() throws IOException {
        graphData = new GraphData(new int[50], new int[50], new int[50]);
        InputStream stream = getClass().getResourceAsStream("/twoIdenticalEdges.csv");
        reader.readFile(stream, graphData);
        kruskal = new Kruskal(graphData.getMaxVertice());
        int result = kruskal.execute(graphData);
        assertEquals(result, 14);
    }
}
