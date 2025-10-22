import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static boolean subset(int nums[], int n, int target) {
        if(target==0) return true;
        if(n==0) return target==nums[n];
        boolean pick = false;
        if(nums[n]<=target) pick = subset(nums, n-1, target-nums[n]);
        boolean nonPick = subset(nums, n-1, target);
        return pick || nonPick;
    }

    public static boolean subset(int nums[], int n, int target, int dp[][]) {
        if(target==0) return true;
        if(n==0) return target==nums[0];
        if(dp[n][target]!=-1) return dp[n][target]==1;
        boolean pick = false;
        if(nums[n]<=target) pick = subset(nums, n-1, target-nums[n], dp);
        boolean nonPick = subset(nums, n-1, target, dp);
        dp[n][target] = pick || nonPick ? 1 : 0;
        return pick || nonPick;
    }

    public static boolean subset(int nums[], int target) {
        if(target < nums[0]) return false;
        int n=nums.length;
        boolean dp[][] = new boolean[n][target+1];
        dp[0][nums[0]] = true;
        for(int i=0; i<n; i++) dp[i][0] = true;
        for(int i=1; i<n; i++) {
            for(int j=1; j<=target; j++) {
                boolean pick = false;
                if(nums[i] <= j) pick = dp[i-1][j-nums[i]];
                boolean nonPick = dp[i-1][j];
                dp[i][j] = pick || nonPick;
            }
        }
        return dp[n-1][target];
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 3, 3, 4, 5};
        int sum=0;
        for(int i: nums) sum += i;
        if(sum%2==1) {
            System.out.println(false);
            return;
        }
        System.out.println(subset(nums, nums.length-1, sum/2));
        int dp[][] = new int[nums.length][(sum/2)+1];
        for(int i[]: dp) Arrays.fill(i, -1);
        System.out.println(subset(nums, nums.length-1, sum/2, dp));
        System.out.println(subset(nums, sum/2));
    }
}
