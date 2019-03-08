package data_structures;

/**
 * The set data structure for integers.
 */
public class IntegerSet {

    private int[] set;
    private int size;

    public IntegerSet(int length) {
        this.set = new int[length];
        this.size = 0;
    }

    public void add(int value) {
        if(contains(value)) {
            return;
        }
        if (size == set.length) {
            int[] copy = new int[size * 2];
            for (int i = 0; i < set.length; i++) {
                copy[i] = set[i];
            }
            set = copy;
        }
        set[size] = value;
        size++;
    }

    public boolean contains(int value) {
        for (int i : set) {
            if (i == value) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        if (size <= 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public int[] getSet() {
        return set;
    }
}
