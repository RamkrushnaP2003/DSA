import java.util.Arrays;

public class WaysToMakeCoinChange {
    public static int countWays(int nums[], int target, int n) {
        if(n==0) return target % nums[0] == 0 ? 1 : 0;
        int pick = 0;
        if(nums[n]<=target) pick = countWays(nums, target-nums[n], n);
        int nonPick = countWays(nums, target, n-1);
        return pick + nonPick;
    }

    public static int countWays(int nums[], int target, int n, int dp[][]) {
        if(n==0) return target % nums[0] == 0 ? 1 : 0;
        int pick = 0;
        if(dp[n][target]!=-1) return dp[n][target];
        if(nums[n]<=target) pick = countWays(nums, target-nums[n], n, dp);
        int nonPick = countWays(nums, target, n-1, dp);
        return dp[n][target] = pick + nonPick;
    }

    public static int countWays(int nums[], int target) {
        int n=nums.length;
        int dp[][] = new int[n][target+1];
        for(int i=0; i<=target; i++) {
            if(target%nums[0]==0) dp[0][i] = 1;
        }
        for(int i=1; i<n; i++) {
            for(int j=0; j<=target; j++) {
                int pick = 0;
                if(nums[i] <= j) pick = dp[i][j-nums[i]];
                int nonPick = dp[i-1][j];
                dp[i][j] = pick + nonPick;
            }
        }
        return dp[n-1][target];
    }

    public static void main(String args[]) {
        int nums[] = {1, 2, 3}, target = 4;
        System.out.println(countWays(nums, target, nums.length-1));
        int dp[][] = new int[nums.length][target+1];
        for(int i[]: dp) Arrays.fill(i, -1);
        System.out.println(countWays(nums, target, nums.length-1));
        System.out.println(countWays(nums, target));
    }
}
