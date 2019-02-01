
package main;

import data_management.FileHandler;
import data_management.GraphData;
import algorithms.Prim;
import algorithms.Boruvka;
import algorithms.Kruskal;
import domain.GraphCreator;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * The main class, where the algorithms will be executed, timed and compared. 
 */
public class Comparison {
    
    private static GraphData graphData;
    private static FileHandler reader;
    private static Kruskal kruskal;
    private static Prim prim;
    private static Boruvka boruvka;
    //private static ReverseDelete reverseDelete;
    private static int numberOfVertices;
    private static int numberOfEdges;
    
    public static void init() {
        reader = new FileHandler();
    }
    
    public static void main(String args[]) throws IOException, URISyntaxException {
        init();
        setGraph();
        execute();
    }
    
    public static void setGraph() throws URISyntaxException, IOException {
        URL url = Comparison.class.getResource("/testGraph3.csv");
        URI uri = url.toURI();
        graphData = new GraphData(new int[1000000], new int[1000000], new int[1000000]);
        reader.readFile(uri.getPath(), graphData);
//        GraphCreator graphCreator = new GraphCreator();
//        graphData = graphCreator.createGraph();
        
        numberOfVertices = graphData.getNumberOfVertices();
        numberOfEdges = graphData.getNumberOfEdges();
        kruskal = new Kruskal(numberOfVertices);
        prim = new Prim(numberOfEdges);
        boruvka = new Boruvka(numberOfVertices, numberOfEdges);
        //reverseDelete = new ReverseDelete();
    }
    
    public static void execute() {
        int kruskalResult = kruskal.execute(graphData);
        int primResult = prim.execute(graphData);
        int boruvkaResult = boruvka.execute(graphData);
        System.out.println("Kruskal's Algorithm result: " + kruskalResult);
        System.out.println("Prim's Algorithm result: " + primResult);
        System.out.println("Boruvka's Algorithm result: " + boruvkaResult);
    }
}
