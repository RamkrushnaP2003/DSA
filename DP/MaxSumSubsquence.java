import java.util.Arrays;

public class MaxSumSubsquence {
    public static int maxSum(int nums[], int n) {
        if(n==0) return nums[n];
        if(n<0) return 0;
        int pick = nums[n]+maxSum(nums, n-2);
        int nonPick = maxSum(nums, n-1);
        return Math.max(pick, nonPick);
    }

    public static int maxSumM(int nums[], int dp[], int n) {
        if(n==0) return nums[n];
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];
        int pick = nums[n] + maxSumM(nums, dp, n-2);
        int nonPick = maxSumM(nums, dp, n-1);
        return dp[n] = Math.max(pick, nonPick);
    }

    public static int maxSumT(int nums[], int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        for(int i=1; i<=n; i++) {
            int pick = nums[i];
            if(i > 1) pick += dp[i-2];
            int nonPick = dp[i-1];
            dp[i] = Integer.max(pick, nonPick);
        }
        return dp[n];
    }

    public static int maxSumSO(int nums[]) {
        int prev1=nums[0], prev2=0, curr=0;
        for(int i=1; i<nums.length; i++) {
            int pick = nums[i];
            if(i>1) pick += prev2;
            int nonPick = prev1;
            curr = Math.max(pick, nonPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

    public static void main(String[] args) {
        int nums[] = {2, 1, 4, 9};
        System.out.println(maxSum(nums, nums.length-1));
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp, -1);
        System.out.println(maxSumM(nums, dp, nums.length-1));
        System.out.println(maxSumT(nums, nums.length-1));
        System.out.println(maxSumSO(nums));
    }
}
