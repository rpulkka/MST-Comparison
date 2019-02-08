
package algorithms;

import data_management.GraphData;
import org.junit.Before;

public class BoruvkaTest {
    
    Boruvka boruvka;
    GraphData graphData;
    
    public BoruvkaTest() {
    }
    
    @Before
    public void setUp() {
        boruvka = new Boruvka(1,1);
    }
}
