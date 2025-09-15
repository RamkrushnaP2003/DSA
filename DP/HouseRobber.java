import java.util.Arrays;

public class HouseRobber {
    public static int houseRobber(int nums[]) {
        int dp1[] = new int[nums.length+1];
        int dp2[] = new int[nums.length+1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        // int ans = Math.max(maxSum(nums, dp1, nums.length-1, true), maxSum(nums, dp2, nums.length-2, false));
        int ans = Math.max(maxSumT(nums, 0, nums.length-1), maxSumT(nums, 1, nums.length));
        // int ans = Math.max(maxSumSO(nums, 0, nums.length-1), maxSumSO(nums, 1, nums.length));
        return ans;
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

    public static int maxSumT(int nums[], int st, int end) {
        int dp[] = new int[end];
        Arrays.fill(dp, -1);
        dp[st] = nums[st];
        for(int i=st+1; i<end; i++) {
            int pick = nums[i];
            if(i > st+1) pick += dp[i-2];
            int nonPick = dp[i-1];
            dp[i] = Math.max(pick, nonPick);
        }
        return dp[end-1];
    }

    public static int maxSumSO(int nums[], int st, int end) {
        int prev1=0, prev2=nums[st], curr=0;
        for(int i=st+1; i<end; i++) {
            int pick = nums[i];
            if(i > st+1) pick += prev2;
            int nonPick = prev1;
            curr = Math.max(pick, nonPick);
            prev1 = prev2;
            prev2 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6};
        System.out.println(houseRobber(nums));
    }
}