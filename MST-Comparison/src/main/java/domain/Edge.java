
package domain;

/**
 * An abstraction of the edges between the vertices. 
 */
public class Edge implements Comparable<Edge> {
    
    private int start, end, length;

    public Edge(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }

    @Override
    public int compareTo(Edge o) {
        return this.length - o.length;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
