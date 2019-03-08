
package data_structures;

/**
 * The array list data structure for objects.
 */
public class ObjectList {
    
    private Object[] array;
    private int size;
    
    public ObjectList() {
        array = new Object[10];
        size = 0;
    }
    
    
    public void add(Object newObject) {
        if (size == array.length) {
            Object[] copy = new Object[size * 2];
            for (int i = 0; i < array.length; i++) {
                copy[i] = array[i];
            }
            array = copy;
        }
        array[size] = newObject;
        size++;
    }
    
    public Object get(int i) {
        if(i >= 0 && i < size) {
            return array[i];
        } else {
            throw new IndexOutOfBoundsException("Index: " + i);
        }
    }
    
    public int size() {
        return size;
    }
}