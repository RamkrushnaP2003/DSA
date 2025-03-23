import java.util.*;

public class ArticulationPoint {
    public static ArrayList<Integer> countComp(int adj[][], int n) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int pair[] : adj) {
            adjList.get(pair[0]).add(pair[1]);
            adjList.get(pair[1]).add(pair[0]);
        }
        int[] tin = new int[n];
        int low[] = new int[n];
        int[] mark = new int[n];
        boolean[] vis = new boolean[n];
        for(int i=0; i<n; i++) {
            if(!vis[i]) {
                dfs(adjList, vis, tin, low, mark, i, -1);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(mark[i] == 1) {
                ans.add(i);
            }
        }
        if(ans.size()==0) ans.add(-1);
        System.out.println(ans);
        return ans;
    }

    private static int timer = 0;

    public static void dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] vis, int tin[], int[] low, int mark[], int node, int parent){ 
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        int child = 0;
        for(int adjNode: adjList.get(node)) {
            if(adjNode == parent) continue;
            if(!vis[adjNode]) {
                dfs(adjList, vis, tin, low, mark, adjNode, node);
                low[node] = Math.min(low[node], low[adjNode]);
                if(low[adjNode] >= tin[node] && parent != -1) {
                    mark[node] = 1;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], tin[adjNode]);
            }
        }
        if(child > 1 && parent == -1) {
            mark[node] = 1;
        }
    }
    
    public static void main(String args[]) {
        int[] adj[] = {{0, 1}, {1, 4}, {4, 3}, {4, 2}, {2, 3}};
        int n=5;
        System.out.println(countComp(adj, n));
    }
}