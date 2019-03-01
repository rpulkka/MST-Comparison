package main;

import data_management.FileHandler;
import data_management.GraphData;
import algorithms.Prim;
import algorithms.Boruvka;
import algorithms.Kruskal;
import graph_creation.GraphCreator;
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
    private static GraphCreator graphCreator;
    private static Kruskal kruskal;
    private static Prim prim;
    private static Boruvka boruvka;
    //private static ReverseDelete reverseDelete;
    private static int numberOfEdges;
    private static int maxVertice;
    private static Scanner scanner;
    private static boolean notFirstTime;

    public static void init() {
        reader = new FileHandler();
        performanceTester = new PerformanceTester();
        graphCreator = new GraphCreator();
        scanner = new Scanner(System.in);
        graphData = null;
    }

    public static void main(String args[]) throws URISyntaxException, IOException {
        start();
    }

    public static void start() throws URISyntaxException, IOException {
        while (true) {
            init();
            printIntroText();
            if (!chooseMode()) {
                break;
            }
        }
    }

    public static void printIntroText() {
        if (!notFirstTime) {
            System.out.println("Welcome to the MST-Comparison program!");
            System.out.println("");
            notFirstTime = true;
        }
        System.out.println("Write '1' to execute an existing file.");
        System.out.println("Write '2' to test performance on an existing file (might take several minutes).");
        System.out.println("Write '3' to create and execute a new randomized graph.");
        System.out.println("Write '4' to exit the program.");
        System.out.println("");
    }
    
    public static boolean chooseMode() throws URISyntaxException, IOException {
        int mode = 0;
        while (true) {
            try {
                mode = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("");
                System.out.println("Invalid input.");
                System.out.println("");
                printIntroText();
            }
        }
        System.out.println("");
        if (mode == 1) {
            setGraph(askForFile());
            execute();
        } else if (mode == 2) {
            setGraph(askForFile());
            performanceTester.testPerformance(kruskal, prim, boruvka, graphData);
        } else if (mode == 3) {
            launchGraphCreator();
        } else if (mode == 4) {
            System.out.println("See you later!~~~");
            return false;
        } else {
            System.out.println("Invalid input.");
            System.out.println("");
            printIntroText();
            chooseMode();
        }
        return true;
    }

    public static URL askForFile() throws URISyntaxException {
        URL url1 = Comparison.class.getResource("/");
        URI uri1 = url1.toURI();
        File folder = new File(uri1);
        File[] listOfFiles = folder.listFiles();
        System.out.println("List of existing graph files:");
        System.out.println("");
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].getName().contains(".csv") && (listOfFiles[i].getName().charAt(0) != '.')) {
                System.out.println(listOfFiles[i].getName());
            }
        }
        System.out.println("");
        System.out.println("Choose an existing file from the list above and write the exact file name: ");
        System.out.println("");
        String fileName = "/" + scanner.next();
        URL url = Comparison.class.getResource(fileName);
        return url;
    }

    public static void setGraph(URL url) throws URISyntaxException, IOException {
        graphData = new GraphData(new int[99999999], new int[99999999], new int[99999999]);
        reader.readFile(url.getPath(), graphData);
        numberOfEdges = graphData.getNumberOfEdges();
        maxVertice = graphData.getMaxVertice();
        kruskal = new Kruskal(maxVertice);
        prim = new Prim(maxVertice, numberOfEdges);
        boruvka = new Boruvka(maxVertice, numberOfEdges);
        graphData.initVertices();
        //reverseDelete = new ReverseDelete();
    }

    public static void setRandomizedGraph() {
        numberOfEdges = graphData.getNumberOfEdges();
        maxVertice = graphData.getMaxVertice();
        kruskal = new Kruskal(maxVertice);
        prim = new Prim(maxVertice, numberOfEdges);
        boruvka = new Boruvka(maxVertice, numberOfEdges);
        graphData.initVertices();
    }

    public static void execute() throws URISyntaxException, IOException {
        System.out.println("");
        System.out.println("Results");
        System.out.println("");
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
        idle();
    }

    public static void launchGraphCreator() throws URISyntaxException, IOException {
        int numOfVertices;
        while (true) {
            System.out.println("Write down the number of vertices in the new graph.");
            System.out.println("");
            try {
                numOfVertices = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("");
                System.out.println("Invalid input.");
                System.out.println("");
            }
        }
        System.out.println("");
        int numOfEdges;
        while (true) {
            System.out.println("Write down the number of edges in the new graph.");
            System.out.println("");
            try {
                numOfEdges = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("");
                System.out.println("Invalid input.");
                System.out.println("");
            }
        }
        System.out.println("");
        int maxLength;
        while (true) {
            System.out.println("Write down the number of edges in the new graph.");
            System.out.println("");
            try {
                maxLength = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("");
                System.out.println("Invalid input.");
                System.out.println("");
            }
        }
        graphData = graphCreator.createGraph(numOfEdges, numOfVertices, maxLength);
        setRandomizedGraph();
        execute();
        idle();
    }

    public static void idle() throws URISyntaxException, IOException {
        System.out.println("");
        System.out.println("Press enter to continue.");
        System.out.println("");
        try {
            System.in.read();
        } catch (Exception e) {

        }
    }
}
