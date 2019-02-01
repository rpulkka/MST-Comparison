
package algorithms;

import domain.UnionFind;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Reverse-Delete algorithm is implemented in this class. 
 */
// NOT FINISHED YET!!
// NOT FINISHED YET!!
// NOT FINISHED YET!!
public class ReverseDelete {
    private UnionFind unionFind;
    PriorityQueue<Integer> queue;
    
    public ReverseDelete() {
        unionFind = new UnionFind(100);
        queue = new PriorityQueue<>(10, Collections.reverseOrder());
    }
}
