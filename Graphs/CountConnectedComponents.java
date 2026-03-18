/*
Trees are always connected. which means all the nodes are reachable from the root. 
Graphs doesn't have root. Graph is connected if we can reach any node from any node. 
Component 1: 0 — 1 — 2  
Component 2: 3 — 4  
Component 3: 5 (isolated)
Now question states us to print 2, since we have 2 different componenets in this graph.
Main Idea is to keep a for loop instead of starting for random point and count number of times we called to node through loop instead of BFS/DFS traversal.
Expected 1 based indexing and time complexity is O(N+E) each node visted at once. each edge twice.
*/

import java.util.*;

class AdjList{
    private int vertices;
    private ArrayList<ArrayList<Integer>>list;

    public AdjList(int v){
        vertices = v;
        list = new ArrayList<>();

        for(int i=0;i<=vertices;i++){
            list.add(new ArrayList<>());
        }

    }
    
    public void addEdge(int u, int v){
        list.get(u).add(v);
        list.get(v).add(u);
    }

    public void dfs(int i, int[] vis){
        vis[i]=1;

        for(int temp : list.get(i)){
            if(vis[temp]==0){
                dfs(temp, vis);
            }
        }
    }
    public int countDFS(){
        int[] vis = new int[vertices+1];
        int count =0;
        for(int i=1;i<=vertices;i++){
            if(vis[i]==0){
                count++;
                dfs(i, vis);
            }
        }
        return count;
    }

    public int count(){
        int count=0;
       

        Queue<Integer> q = new LinkedList<>();
        int[] vis = new int[vertices+1];

        for(int i=1;i<=vertices; i++){
            if(vis[i]==0){
                vis[i]=1;
                q.add(i);
                count++;

                while(!q.isEmpty()){
                    int curr = q.peek();
                    q.remove();
                    
                    for(int temp : list.get(curr)){
                        if(vis[temp]==0){
                            q.add(temp);
                            vis[temp]=1;
                        }
                    }
                }
            }
        }
        return count;
    }
}


public class Dprovinces {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int vertices = sc.nextInt();
        int edges = sc.nextInt();

        AdjList list = new AdjList(vertices);

        for(int i=0;i<edges;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            list.addEdge(u,v);

        }

        System.out.println("Provinces are: "+list.countDFS());
    }
}
