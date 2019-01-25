
package com.domain;

/**
 * Union-Find structure is implemented in this class. It offers valuable data 
 * about the MST, for example, it can check if two vertices are included in the
 * same tree. 
 */
public class UnionFind {
    private static int[] parent;
    private static int[] size;
    
    public UnionFind(int size) {
        parent = new int[size];
        UnionFind.size = new int[size];
        
        for (int i = 1; i < size; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }
    
    public static void addConnection(int a, int b) {
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
        }
    }

    public static boolean sameParent(int a, int b) {
        if (parent(a) == parent(b)) {
            return true;
        }
        return false;
    }

    public static int parent(int x) {
        while (x != parent[x]) {
            x = parent[x];
        }
        return x;
    }
    
    public static int getGroupSize(int i) {
        return size[i];
    }
}
