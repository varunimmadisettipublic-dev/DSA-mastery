/*

Depth First Search uses stack based approch. this is another way of traversing graph. Similar to BFS this also uses visited array
such that we can escape from stucking in loops.
Before calling DFS function make sure, only legal calls are being made
Once someone reaches DFS just mark it visited, add into answer, now start traversing through that element's adjList
This is called DFS because, here we use recursion. but in BFS entire for loop will be traversed before going to next element right
*/


import java.util.*;

class AdjList{

    private int vertices;
    ArrayList<ArrayList<Integer>>list;
    ArrayList<Integer>dfs;

    public AdjList(int v){
        vertices = v;
        list = new ArrayList<>();
        dfs = new ArrayList<>();

        for(int i=0;i<vertices;i++){
            list.add(new ArrayList<Integer>());
        }
    }


    public void addEdge(int u, int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }

    public void dfshelper(int start, int[] vis){
            vis[start]=1;
            dfs.add(start);

            for(int temp : list.get(start)){
                if(vis[temp]==0){
                    dfshelper(temp,vis);
                }
            }
        
    }

    public void dfs(){
        int[] vis = new int[vertices+1];
        for(int i=0;i<vertices;i++){
            if(vis[i]==0){
              dfshelper(i,vis);
            }
        }
    }

    public void printGraph(){
        for(int i : dfs){
            System.out.print(i+" ");
        }
        
    }


}
public class Cdfs {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        AdjList graph = new AdjList(vertices);

        for(int i=0;i<edges;i++){

            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.addEdge(u,v);

        }

        graph.dfs();
        graph.printGraph();
    }
}
