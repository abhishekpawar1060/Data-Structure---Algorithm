import java.util.ArrayList;

public class cyclicDetectionInDirectedGraph {
    static class Edge{
        int src;
        int dest;

        public Edge(int s,int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));

    }

    public static boolean isCylceDirected(ArrayList<Edge> graph[],boolean[] vis, int curr,boolean[] stack){
        vis[curr] = true;
        stack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);

            if(stack[e.dest]){  //cycle
                return true;
            }
            else if (!vis[e.dest]) {
                if(isCylceDirected(graph,vis,e.dest,stack)){
                    return true;
                }
            }
        }
        stack[curr] = false;

        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

//        boolean[] vis = new boolean[V];
//        boolean[] stack = new boolean[V];
//        for (int i = 0; i < V; i++) {
//            if(!vis[i]){
//                boolean isCylce = isCylceDirected(graph,vis,0,stack);
//                if(isCylce){
//                    System.out.println(isCylce);
//                    break;
//                }
//
//            }
//        }

        System.out.println(isCylceDirected(graph,new boolean[V],0,new boolean[V]));
    }
}
