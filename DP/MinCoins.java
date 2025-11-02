import java.util.Arrays;

public class MinCoins {
    private static int one_e9=100000000;

    public static int minCoins(int coins[], int target, int n) {
        if(n==0) {
            if(target%coins[0]==0) return target/coins[0];
            return one_e9;
        }
        int pick = Integer.MAX_VALUE;
        if(coins[n]<=target) pick = 1 + minCoins(coins, target-coins[n], n);
        int nonPick = minCoins(coins, target, n-1);
        return Math.min(pick, nonPick);
    }

    public static int minCoins(int coins[], int target, int n, int dp[][]) {
        if(n==0) {
            if(target%coins[0]==0) return target/coins[0];
            return one_e9;
        }
        if(dp[n][target]!=-1) return dp[n][target];
        int pick = Integer.MAX_VALUE;
        if(coins[n]<=target) pick = 1 + minCoins(coins, target-coins[n], n);
        int nonPick = minCoins(coins, target, n-1);
        return dp[n][target] = Math.min(pick, nonPick);
    }

    public static int minCoins(int coins[], int target) {
        int n = coins.length;
        int dp[][] = new int[n][target+1];
        for(int i=0; i<=target; i++ ){
            if(i%coins[0]==0) dp[0][i] = i/coins[0];
            else dp[0][i] = one_e9;
        }
        for(int i=1; i<n; i++) {
            for(int j=1; j<=target; j++) {
                int pick = Integer.MAX_VALUE;
                if(coins[i]<=j) pick = 1 + dp[i][j-coins[i]];
                int nonPick = dp[i-1][j];
                dp[i][j] = Math.min(pick, nonPick);
            }
        }
        return dp[n-1][target];
    }

    public static void main(String[] args) {
        int coins[] = {9, 6, 5, 1}, target=11, n=coins.length;
        System.out.println(minCoins(coins, target, coins.length-1));
        int dp[][] = new int[n][target+1];
        for(int i[]: dp) Arrays.fill(i, -1);
        System.out.println(minCoins(coins, target, n-1, dp));
        System.out.println(minCoins(coins, target));
    }
}
