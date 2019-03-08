
package data_structures;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class UnionFindTest {
    UnionFind unionFind;
    
    public UnionFindTest() {
    }
    
    @Before
    public void setUp() {
        unionFind = new UnionFind(10);  //Union Find structure for 10 vertices.
    }
    
    @Test
    public void connectingVerticesWorks() {
        assertEquals(unionFind.parent(1), 1);
        assertEquals(unionFind.parent(2), 2);
        assertEquals(unionFind.getGroupSize(1), 1);
        assertEquals(unionFind.getGroupSize(2), 1);
        unionFind.addConnection(1, 2);
        assertTrue(unionFind.sameParent(1, 2));
        assertEquals(unionFind.parent(1), 1);
        assertEquals(unionFind.parent(2), 1);
        assertEquals(unionFind.getGroupSize(1), 2);
        assertEquals(unionFind.getGroupSize(2), 1);
    }
    
    @Test
    public void example() {
        unionFind.addConnection(1, 2);
        unionFind.addConnection(1, 3);
        
        unionFind.addConnection(4, 5);
        unionFind.addConnection(5, 6);
        unionFind.addConnection(5, 7);
        
        unionFind.addConnection(1, 6);
        
        assertEquals(unionFind.getGroupSize(1), 3);
        assertEquals(unionFind.getGroupSize(4), 7);
        for(int i = 1; i <= 7; i++) {
            assertEquals(unionFind.parent(i), 4);
        }
    }
}
