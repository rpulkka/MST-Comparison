
package com.domain;

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
    private static ReverseDelete reverseDelete;
    
    public static void init() {
        graphData = new GraphData(new int[100], new int[100], new int[100]);
        reader = new FileHandler();
        kruskal = new Kruskal();
        prim = new Prim();
        //boruvka = new Boruvka(8);
        reverseDelete = new ReverseDelete();
    }
    
    public static void main(String args[]) throws IOException, URISyntaxException {
        init();
        execute();
    }
    
    public static void execute() throws IOException, URISyntaxException {
        URL url = Comparison.class.getResource("/testGraph1.csv");
        URI uri = url.toURI();
        
        reader.readFile(uri.getPath(), graphData);
        
        int kruskalResult = kruskal.execute(graphData);
        int primResult = prim.execute(graphData);
        //int boruvkaResult = boruvka.execute(graphData);
        System.out.println("Kruskal's Algorithm result: " + kruskalResult);
        System.out.println("Prim's Algorithm result: " + primResult);
        //System.out.println("Boruvka's Algorithm result: " + boruvkaResult);
    }
}
