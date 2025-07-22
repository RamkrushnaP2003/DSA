import java.util.Arrays;

public class HouseRobber {
    public static int houseRobber(int nums[]) {
        int dp1[] = new int[nums.length+1];
        int dp2[] = new int[nums.length+1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(maxSum(nums, dp1, nums.length-1, true), maxSum(nums, dp2, nums.length-2, false));
    }

    public static int maxSum(int nums[], int dp[], int n, boolean isFirst) {
        if(isFirst) {
            if(n<1) return 0;
            if(n==1) return nums[1];
        } else {
            if(n<0) return 0;
            if(n==1) return nums[0];
        }
        if(dp[n]!=-1) return dp[n];
        int nonPick = maxSum(nums, dp, n-1, isFirst);
        int pick = nums[n] + maxSum(nums, dp, n-2, isFirst);
        return dp[n] = Math.max(nonPick, pick);
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};
        System.out.println(houseRobber(nums));
    }
}