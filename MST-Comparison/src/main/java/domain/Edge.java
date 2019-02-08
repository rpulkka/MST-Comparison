
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
    
    public boolean isSame(int start2, int end2, int length2) {
        if(start == start2 && end == end2 && length == length2) {
            return true;
        }
        return false;
    }
    
    public boolean isInversion(int start2, int end2, int length2) {
        if(start == end2 && end == start2 && length == length2) {
            return true;
        }
        return false;
    }
    
    @Override
    public boolean equals(Object o) {
        Edge e = (Edge) o;
        if(start == e.getStart() && end == e.getEnd() && length == e.getLength()) {
            return true;
        }
        if(start == e.getEnd() && end == e.getStart() && length == e.getLength()) {
            return true;
        }
        return false;
    }
}
