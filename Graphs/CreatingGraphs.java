/*
Graph is a data structure which has nodes and edges. well, trees also have nodes and graphs. 
main difference is Trees have root and we don't have cycles in trees but in graphs we don't have any root like in trees and we might have cycles as well.
we can say every tree is a graph but every graph is not a tree.
*/

import java.util.*;

class AdjList{
    private int v;
    private ArrayList<ArrayList<Integer>>adjList;

    public AdjList(int v){
        this.v = v;
        this.adjList = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<v;i++){
            this.adjList.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int u, int v){
        adjList.get(u).add(v);
        adjList.get(v).add(u);

    }

    public void printAdjList(){
        for(int i=0;i<v;i++){
            if(adjList.get(i).size()!=0){
                System.out.print(i+"-> [");
            }
            for(int j : adjList.get(i)){
                System.out.print(j+",");
            }
            System.out.println("]");
        }
    }

}


class AdjMatrix{

    private int vertices;
    int[][] adjmatrix;

    public AdjMatrix(int vertices){
        this.vertices=vertices;
        this.adjmatrix = new int[vertices][vertices];
    }

    public void addEdge(int u, int v){
        adjmatrix[u][v]=1;
        adjmatrix[v][u]=1;
    }

    public void printAdjMatrix(){
        System.out.print("  ");
        for(int i=0;i<vertices;i++){
            System.out.print(i+" ");
        }
        System.out.println();

        for(int i=0;i<vertices;i++){
            System.out.print(i+" ");
            for(int j=0;j<vertices;j++){
                System.out.print(adjmatrix[i][j]+" ");
            }
            System.out.println();
        }

    }
}

public class Acreation{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        //AdjList obj = new AdjList(vertices);

        AdjMatrix obj = new AdjMatrix(vertices);

        for(int i=0;i<edges;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            obj.addEdge(u, v);
        }

        obj.printAdjMatrix();
    }
}

