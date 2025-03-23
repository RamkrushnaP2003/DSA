import java.util.ArrayList;
import java.util.List;

class DisjointSet {
    int[] rank, parent;

    public DisjointSet(int n) {
        this.rank = new int[n+1];
        this.parent = new int[n+1];
        for(int i=0; i<=n; i++) {
            this.rank[i] = 0;
            this.parent[i] = i;
        }
    }

    public int findParent(int node) {
        if(parent[node] == node) {
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
        } else if (rank[ulp_u] < rank[ulp_v]) {
            parent[ulp_u] = ulp_v;
        } else {
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
}

public class NoOfIsland2 {
    public static List<Integer> onlineQuery(int island[][], int a[][]) {
        int n=island.length, m=island[0].length;
        DisjointSet ds = new DisjointSet(n*m);
        boolean[][] vis = new boolean[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                island[i][j] = (i*m)+j;
            }
        }
        List<Integer> ans = new ArrayList<>();
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        int count=0;
        for(int[] pair: a) {
            int row = pair[0], col=pair[1];
            if(vis[row][col]) {
                ans.add(count);
                continue;
            }
            vis[row][col] = true;
            count++;
            for(int i=0; i<4; i++) {
                int nRow = dx[i] + row;
                int nCol = dy[i] + col;
                int nNode = nRow*m+nCol;
                int currNode = row*m+col;
                if(isValid(nRow, nCol, n, m) && vis[nRow][nCol]) {
                    if(ds.findParent(nNode) != ds.findParent(currNode)) {
                        count--;
                        ds.unionByRank(nNode, currNode);
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }

    public static boolean isValid(int row, int col, int n, int m) {
        return row>=0 && row<n && col>=0 && col<m;
    }

    public static void main(String[] args) {
        int n=4, m=5;
        int[][] island = new int[n][m];
        int a[][] = {{1,1},{0,1},{3,3},{3,4}};
        System.out.println(onlineQuery(island, a));
    }
}
