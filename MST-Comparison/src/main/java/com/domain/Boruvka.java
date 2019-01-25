package com.domain;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Boruvka's algorithm is implemented in this class. 
 */
public class Boruvka {
// NOT FINISHED YET!!
// NOT FINISHED YET!!
// NOT FINISHED YET!!
// NOT FINISHED YET!!
// NOT FINISHED YET!!

//    private UnionFind unionFind;
//    private PriorityQueue<Edge>[] edges;
//    private int numberOfVertices;
//
//    public Boruvka(int numOfVertices) {
//        unionFind = new UnionFind(numOfVertices);
//        edges = new PriorityQueue[100];
//        numberOfVertices = numOfVertices;
//    }
//
//    public int execute(ArrayList<Edge> edgeList) {
//        for (int i = 1; i <= numberOfVertices; i++) {
//            edges[i] = new PriorityQueue<Edge>();
//        }
//        
//        for (Edge edge : edgeList) {
//            edges[edge.getStart()].add(edge);
//        }
//
//        int sumOfEdges = 0;
//        while (true) {
//            for (int i = 1; i <= numberOfVertices; i++) {
//                if (!edges[i].isEmpty()) {
//                    Edge smallest = edges[i].poll();
//                    System.out.println("s "+smallest.getStart()+" l "+smallest.getLength());
//                    sumOfEdges += smallest.getLength();
//                    if(unionFind.sameParent(smallest.getStart(), smallest.getEnd())) {
//                        System.out.println("!!!!!"+unionFind.getGroupSize(smallest.getStart()));
//                        if(unionFind.getGroupSize(smallest.getStart()) == numberOfVertices) {
//                            return sumOfEdges;
//                        }
//                        System.out.println("discarded");
//                        continue;
//                    } else {
//                        unionFind.addConnection(smallest.getStart(), smallest.getEnd());
//                        while(!edges[smallest.getEnd()].isEmpty()) {
//                            edges[smallest.getStart()].add(edges[smallest.getEnd()].poll());
//                        }
//                    }
//                }
//            }
//        }
//    }
}
////                    Edge smallest = new Edge(1, 2, Integer.MAX_VALUE / 2);
////                    for (Edge e : edges[i]) {
////                        if(e.getLength() < smallest.getLength()) {
////                            smallest = e;
////                        }
////                    }
