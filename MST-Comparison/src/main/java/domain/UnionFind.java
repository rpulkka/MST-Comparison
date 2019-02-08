
package domain;

/**
 * Union-Find structure is implemented in this class. It offers valuable data 
 * about the MST, for example, it can check if two vertices are included in the
 * same tree. 
 */
public class UnionFind {
    private int[] parent;
    private int[] size;
    
    public UnionFind(int size) {
        this.parent = new int[size + 1];
        this.size = new int[size + 1];
        
        for (int i = 1; i <= size; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }
    
    public int addConnection(int a, int b) {
        int finalParent = -1;
        if (sameParent(a, b) == false) {
            a = parent(a);
            b = parent(b);
            if (size[a] < size[b]) {
                int c = a;
                a = b;
                b = c;
            }
            parent[b] = a;
            size[a] += size[b];
            finalParent = a;
        }
        return finalParent;
    }

    public boolean sameParent(int a, int b) {
        if (parent(a) == parent(b)) {
            return true;
        }
        return false;
    }

    public int parent(int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }
    
    public int getGroupSize(int i) {
        return size[i];
    }
    
    public void setGroupSize(int i, int size) {
        this.size[i] = size;
    }
}
