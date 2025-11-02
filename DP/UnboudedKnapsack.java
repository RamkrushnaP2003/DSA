import java.util.Arrays;

public class UnboudedKnapsack {
    public static int unboudedKnapsack(int val[], int wt[], int W, int n) {
        if(n==0) {
            return (W/wt[n]) * val[0];
        }
        int pick = 0;
        if(wt[n]<=W) pick = val[n] + unboudedKnapsack(val, wt, W-wt[n], n);
        int nonPick = unboudedKnapsack(val, wt, W, n-1);
        return Math.max(pick, nonPick);
    }

    public static int unboudedKnapsack(int val[], int wt[], int W, int n, int dp[][]) {
        if(n==0) {
            return (W/wt[n]) * val[0];
        }
        if(dp[n][W] != -1) return dp[n][W];
        int pick = Integer.MIN_VALUE;
        if(wt[n]<=W) pick = val[n] + unboudedKnapsack(val, wt, W-wt[n], n, dp);
        int nonPick = unboudedKnapsack(val, wt, W, n-1, dp);
        return dp[n][W] = Math.max(pick, nonPick);
    }

    public static int unboudedKnapsack(int val[], int wt[], int W) {
        int n=val.length;
        int dp[][] = new int[n][W+1]; 
        for(int i=0; i<=W; i++) {
            dp[0][i] = ((int)i/wt[0]) * val[0];
        }
        for(int i=1; i<n; i++) {
            for(int j=0; j<=W; j++) {
                int pick = Integer.MIN_VALUE;
                if(wt[i]<=j) pick = val[i] + dp[i][j-wt[i]];
                int nonPick = dp[i-1][j];
                dp[i][j] = Math.max(pick, nonPick);
            }
        }
        return dp[n-1][W];
    }

    public static void main(String[] args) {
        int val[] = {5, 11, 13}, wt[] = {2, 4, 6}, W=10;
        System.out.println(unboudedKnapsack(val, wt, W, val.length-1));
        int dp[][] = new int[val.length][W+1];
        for(int i[]: dp) Arrays.fill(i, -1);
        System.out.println(unboudedKnapsack(val, wt, W, val.length-1, dp));
        System.out.println(unboudedKnapsack(val, wt, W));
    }
}
