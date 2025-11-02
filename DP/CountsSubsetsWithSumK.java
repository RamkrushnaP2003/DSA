import java.util.Arrays;

public class CountsSubsetsWithSumK {
    public static int countsSubsetsWithSumK(int nums[], int idx, int target) {
        if(target==0) return 1;
        if(idx==0) return (nums[idx]==target) ? 1 : 0;
        int pick = 0;
        if(nums[idx]<=target) pick = countsSubsetsWithSumK(nums, idx-1, target-nums[idx]);
        int nonPick = countsSubsetsWithSumK(nums, idx-1, target);
        return pick + nonPick;
    }

    public static int countsSubsetsWithSumK(int nums[], int idx, int target, int dp[][]) {
        if(target==0) return 1;
        if(idx==0) return (nums[idx]==target) ? 1 : 0;
        if(dp[idx][target]!=-1) return dp[idx][target];
        int pick = 0;
        if(nums[idx]<=target) pick = countsSubsetsWithSumK(nums, idx-1, target-nums[idx]);
        int nonPick = countsSubsetsWithSumK(nums, idx-1, target);
        return dp[idx][target] = pick + nonPick;
    }

    public static int countsSubsetsWithSumK(int nums[], int target) {
        int n=nums.length;
        int dp[][] = new int[n][target+1];
        for(int i=0; i<nums.length; i++) dp[i][0] = 1;
        if(target>=nums[0]) dp[0][nums[0]] = 1;
        for(int idx=1; idx<n; idx++) {
            for(int j=1; j<=target; j++) {
                int pick = 0;
                if(nums[idx]<=j) pick = dp[idx-1][j-nums[idx]];
                int nonPick = dp[idx-1][j];
                dp[idx][j] = pick + nonPick;
            }
        }
        return dp[n-1][target];
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 2, 3, 3}, target=3;
        System.out.println(countsSubsetsWithSumK(nums, nums.length-1, target));
        int dp[][] = new int[nums.length][target+1];
        for(int i[]: dp) {
            Arrays.fill(i, -1);
        }
        System.out.println(countsSubsetsWithSumK(nums, nums.length-1, target, dp));
        System.out.println(countsSubsetsWithSumK(nums, target));
    }
}
