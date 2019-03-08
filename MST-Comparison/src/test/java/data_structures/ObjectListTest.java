
package data_structures;

import components.Edge;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectListTest {
    
    ObjectList list = new ObjectList();
    
    public ObjectListTest() {
    }
    
    @Before
    public void setUp() {
        list = new ObjectList();
    }
    
    @Test
    public void emptyListIsEmpty() {
        assertEquals(list.size(), 0);
    }
    
    @Test
    public void getReturnsAddedValues() {
        Edge a = new Edge(1, 2, 10);
        Edge b = new Edge(2, 3, 20);
        list.add(a);
        list.add(b);
        assertEquals(list.get(0), a);
        assertEquals(list.get(1), b);
    }
    
    @Test
    public void exampleList() {
        Edge a = new Edge(1, 2, 10);
        Edge b = new Edge(2, 3, 20);
        Edge c = new Edge(3, 4, 25);
        Edge d = new Edge(4, 5, 5);
        Edge e = new Edge(5, 6, 50);
        Edge f = new Edge(6, 7, 30);
        Edge g = new Edge(7, 8, 45);
        Edge h = new Edge(8, 9, 40);
        
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        list.add(e);
        list.add(f);
        list.add(g);
        list.add(h);
        
        assertEquals(list.get(0), a);
        assertEquals(list.get(1), b);
        assertEquals(list.get(2), c);
        assertEquals(list.get(3), d);
        assertEquals(list.get(4), e);
        assertEquals(list.get(5), f);
        assertEquals(list.get(6), g);
        assertEquals(list.get(7), h);
    }
}
