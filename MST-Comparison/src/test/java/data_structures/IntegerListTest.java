
package data_structures;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntegerListTest {
    IntegerList list;
    
    public IntegerListTest() {
    }
    
    @Before
    public void setUp() {
        list = new IntegerList();
    }
    
    @Test
    public void emptyListIsEmpty() {
        assertEquals(list.size(), 0);
    }
    
    @Test
    public void containsGivesRightValues() {
        int i = 1;
        assertEquals(list.contains(i), false);
        list.add(i);
        assertEquals(list.contains(i), true);
    }
    
    @Test
    public void getReturnsAddedValues() {
        list.add(1);
        list.add(98);
        assertEquals(list.get(0), 1);
        assertEquals(list.get(1), 98);
    }
    
    @Test
    public void exampleList() {
        list.add(1);
        list.add(1998);
        list.add(13);
        list.add(666);
        list.add(7);
        list.add(69);
        list.add(9000);
        list.add(94);
        
        assertEquals(list.contains(1), true);
        assertEquals(list.contains(1998), true);
        assertEquals(list.contains(13), true);
        assertEquals(list.contains(666), true);
        assertEquals(list.contains(7), true);
        assertEquals(list.contains(69), true);
        assertEquals(list.contains(9000), true);
        assertEquals(list.contains(94), true);
        assertEquals(list.contains(10), false);
        
        assertEquals(list.get(0), 1);
        assertEquals(list.get(1), 1998);
        assertEquals(list.get(2), 13);
        assertEquals(list.get(3), 666);
        assertEquals(list.get(4), 7);
        assertEquals(list.get(5), 69);
        assertEquals(list.get(6), 9000);
        assertEquals(list.get(7), 94);
    }
}
