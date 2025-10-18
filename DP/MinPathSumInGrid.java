import java.util.Arrays;

public class MinPathSumInGrid { //moves -> right || down
    static int oneEnine = 100000000;

    public static int minPathSumInGrid(int grid[][], int n, int m) {
        if(n==0 && m==0) return grid[0][0];
        if(n<0 || m<0) return oneEnine;
        int top = grid[n][m] + minPathSumInGrid(grid, n-1, m);
        int left = grid[n][m] + minPathSumInGrid(grid, n, m-1);
        return Math.min(top, left);
    }

    public static int minPathSumInGrid(int grid[][], int n, int m, int dp[][]) {
        if(n==0 && m==0) return grid[0][0];
        if(n<0 || m<0) return oneEnine;
        if(dp[n][m] != -1) return dp[n][m];
        int top = grid[n][m] + minPathSumInGrid(grid, n-1, m);
        int left = grid[n][m] + minPathSumInGrid(grid, n, m-1);
        return dp[n][m] = Math.min(top, left);
    }

    public static int minPathSumInGrid(int n, int m, int grid[][]) {
        int dp[][] = new int[n][m];
        for (int i[]: dp) {
            Arrays.fill(i, 0);
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(i==0 && j==0) dp[i][j] = grid[i][j];
                else {
                    int top = grid[i][j], left = grid[i][j];
                    if(i > 0) top += dp[i-1][j];
                    else top += oneEnine;
                    if(j > 0) left += dp[i][j-1];
                    else left += oneEnine;
                    dp[i][j] = Math.min(top, left);
                }
            }
        }
        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        int grid[][] = {{2, 5, 1}, {3, 10, 7}};
        int n=grid.length, m=grid[0].length;
        System.out.println(minPathSumInGrid(grid, n-1, m-1));
        int dp[][] = new int[n][m];
        for(int i[]: dp) {
            Arrays.fill(i, -1);
        }
        System.out.println(minPathSumInGrid(grid, n-1, m-1, dp));
        System.out.println(minPathSumInGrid(n, m, grid));
    }
}
