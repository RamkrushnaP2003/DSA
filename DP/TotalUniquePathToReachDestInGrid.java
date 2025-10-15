import java.util.Arrays;

public class TotalUniquePathToReachDestInGrid {
    public static int countWays(int m, int n) {
        if(m==0 && n==0) return 1;
        if(m<0) return 0;
        if(n<0) return 0;
        int top = countWays(m-1, n);
        int left = countWays(m, n-1);
        return top + left;
    }

    public static long countWays(int m, int n, long[][] dp) {
        if(m==0 && n==0) return 1L;
        if(m<0 || n<0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        long top = countWays(m-1, n, dp);
        long left = countWays(m, n-1, dp);
        return dp[n][m] = top + left;
    }

    public static long countWays(long dp[][], int m, int n) {
        dp[0][0] = 1;
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if(i==0&&j==0) dp[i][j] = 1;
                else {
                    long top = 0, left = 0;
                    if(i>0)top = dp[i-1][j];
                    if(j>0)left = dp[i][j-1];
                    dp[i][j] = top + left;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int n = 10, m = 7;
        long dp[][] = new long[n][m];
        for(long i[]: dp) {
            Arrays.fill(i, -1);
        }
        System.out.println(countWays(m-1, n-1, dp));
        System.out.println(countWays(m-1, n-1));
        dp = new long[n][m];
        System.out.println(countWays(dp, m-1, n-1));
    }
}
