package main;

import data_management.FileHandler;
import data_management.GraphData;
import algorithms.Prim;
import algorithms.Boruvka;
import algorithms.Kruskal;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;
import performance_testing.PerformanceTester;

/**
 * The main class, where the algorithms will be executed, timed and compared.
 */
public class Comparison {

    private static GraphData graphData;
    private static PerformanceTester performanceTester;
    private static FileHandler reader;
    private static Kruskal kruskal;
    private static Prim prim;
    private static Boruvka boruvka;
    //private static ReverseDelete reverseDelete;
    private static int numberOfEdges;
    private static int maxVertice;
    private static Scanner scanner;

    public static void init() {
        reader = new FileHandler();
        performanceTester = new PerformanceTester();
        scanner = new Scanner(System.in);
    }

    public static void main(String args[]) throws IOException, URISyntaxException {
        init();
        setGraph(askForFile());
        System.out.println("For single execution, write '1', for performance testing, write '2' (this option might take several minutes).");
        int mode = Integer.parseInt(scanner.next());
        if(mode == 1) {
            execute();
        } else if(mode == 2) {
            performanceTester.testPerformance(kruskal, prim, boruvka, graphData);
        }
    }

    public static URL askForFile() throws URISyntaxException {
        URL url1 = Comparison.class.getResource("/");
        URI uri1 = url1.toURI();
        File folder = new File(uri1);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().contains(".csv") && (listOfFiles[i].getName().charAt(0) != '.')) {
                System.out.println(listOfFiles[i].getName());
            }
        }
        System.out.println("");
        System.out.println("Write a file name: ");
        String fileName = "/" + scanner.next();
        URL url = Comparison.class.getResource(fileName);
        return url;
    }

    public static void setGraph(URL url) throws URISyntaxException, IOException {
        graphData = new GraphData(new int[99999999], new int[99999999], new int[99999999]);
        reader.readFile(url.getPath(), graphData);
//        GraphCreator graphCreator = new GraphCreator();
//        graphData = graphCreator.createGraph();

        numberOfEdges = graphData.getNumberOfEdges();
        maxVertice = graphData.getMaxVertice();
        kruskal = new Kruskal(maxVertice);
        prim = new Prim(maxVertice, numberOfEdges);
        boruvka = new Boruvka(maxVertice, numberOfEdges);
        //reverseDelete = new ReverseDelete();
    }

    public static void execute() {
        long kruskalStartTime = System.currentTimeMillis();
        int kruskalResult = kruskal.execute(graphData);
        long kruskalEndTime = System.currentTimeMillis();
        long primStartTime = System.currentTimeMillis();
        int primResult = prim.execute(graphData);
        long primEndTime = System.currentTimeMillis();
        long boruvkaStartTime = System.currentTimeMillis();
        int boruvkaResult = boruvka.execute(graphData);
        long boruvkaEndTime = System.currentTimeMillis();
        System.out.println("Kruskal's Algorithm result: " + kruskalResult);
        System.out.println("Kruskal's Algorithm duration: " + (kruskalEndTime - kruskalStartTime) + "ms");
        System.out.println("Prim's Algorithm result: " + primResult);
        System.out.println("Prim's Algorithm duration: " + (primEndTime - primStartTime) + "ms");
        System.out.println("Boruvka's Algorithm result: " + boruvkaResult);
        System.out.println("Boruvka's Algorithm duration: " + (boruvkaEndTime - boruvkaStartTime) + "ms");
    }
}
