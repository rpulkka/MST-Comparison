
package data_management;

import data_structures.IntegerSet;
import java.util.HashSet;

/**
 * The Graph Data class stores the information about the edges of the graph
 * into three arrays, one for the source vertices, one for the destination
 * vertices and one for the values/lengths of the edges. The FileHandler class
 * initializes the arrays with the data from the chosen CSV File. The data can
 * then be found from this class with the help of the getter methods, which can
 * be used to find data of a specific edge or to ask for the whole array.
 */
public class GraphData {
    private int[] source, destination, value;
    private IntegerSet vertexSet;
    private int numberOfVertices;
    private int numberOfEdges;
    private int maxVertice;

    public GraphData(int[] source, int[] destination, int[] value) {
        this.vertexSet = new IntegerSet(100);
        this.source = source;
        this.destination = destination;
        this.value = value;
        numberOfEdges = 0;
        maxVertice = 0;
    }
    
    public void update(int source, int destination, int value) {
        this.source[numberOfEdges] = source;
        this.destination[numberOfEdges] = destination;
        this.value[numberOfEdges] = value;
        vertexSet.add(source);
        vertexSet.add(destination);
        if(numberOfVertices != vertexSet.size()) {
            numberOfVertices = vertexSet.size();
        }
        numberOfEdges++;
        if(source > maxVertice) {
            maxVertice = source;
        }
        if(destination > maxVertice) {
            maxVertice = destination;
        }
    }

    public int getSourceOf(int index) {
        return source[index];
    }

    public int getDestinationOf(int index) {
        return destination[index];
    }

    public int getValueOf(int index) {
        return value[index];
    }

    public int[] getSource() {
        return source;
    }

    public int[] getDestination() {
        return destination;
    }

    public int[] getValue() {
        return value;
    }

    public int getCounter() {
        return numberOfEdges;
    }

    public int getNumberOfVertices() {
        return numberOfVertices;
    }

    public int getNumberOfEdges() {
        return numberOfEdges;
    }

    public int getMaxVertice() {
        return maxVertice;
    }
}
