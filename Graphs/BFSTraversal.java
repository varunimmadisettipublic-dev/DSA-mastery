import java.util.*;

class AdjList{
    private int vertices;
    ArrayList<ArrayList<Integer>> adjList;
    ArrayList<Integer> bfsTraversal;

    public AdjList(int v){

        vertices = v;
        adjList = new ArrayList<>();

        for(int i=0;i<=v;i++){
            adjList.add(new ArrayList<>());
        }

        bfsTraversal = new ArrayList<>();

    }

    public void addEdge(int e1, int e2){
        adjList.get(e1).add(e2);
        adjList.get(e2).add(e1);
    }

    public void bfs(int start, int visited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start]=1;
        
        while(!q.isEmpty()){
            int curr = q.poll();
            bfsTraversal.add(curr);
            for(int temp : adjList.get(curr)){
                if(visited[temp]==0){
                    q.add(temp);
                    visited[temp]=1;
                }
            }
        }
    }

    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();

        AdjList list = new AdjList(v);

        for(int i=0;i<e;i++){
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();

            list.addEdge(e1,e2);
        }

        int visited[] = new int[v+1];
        
        for(int i=1;i<=v;i++){
            if(visited[i]==0){
                list.bfs(i, visited);
            }
        }
        
        for(int i : list.bfsTraversal){
          System.out.print(i+" ");
        }
        
    }
}
