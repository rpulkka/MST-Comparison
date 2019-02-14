package data_structures;

public class Heap {

    private int[] heap;
    private int size;

    public Heap(int maximum) {
        this.heap = new int[maximum + 1];
        this.size = 0;
    }

    public void buildHeap() {
        for (int index = (size / 2); index >= 1; index--) {
            fixPosition(index);
        }
    }

    private void fixPosition(int index) {
        if (!deadEnd(index)) {
            if (heap[index] > heap[getChildFromLeft(index)] || heap[index] > heap[getChildFromRight(index)]) {
                if (heap[getChildFromLeft(index)] < heap[getChildFromRight(index)]) {
                    swap(index, getChildFromLeft(index));
                    fixPosition(getChildFromLeft(index));
                } else {
                    swap(index, getChildFromRight(index));
                    fixPosition(getChildFromRight(index));
                }
            }
        }
    }

    public void swap(int indexA, int indexB) {
        int c = heap[indexA];
        heap[indexA] = heap[indexB];
        heap[indexB] = c;
    }

    public void add(int newVertex) {
        heap[++size] = newVertex;
        int current = size;

        while (heap[current] < heap[getParent(current)]) {
            swap(current, getParent(current));
            current = getParent(current);
        }
    }

    public int peek() {
        return heap[1];
    }

    public int poll() {
        int polled = heap[1];
        heap[1] = heap[size--];
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
        if (heap.length == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getSize() {
        return size;
    }
}
