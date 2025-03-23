import java.util.*;
// Only for directed graph
public class StronglyConnectedComp {
    // time complexity -> O(V + E) + O(V + E) + O(V + E)
    // space complexity -> O(V) + O(V + E) + O(V)
    public static void stronglyConnectedComponent(ArrayList<ArrayList<Integer>> adjList, int V) {
        ArrayList<ArrayList<Integer>> revAdjList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<V; i++) {
            revAdjList.add(new ArrayList<>());
        }
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[V];
        dfs(adjList, vis, 0, new ArrayList<>(), s, false);
        for(int i=0; i<V; i++) {
            for(int node: adjList.get(i)) {
                revAdjList.get(node).add(i);
            }
        }
        vis = new boolean[V];
        while (!s.isEmpty()) {
            int node = s.pop();
            if(!vis[node]) {
                ArrayList<Integer> scc = new ArrayList<>();
                dfs(revAdjList, vis, node, scc, new Stack<>(), true);
                ans.add(new ArrayList<>(scc));
            }
        }
        System.out.println(ans);
        System.out.println(ans.size());
    }

    public static void dfs(ArrayList<ArrayList<Integer>> revAdjList, boolean[] vis, int node, ArrayList<Integer> scc, Stack<Integer> s, boolean isSimple) {
        vis[node] = true;
        if(isSimple) scc.add(node);
        for(int adjNode: revAdjList.get(node)) {
            if(!vis[adjNode]) {
                dfs(revAdjList, vis, adjNode, scc, s, isSimple);
            }
        }
        if(!isSimple) s.push(node);
    }

    public static void main(String[] args) {
        int V=8;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++) {
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).add(1);
        adjList.get(1).add(2);
        adjList.get(2).add(0);
        adjList.get(2).add(3);
        adjList.get(3).add(4);
        adjList.get(4).add(5);
        adjList.get(4).add(7);
        adjList.get(5).add(6);
        adjList.get(6).add(4);
        adjList.get(6).add(7);

        stronglyConnectedComponent(adjList, V);
    }
}
