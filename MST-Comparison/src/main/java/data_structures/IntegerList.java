
package data_structures;

public class IntegerList {
    private int[] array;
    private int size;
    
    public IntegerList() {
        array = new int[10];
        size = 0;
    }
    
    
    public void add(int integer) {
        if (size == array.length) {
            int[] copy = new int[size * 2];
            for (int i = 0; i < array.length; i++) {
                copy[i] = array[i];
            }
            array = copy;
        }
        array[size] = integer;
        size++;
    }
    
    public int get(int i) {
        if(i >= 0 && i < size) {
            return array[i];
        } else {
            throw new IndexOutOfBoundsException("Index: " + i);
        }
    }
    
    public boolean contains(int i) {
        for(int j = 0; j < size; j++) {
            if(array[j] == i) {
                return true;
            }
        }
        return false;
    }
    
    public int size() {
        return size;
    }
}
