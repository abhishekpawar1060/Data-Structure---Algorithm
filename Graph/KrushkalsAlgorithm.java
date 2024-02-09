import java.util.*;
import java.io.*;

class DisjoinSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjoinSet(int n){
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findByParent(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findByParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int ulp_u = findByParent(u);
        int ulp_v = findByParent(v);

        if(ulp_u == ulp_v){
            return;
        }else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v, ulp_u);
        }else{
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU+1);
        }
    }

    public void unionBySize(int u, int v){
        int ulp_u = findByParent(u);
        int ulp_v = findByParent(v);

        if(ulp_u == ulp_v){
            return;
        }

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        }else{
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
}

class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int wt;
    public Edge(int s, int d, int w){
        this.src = s;
        this.dest = d;
        this.wt = w;
    }
    @Override
    public int compareTo(Edge compareEdge){
        return this.wt - compareEdge.wt;
    }
};

class Solution{
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){

        ArrayList<Edge> edges = new ArrayList<Edge>();
        for(int i = 0; i < V; i++){
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                int node = i;

                Edge temp = new Edge(i, adjNode, wt);
                edges.add(temp);
            }
        }

        DisjoinSet ds = new DisjoinSet(V);
        //M log M
        Collections.sort(edges);
        int mstWt = 0;
        //M x 4 x alpha x 2
        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i).wt;
            int u = edges.get(i).src;
            int v = edges.get(i).dest;

            if(ds.findByParent(u) != ds.findByParent(v)){
                mstWt += wt;
                ds.unionBySize(u, v);
            }
        }
        return mstWt;
    }
}


public class KrushkalsAlgorithm {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int[][] edges = {{0,1,2},{0,2,1},{1,2,1},{2,3,2},{3,4,1},{4,2,2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for(int i = 0; i < 6; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> temp1 = new ArrayList<>();
            ArrayList<Integer> temp2 = new ArrayList<>();
            temp1.add(v);
            temp1.add(w);

            temp2.add(u);
            temp2.add(w);

            adj.get(u).add(temp1);
            adj.get(v).add(temp2);
        }

        Solution obj = new Solution();
        int mstWt = obj.spanningTree(V, adj);
        System.out.println("The sum of all the edge weights is : " +mstWt);
    }
}
