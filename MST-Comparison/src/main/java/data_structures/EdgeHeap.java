package data_structures;                                                                  

import components.Edge;

public class EdgeHeap {

    private Edge[] heap;
    private int size;

    public EdgeHeap(int maximum) {
        this.heap = new Edge[maximum + 1];
        this.size = 0;
    }

    public void buildHeap() {
        for (int index = (size / 2); index >= 1; index--) {
            fixPosition(index);
        }
    }

    private void fixPosition(int index) {
        int left = getChildFromLeft(index);
        int right = getChildFromRight(index);
        int smallest;
        if(right <= size) {                                      
            if(heap[left].getLength() > heap[right].getLength()) {
                smallest = right;
            } else {
                smallest = left;
            }
            if(heap[index].getLength() > heap[smallest].getLength()) {
                swap(index, smallest);
                fixPosition(smallest);
            }
        } else if(left == size && heap[index].getLength() > heap[left].getLength()) {
            swap(index, left);
        }
    }

    public void swap(int indexA, int indexB) {
        Edge e = heap[indexA];
        heap[indexA] = heap[indexB];
        heap[indexB] = e;
    }

    public void add(Edge newEdge) {
        size++;
        heap[size] = newEdge;
        int current = size;

        if (current == 1) {
            return;
        }
        
        while (heap[current].getLength() < heap[getParent(current)].getLength()) {
            swap(current, getParent(current));
            current = getParent(current);
            if (current == 1) {
                break;
            }
        }
    }
    
    public boolean contains(Edge edge) {
        for (int i = 1; i <= size; i++) {
            if (heap[i].getStart() == edge.getStart() && heap[i].getEnd() == edge.getEnd() && heap[i].getLength() == edge.getLength()) {
                return true;
            }
            if (heap[i].getStart() == edge.getEnd() && heap[i].getEnd() == edge.getStart() && heap[i].getLength() == edge.getLength()) {
                return true;
            }
        }
        return false;
    }

    public Edge peek() {
        return heap[1];
    }

    public Edge poll() {
        Edge polled = heap[1];
        heap[1] = heap[size];
        heap[size] = null;
        size--;
        fixPosition(1);
        return polled;
    }

    public int getParent(int index) {
        return index / 2;
    }

    public int getChildFromLeft(int index) {
        return (2 * index);
    }

    public int getChildFromRight(int index) {
        return (2 * index) + 1;
    }

    public boolean deadEnd(int index) {
        if (index >= (size / 2) && index <= size) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getSize() {
        return size;
    }

    public Edge[] getHeap() {
        return heap;
    }
}
