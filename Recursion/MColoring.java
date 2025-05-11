import java.util.*;

public class MColoring {
    public static boolean canColorGraph(List<List<Integer>> graph, int m, int v) {
        return recursion(graph, m, 0, v, new int[v]);
    }

    public static boolean recursion(List<List<Integer>> graph, int m, int node, int v, int[] color) {
        if(v==node) {
            return true;
        }
        for(int i=1; i<=m; i++) {
            if(isPossible(graph, node, color, i)) {
                color[node] = i;
                if(recursion(graph, m, node+1, v, color)) return true;
                color[node] = 0;
            }
        }
        return false;
    } 

    private static boolean isPossible(List<List<Integer>> graph, int node, int color[], int c) {
        for(int i: graph.get(node)) {
            if(color[i] == c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] g ={{0, 1}, {0, 2}, {0, 3}, {1, 2}, {1, 3}};
        int v=4;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<v; i++) {
            graph.add(new ArrayList<>());;
        }
        for(int i[]: g) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }
        System.out.println(canColorGraph(graph, 3, v));
    }
}