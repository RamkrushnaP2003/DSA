import java.util.Arrays;

public class ZeroOneKnapsack {
    public static int maxProfit(int[] val, int wt[], int W, int n) {
        if(n==0) {
            if(wt[0]<=W) return val[0];
            else return 0;
        }
        int pick = Integer.MIN_VALUE;
        if(wt[n]<=W) pick = val[n] + maxProfit(val, wt, W-wt[n], n-1);
        int nonPick = maxProfit(val, wt, W, n-1);
        return Math.max(pick, nonPick);
    }

    public static int maxProfit(int[] val, int wt[], int W, int n, int[][] dp) {
        if(n==0) {
            if(wt[0]<=W) return val[0];
            else return 0;
        }
        if(dp[n][W]!=-1) return dp[n][W];
        int pick = Integer.MIN_VALUE;
        if(wt[n]<=W) pick = val[n] + maxProfit(val, wt, W-wt[n], n-1);
        int nonPick = maxProfit(val, wt, W, n-1);
        return dp[n][W] = Math.max(pick, nonPick);
    }

    public static int maxProfit(int val[], int wt[], int W) {
        int n=val.length;
        int dp[][] = new int[n][W+1];
        for(int i=wt[0]; i<=W; i++) dp[0][i] = val[0];
        for(int i=1; i<n; i++) {
            for(int j=1; j<=W; j++) {
                int pick = Integer.MIN_VALUE;
                if(wt[i]<=j) pick = val[i] + dp[i-1][j - wt[i]];
                int nonPick = dp[i-1][j];
                dp[i][j] = Math.max(pick, nonPick);
            }
        }
        return dp[n-1][W];
    }

    public static void main(String args[]) {
        int val[] = {1, 2, 3}, wt[] = {4, 5, 1}, W=4;
        System.out.println(maxProfit(val, wt, W, val.length-1));
        int dp[][] = new int[val.length][W+1];
        for(int i[]: dp) Arrays.fill(i, -1);
        System.out.println(maxProfit(val, wt, W, val.length-1, dp));
        System.out.println(maxProfit(val, wt, W));
    }
}
