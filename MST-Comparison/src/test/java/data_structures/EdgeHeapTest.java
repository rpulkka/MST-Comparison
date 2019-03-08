
package data_structures;

import components.Edge;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class EdgeHeapTest {
    EdgeHeap heap;
    
    public EdgeHeapTest() {
    }
    
    @Before
    public void setUp() {
        heap = new EdgeHeap(10);
    }
    
    @Test
    public void emptyHeap() {
        assertEquals(heap.isEmpty(), true);
        assertEquals(heap.peek(), null);
        assertEquals(heap.poll(), null);
    }
    
    @Test
    public void oneNumberHeap() {
        Edge e = new Edge(1, 2, 10);
        heap.add(e);
        assertEquals(heap.isEmpty(), false);
        assertEquals(heap.peek(), e);
        assertEquals(heap.poll(), e);
    }
    
    @Test
    public void twoNumberHeap() {
        Edge a = new Edge(1, 2, 10);
        Edge b = new Edge(2, 3, 20);
        heap.add(a);
        heap.add(b);
        assertEquals(heap.peek(), a);
        assertEquals(heap.poll(), a);
    }
    
    @Test
    public void twoNumberHeapReversed() {
        Edge b = new Edge(2, 3, 20);
        Edge a = new Edge(1, 2, 10);
        heap.add(b);
        heap.add(a);
        assertEquals(heap.peek(), a);
        assertEquals(heap.poll(), a);
    }
    
    @Test
    public void exampleHeap1() {
        //(4, 2, 7, 10, 3, 1, 8, 9, 5, 6) => (1, 2, 3, 4, 5, 6, 7, 8, 9, 10) 
        Edge a = new Edge(1, 2, 4);
        Edge b = new Edge(2, 3, 2);
        Edge c = new Edge(3, 4, 7);
        Edge d = new Edge(4, 5, 10);
        Edge e = new Edge(5, 4, 3);
        Edge f = new Edge(4, 3, 1);
        Edge g = new Edge(3, 2, 8);
        Edge h = new Edge(2, 1, 9);
        Edge i = new Edge(1, 5, 5);
        Edge j = new Edge(5, 1, 6);
        
        heap.add(a);
        heap.add(b);
        heap.add(c);
        heap.add(d);
        heap.add(e);
        heap.add(f);
        heap.add(g);
        heap.add(h);
        heap.add(i);
        heap.add(j);
        
        assertEquals(heap.peek(), f);
        assertEquals(heap.poll(), f);
        assertEquals(heap.peek(), b);
        assertEquals(heap.poll(), b);
        assertEquals(heap.peek(), e);
        assertEquals(heap.poll(), e);
        assertEquals(heap.peek(), a);
        assertEquals(heap.poll(), a);
        assertEquals(heap.peek(), i);
        assertEquals(heap.poll(), i);
        assertEquals(heap.peek(), j);
        assertEquals(heap.poll(), j);
        assertEquals(heap.peek(), c);
        assertEquals(heap.poll(), c);
        assertEquals(heap.peek(), g);
        assertEquals(heap.poll(), g);
        assertEquals(heap.peek(), h);
        assertEquals(heap.poll(), h);
        assertEquals(heap.peek(), d);
        assertEquals(heap.poll(), d);
    }
    
    @Test
    public void exampleHeap2() {
        //(13, 16, 11, 12, 19, 14, 20, 17, 15, 18) => (11, 12, 13, 14, 15, 16, 17, 18, 19, 20) 
        Edge a = new Edge(1, 2, 13);
        Edge b = new Edge(2, 3, 16);
        Edge c = new Edge(3, 4, 11);
        Edge d = new Edge(4, 5, 12);
        Edge e = new Edge(5, 4, 19);
        Edge f = new Edge(4, 3, 14);
        Edge g = new Edge(3, 2, 20);
        Edge h = new Edge(2, 1, 17);
        Edge i = new Edge(1, 5, 15);
        Edge j = new Edge(5, 1, 18);
        
        heap.add(a);
        heap.add(b);
        heap.add(c);
        heap.add(d);
        heap.add(e);
        heap.add(f);
        heap.add(g);
        heap.add(h);
        heap.add(i);
        heap.add(j);
        
        assertEquals(heap.peek(), c);
        assertEquals(heap.poll(), c);
        assertEquals(heap.peek(), d);
        assertEquals(heap.poll(), d);
        assertEquals(heap.peek(), a);
        assertEquals(heap.poll(), a);
        assertEquals(heap.peek(), f);
        assertEquals(heap.poll(), f);
        assertEquals(heap.peek(), i);
        assertEquals(heap.poll(), i);
        assertEquals(heap.peek(), b);
        assertEquals(heap.poll(), b);
        assertEquals(heap.peek(), h);
        assertEquals(heap.poll(), h);
        assertEquals(heap.peek(), j);
        assertEquals(heap.poll(), j);
        assertEquals(heap.peek(), e);
        assertEquals(heap.poll(), e);
        assertEquals(heap.peek(), g);
        assertEquals(heap.poll(), g);
    }
}
