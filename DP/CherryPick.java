import java.util.Arrays;

public class CherryPick {
    private static int one_e9=100000000;

    public static int cherryPick(int grid[][], int commonRow, int aCol, int bCol, int n, int m) {
        if(aCol<0 || aCol>=m || bCol<0 || bCol>=m) return -one_e9;
        if(commonRow == n-1) {
            if(aCol == bCol) {
                return grid[commonRow][aCol];
            } else {
                return grid[commonRow][aCol] + grid[commonRow][bCol];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=-1; i<=1; i++) {
            for(int j=-1; j<=1; j++) {
                int val = 0;
                if(aCol == bCol) {
                    val += grid[commonRow][aCol];
                } else {
                    val += grid[commonRow][bCol] + grid[commonRow][aCol];
                }
                val += cherryPick(grid, commonRow+1, aCol+i, bCol+j, n, m);
                max = Math.max(val, max);
            }
        }
        return max;
    }

    public static int cherryPick(int grid[][], int commonRow, int aCol, int bCol, int n, int m, int dp[][][]) {
        if(aCol<0 || aCol>=m || bCol<0 || bCol>=m) return -one_e9;
        if(commonRow == n-1) {
            if(aCol == bCol) {
                return grid[commonRow][aCol];
            } else {
                return grid[commonRow][aCol] + grid[commonRow][bCol];
            }
        }
        if(dp[commonRow][aCol][bCol] != -1) return dp[commonRow][aCol][bCol];
        int max = Integer.MIN_VALUE;
        for(int i=-1; i<=1; i++) {
            for(int j=-1; j<=1; j++) {
                int val = 0;
                if(aCol == bCol) {
                    val = grid[commonRow][aCol];
                } else {
                    val = grid[commonRow][bCol] + grid[commonRow][aCol];
                }
                val += cherryPick(grid, commonRow+1, aCol+i, bCol+j, n, m, dp);
                max = Math.max(val, max);
            }
        }
        return dp[commonRow][aCol][bCol] = max;
    }

    public static int cherryPick(int grid[][]) {
        int n=grid.length, m=grid[0].length;
        int dp[][][] = new int[n][m][m];
        for(int i=0; i<m; i++) {
            for(int j=0; j<m; j++) {
                if(i==j) dp[n-1][i][j] = grid[n-1][i];
                else dp[n-1][i][j] = grid[n-1][i] + grid[n-1][j];
            }
        }
        for(int commonRow=n-2; commonRow>=0; commonRow--) {
            for(int aCol=0; aCol<m; aCol++) {
                for(int bCol=0; bCol<m; bCol++) {
                    int max = -one_e9;
                    for(int i=-1; i<=1; i++) {
                        for(int j=-1; j<=1; j++) {
                            int val = -one_e9;
                            if(aCol == bCol) {
                                val = grid[commonRow][aCol];
                            } else {
                                val = grid[commonRow][bCol] + grid[commonRow][aCol];
                            }
                            if(aCol+i>=0 && aCol+i<m && bCol+j>=0 && bCol+j<m) {
                                val += dp[commonRow+1][aCol+i][bCol+j];
                            } else {
                                val+= -one_e9;
                            }
                            max = Math.max(val, max);
                        }
                    }
                    dp[commonRow][aCol][bCol] = max;
                }
            }
        }
        return dp[0][0][m-1];
    }

    /* 
     * if a move (commonRow+1, aCol-1) then b can move (commonRow+1, bCol), (commonRow+1, bCol-1), (commonRow+1, bCol+1)
     * if a move (commonRow+1, aCol) then b can move (commonRow+1, bCol), (commonRow+1, bCol-1), (commonRow+1, bCol+1)
     * if a move (commonRow+1, aCol+1) then b can move (commonRow+1, bCol), (commonRow+1, bCol-1), (commonRow+1, bCol+1)
     * 
     * return max from all
    */

    public static void main(String[] args) {
        int grid[][] = {{2, 3, 1, 2},
                        {5, 4, 2, 2},
                        {5, 6, 3, 5}};
        int n=grid.length, m=grid[0].length;
        System.out.println(cherryPick(grid, 0, 0, m-1, n, m));
        int dp[][][] = new int[n][m][m];
        for(int i[][] : dp) {
            for(int j[]: i) {
                Arrays.fill(j, -1);
            }
        }
        System.out.println(cherryPick(grid, 0, 0, m-1, n, m, dp));
        System.out.println(cherryPick(grid));
    }
}
