
package com.domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The File Handler reads the CSV File and passes the information to the 
 * GraphData class, which stores the data about the edges of the graph.
 */
public class FileHandler {
    
    public void readFile(String filePath, GraphData graphData) throws FileNotFoundException, IOException {
        String csvFile = filePath;
        BufferedReader reader = null;
        String line = "";
        String split = ",";
        
        reader = new BufferedReader(new FileReader(csvFile));
        while ((line = reader.readLine()) != null) {
            String[] edgeData = line.split(split);
            graphData.update(Integer.parseInt(edgeData[0]), Integer.parseInt(edgeData[1]), Integer.parseInt(edgeData[2]));
        }
    }
}
