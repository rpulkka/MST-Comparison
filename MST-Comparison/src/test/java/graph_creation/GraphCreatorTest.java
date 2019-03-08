package graph_creation;

import data_management.GraphData;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphCreatorTest {
    GraphCreator graphCreator;
    GraphData graphData;
    
    public GraphCreatorTest() {
    }
    
    @Before
    public void setUp() {
        graphCreator = new GraphCreator();
    }
    
    @Test
    public void notOutOfBoundsTest() {
        for(int i = 0; i < 1000; i++) {
            graphData = graphCreator.createGraph(100, 30, 30);
            for(int j = 0; j < graphData.getValue().length; j++) {
                boolean sourceNotOutOfBounds = false;
                boolean destinationNotOutOfBounds = false;
                boolean valueNotOutOfBounds = false;
                if(graphData.getSource()[j] <= 30 && graphData.getSource()[j] >= 1) {
                    sourceNotOutOfBounds = true;
                }
                if(graphData.getDestination()[j] <= 30 && graphData.getDestination()[j] >= 1) {
                    destinationNotOutOfBounds = true;
                }
                if(graphData.getValue()[j] <= 30 && graphData.getValue()[j] >= 1) {
                    valueNotOutOfBounds = true;
                }
                assertTrue(sourceNotOutOfBounds);
                assertTrue(destinationNotOutOfBounds);
                assertTrue(valueNotOutOfBounds);
            }
        }
    }
}
