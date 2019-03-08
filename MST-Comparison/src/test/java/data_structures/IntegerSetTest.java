
package data_structures;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IntegerSetTest {
    IntegerSet set;
    
    public IntegerSetTest() {
    }
    
    @Before
    public void setUp() {
        set = new IntegerSet(10);
    }
    
    @Test
    public void emptySet() {
        assertEquals(set.isEmpty(), true);
        assertEquals(set.contains(1), false);
    }
    
    @Test
    public void addingWorks() {
        set.add(1);
        assertEquals(set.isEmpty(), false);
        assertEquals(set.contains(1), true);
    }
    
    @Test
    public void doesntAddIfContains() {
        set.add(1);
        assertEquals(set.size(), 1);
        set.add(1);
        set.add(1);
        set.add(1);
        assertEquals(set.size(), 1);
        set.add(2);
        assertEquals(set.size(), 2);
    }
}
