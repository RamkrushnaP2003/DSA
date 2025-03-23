import java.util.HashMap;
import java.util.HashSet;

public class MostStoneRemoveWithSameRowCol {
    static class Disjointset {
        int[] rank, parent;
        public Disjointset(int n) {
            this.rank = new int[n+1];
            this.parent = new int[n+1];
            for(int i=0; i<n; i++) {
                this.rank[i] = 0;
                this.parent[i] = i;
            }
        }
    
        public int findParent(int node) {
            if(node == parent[node]) {
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }
    
        public void unionByRank(int u, int v) {
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);
            if(ulp_u == ulp_v) return;
            if(rank[ulp_u] > rank[ulp_v]) {
                parent[ulp_v] = ulp_u;
            } else if(rank[ulp_u] < rank[ulp_v]) {
                parent[ulp_u] = ulp_v;
            } else {
                parent[ulp_v] = ulp_u;
                rank[ulp_u]++;
            }
        }
    }

    public static int maxReomve(int stones[][]) {
        int maxRow=0, maxCol=0;
        for(int pair[]: stones) {
            maxRow = Math.max(maxRow, pair[0]);
            maxCol = Math.max(maxCol, pair[1]);
        }
        Disjointset ds = new Disjointset(maxRow+(maxCol+1));
        HashSet<Integer> set = new HashSet<>();
        int count=0;
        for(int pair[]: stones) {
            int nodeRow = pair[0];
            int nodeCol = pair[1]+maxRow+1;
            ds.unionByRank(nodeRow, nodeCol);
            set.add(nodeRow);
            set.add(nodeCol);
        }
        for(int i: set) {
            if(i==ds.findParent(i)) {
                count++;
            }
        }
        return stones.length - count;
    }

    public static void main(String[] args) {
        // int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        int[][] stones = {{0,0},{0,2},{1,1},{2,0},{2,2}};
        System.out.println(maxReomve(stones));
    }
}
