package data_structures;

import components.Edge;

/**
 * The heap data structure applied to edges.
 */
public class EdgeHeap {

    private Edge[] heap;
    private int size;

    public EdgeHeap(int maximum) {
        this.heap = new Edge[maximum + 1];
        this.size = 0;
    }

    /**
     * Forms the heap by calling the heapify function many times.
     */
    public void buildHeap() {
        for (int index = (size / 2); index >= 1; index--) {
            heapify(index);
        }
    }

    /**
     * The heapify function.
     */
    private void heapify(int index) {
        int left = getChildFromLeft(index);
        int right = getChildFromRight(index);
        int smallest;
        if (right <= size) {
            if (heap[left].getLength() > heap[right].getLength()) {
                smallest = right;
            } else {
                smallest = left;
            }
            if (heap[index].getLength() > heap[smallest].getLength()) {
                swap(index, smallest);
                heapify(smallest);
            }
        } else if (left == size && heap[index].getLength() > heap[left].getLength()) {
            swap(index, left);
        }
    }

    /**
     * Swaps the place of two elements of the heap.
     */
    public void swap(int indexA, int indexB) {
        Edge e = heap[indexA];
        heap[indexA] = heap[indexB];
        heap[indexB] = e;
    }

    /**
     * Adds a new element to the heap.
     */
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

    /**
     * Checks if the heap contains a specific edge.
     */
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

    /**
     * Returns the smallest edge in the heap while leaving it to the heap.
     */
    public Edge peek() {
        if(size < 1) {
            return null;
        }
        return heap[1];
    }

    /**
     * Takes the smallest edge from the heap without returning it.
     */
    public Edge poll() {
        if(size < 1) {
            return null;
        } 
        Edge polled = heap[1];
        heap[1] = heap[size];
        heap[size] = null;
        size--;
        heapify(1);
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
