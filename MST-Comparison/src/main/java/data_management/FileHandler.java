package data_management;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * The File Handler reads the CSV File and passes the information to the
 * GraphData class, which stores the data about the edges of the graph.
 */
public class FileHandler {

    /**
     * Reads the file from the file path to the GraphData object.
     * 
     * @param stream The file as stream.
     * @param graphData The structure where the data will be written.
     */
    public void readFile(InputStream stream, GraphData graphData) throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String line = "";
        String split = ",";

        while ((line = reader.readLine()) != null) {
            String[] edgeData = line.split(split);
            graphData.update(Integer.parseInt(edgeData[0]), Integer.parseInt(edgeData[1]), Integer.parseInt(edgeData[2]));
        }
    }
}
