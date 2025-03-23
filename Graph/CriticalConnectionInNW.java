import java.util.*;

//in leetcode critical connection in a network
public class CriticalConnectionInNW {
    public static void countBriges(int[][] connections, int n) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] pair: connections) {
            adjList.get(pair[0]).add(pair[1]);
            adjList.get(pair[1]).add(pair[0]);
        }
        ArrayList<ArrayList<Integer>> bridges = new ArrayList<>();
        int low[] = new int[n];
        int tin[] = new int[n];
        boolean[] vis = new boolean[n];
        int timer = 0;
        dfs(adjList, bridges, low, tin, vis, timer, 0, -1);
        System.out.println(bridges.size());
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adjList, ArrayList<ArrayList<Integer>> bridges,
    int low[], int tin[], boolean[] vis, int timer, int node, int parent) {
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        for(int adjNode: adjList.get(node)) {
            if(adjNode == parent) continue;
            if(!vis[adjNode]) {
                dfs(adjList, bridges, low, tin, vis, timer, adjNode, node);
                low[node] = Math.min(low[node], low[adjNode]);
                if(low[adjNode] > tin[node]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(adjNode);
                    temp.add(node);
                    bridges.add(new ArrayList<Integer>(temp));
                }
            } else {
                low[node] = Math.min(low[adjNode], low[node]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] connections = {{0,1},{1,2},{2,0},{1,3}};
        int n=4; // no of component in graph
        countBriges(connections, n);
    }
}
