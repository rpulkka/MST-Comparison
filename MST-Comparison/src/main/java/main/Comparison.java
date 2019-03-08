package main;

import data_management.FileHandler;
import data_management.GraphData;
import algorithms.Prim;
import algorithms.Boruvka;
import algorithms.Kruskal;
import graph_creation.GraphCreator;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.Scanner;
import performance_testing.PerformanceTester;

/**
 * The main class. It contains the UI for the program and it calls the
 * algorithms to execute and counts times them.
 */
public class Comparison {

    private static GraphData graphData;
    private static PerformanceTester performanceTester;
    private static FileHandler reader;
    private static GraphCreator graphCreator;
    private static Kruskal kruskal;
    private static Prim prim;
    private static Boruvka boruvka;
    private static int numberOfEdges;
    private static int maxVertice;
    private static Scanner scanner;
    private static boolean notFirstTime;

    /**
     * Initializes the variables of the main class.
     */
    public static void init() {
        reader = new FileHandler();
        performanceTester = new PerformanceTester();
        graphCreator = new GraphCreator();
        scanner = new Scanner(System.in);
        graphData = null;
    }

    /**
     * Launches the program loop.
     */
    public static void main(String args[]) throws URISyntaxException, IOException {
        loop();
    }

    /**
     * This is the program loop. It calls the following three functions until
     * chooseMode() returns false.
     *
     * @see #init()
     * @see #printIntroText()
     * @see #chooseMode()
     *
     */
    public static void loop() throws URISyntaxException, IOException {
        while (true) {
            init();
            printIntroText();
            if (!chooseMode()) {
                break;
            }
        }
    }

    /**
     * Prints the instructions to the screen so that the user can choose what
     * they want to do with the program.
     */
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

    /**
     * Directs the control to the corresponding function based on user input.
     *
     * @see #printIntroText()
     * @see #setGraph(java.io.InputStream) 
     * @see #execute()
     * @see PerformanceTester#testPerformance(algorithms.Kruskal,
     * algorithms.Prim, algorithms.Boruvka, data_management.GraphData)
     * @see #launchGraphCreator()
     * @return False if user wants to quit program, else true
     */
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

    /**
     * Reads the file name from user input.
     *
     * @return The file as input stream.
     */
    public static InputStream askForFile() throws URISyntaxException, IOException {
        InputStream stream = null;
        while (true) {
            //System.out.println("List of existing graph files:");
            //System.out.println("");
//            CODE FOR PRINTING ALL FILENAMES (DOESN'T WORK...)
//            final ClassLoader loader = Thread.currentThread().getContextClassLoader();
//            try (
//                    final InputStream is = loader.getResourceAsStream("resources");
//                    final InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
//                    final BufferedReader br = new BufferedReader(isr)) {
//                br.lines().forEach(System.out::println);
//            }
            System.out.println("");
            System.out.println("Choose an existing file and write the exact file name: ");
            System.out.println("");
            String fileName = "/" + scanner.next();
            stream = Comparison.class.getResourceAsStream(fileName);
            if (stream == null) {
                System.out.println("");
                System.out.println("ERROR: Incorrect filename, try again.");
                System.out.println("");
            } else {
                break;
            }
        }
        return stream;
    }

    /**
     * Calls FileHandler to read the file to GraphData and creates all three
     * algorithm objects of correct size (parameters). In other words, it
     * initializes the program based on the current graph.
     *
     * @param stream address of the file.
     * @see FileHandler#readFile(java.io.InputStream, data_management.GraphData) 
     * @see GraphData#initVertices()
     */
    public static void setGraph(InputStream stream) throws URISyntaxException, IOException {
        graphData = new GraphData(new int[99999999], new int[99999999], new int[99999999]);
        reader.readFile(stream, graphData);
        numberOfEdges = graphData.getNumberOfEdges();
        maxVertice = graphData.getMaxVertice();
        kruskal = new Kruskal(maxVertice);
        prim = new Prim(maxVertice, numberOfEdges);
        boruvka = new Boruvka(maxVertice, numberOfEdges);
        graphData.initVertices();
    }

    /**
     * Sets up a new graph that's created by the graph creator, just like the
     * setGraph() function does, but it doesn't take an address as parameter.
     *
     * @see #setGraph(java.io.InputStream) 
     */
    public static void setRandomizedGraph() {
        numberOfEdges = graphData.getNumberOfEdges();
        maxVertice = graphData.getMaxVertice();
        kruskal = new Kruskal(maxVertice);
        prim = new Prim(maxVertice, numberOfEdges);
        boruvka = new Boruvka(maxVertice, numberOfEdges);
        graphData.initVertices();
    }

    /**
     * Calls all of the algorithms to execute and prints out their results and
     * times the execution of each algorithm.
     *
     * @see Kruskal#execute(data_management.GraphData)
     * @see Prim#execute(data_management.GraphData)
     * @see Boruvka#execute(data_management.GraphData)
     * @see #idle()
     */
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

    /**
     * Asks the user about the details of the new graph and passes the details
     * to GraphCreator as parameters. Then it calls other functions to set up
     * and execute the graph.
     *
     * @see GraphCreator#createGraph(int, int, int)
     * @see #setRandomizedGraph()
     * @see #execute()
     * @see #idle()
     */
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
            System.out.println("Write down the maximum length of edges in the new graph.");
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
    }

    /**
     * Waits until the user has read the results. After this, the program loop
     * continues.
     *
     * @see #loop()
     */
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
