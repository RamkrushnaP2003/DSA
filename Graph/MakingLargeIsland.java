import java.util.*;

public class MakingLargeIsland {
    static class DisjointSet {
        int[] size, parent;
    
        public DisjointSet(int n) {
            this.size = new int[n];
            this.parent = new int[n];
            for(int i=0; i<n; i++) {
                this.size[i] = 1;
                this.parent[i] = i;
            }
        }

        public int findParent(int node) {
            if(parent[node] == node) {
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findParent(u);
            int ulp_v = findParent(v);
            if(ulp_u==ulp_v) return;
            if(size[ulp_u] > size[ulp_v]) {
                size[ulp_u]+=size[ulp_v];
                parent[ulp_v] = ulp_u;
            } else {
                parent[ulp_u] = ulp_v;
                size[ulp_v] += size[ulp_u];
            }
        }
    }

    //Use set for edge  case
    public static int largeIsland(int[][] island) {
        int n=island.length, m=island[0].length;
        DisjointSet ds = new DisjointSet(n*m);
        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        int largeIsland = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                for(int k=0; k<4; k++) {
                    int nRow = dx[k] + i;
                    int nCol = dy[k] + j; 
                    if(isValid(nRow, nCol, n, m) && island[i][j]==1 && island[nRow][nCol]==1) {
                        ds.unionBySize((i*m)+j, (nRow*m)+nCol);
                    }
                }
            }
        }
        for(int row=0; row<n; row++) {
            for(int col=0; col<m; col++) {
                if(island[row][col]==0) {
                    int count = 0;
                    HashSet<Integer> set = new HashSet<>();
                    for(int i=0; i<4; i++) {
                        int nRow = row + dx[i];
                        int nCol = col + dy[i];
                        int currNNode = (nRow*m)+nCol;
                        if(isValid(nRow, nCol, n, m) && island[nRow][nCol]==1) {
                            set.add(ds.findParent(currNNode));
                        }
                    }
                    for(int key : set) {
                        count += ds.size[key];
                    }
                    largeIsland = Math.max(largeIsland, count);
                }
            }
        }
        for(int i=0; i<n*m; i++) {
            largeIsland = Math.max(largeIsland, ds.size[ds.findParent(i)]);
        }
        return largeIsland+1;
    }

    public static boolean isValid(int row, int col, int n, int m) {
        return row>=0 && row<n && col>=0 && col<m;
    }

    public static void main(String[] args) {
        int island[][] = {{1, 1, 0, 1, 1},
                          {1, 1, 0, 1, 1},
                          {1, 1, 0, 1, 1},
                          {0, 0, 1, 0, 0},
                          {0, 0, 1, 1, 1},
                          {0, 0, 1, 1, 1}};
        System.out.println(largeIsland(island));
    }
}
