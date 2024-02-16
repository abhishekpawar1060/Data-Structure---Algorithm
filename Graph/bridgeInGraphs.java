import java.util.ArrayList;

public class bridgeInGraphs {

    static class Edge{
        int src;
        int dest;

        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }
//Tarjans Algorithhm
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
        graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));

    }

    public static void dfs(ArrayList<Edge> graph[],int curr,boolean[] vis,int[] dt, int[] lowDt,int time,int par){
        vis[curr] = true;
        dt[curr] = lowDt[curr] = ++time;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(e.dest == par){
                continue;
            } else if (!vis[e.dest]) {
                dfs(graph,e.dest,vis,dt,lowDt,time,par);
                lowDt[curr] = Math.max(lowDt[curr], lowDt[e.dest]);
                if(dt[curr] < lowDt[e.dest]){
                    System.out.println("Bridge is : "+curr+ " --- " +e.dest);
                }
            }else {
                lowDt[curr] = Math.min(lowDt[curr], dt[e.dest]);
            }
        }
    }

    public static void getBridge(ArrayList<Edge> graph[],int V){
        int[] dt = new int[V]; //Discovery time
        int[] lowDt = new int[V]; // Lowest Discovery time
        int time = 0;
        boolean[] vis = new boolean[V];

        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                dfs(graph,i,vis,dt,lowDt,time,-1);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        getBridge(graph,V);
    }
}
