import java.util.ArrayList;

public class articulationPointByUsingTarjansAlgorithm {

    static class Edge{
        int src;
        int dest;

        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));


        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));

    }

    public static void dfs(ArrayList<Edge> graph[],int curr,int par,int[] dt,int[] lowDt,boolean[] vis,int time,boolean[] ap){
        vis[curr] = true;
        dt[curr] = lowDt[curr] = ++time;
        int children = 0;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(par == neigh){
                continue;
            } else if (vis[neigh]) {
                lowDt[curr] = Math.min(lowDt[curr], dt[neigh]);
            }else {
                dfs(graph,neigh,curr,dt,lowDt,vis,time,ap);
                lowDt[curr] = Math.min(lowDt[curr], lowDt[neigh]);
                if(dt[curr] <= lowDt[neigh] && par != -1){
                    ap[curr] = true;
                }
                children++;
            }
        }
        if(par == -1 && children > 1){
            ap[curr] = true;
        }

    }

    public static void getAP(ArrayList<Edge> graph[],int V){
        int[] dt = new int[V];    // O(V+E)
        int[] lowDt = new int[V];
        int time = 0;
        boolean[] vis = new boolean[V];
        boolean[] ap = new boolean[V]; // ap-articulation point

        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                dfs(graph,i,-1,dt,lowDt,vis,time,ap);
            }
        }

        for (int i = 0; i < V; i++) {
            if(ap[i]){
                System.out.println("AP : "+i);
            }
        }

    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        getAP(graph,V);
    }
}
