public class TargetSum {
    public static int countWays(int nums[], int target) {
        int n=nums.length;
        int dp[][] = new int[n][target+1];
        if(nums[0]==0) {
            dp[0][0] = 2; // pick & nonPick
        } else {
            dp[0][0] = 1;
        }
        if(nums[0]!=0 && nums[0] <= target) dp[0][nums[0]] = 1;
        for(int i=1; i<n; i++) {
            for(int j=0; j<=target; j++) {
                int pick = 0;
                if(nums[i]<=j) pick = dp[i-1][j-nums[i]];
                int nonPick = dp[i-1][j];
                dp[i][j] = pick + nonPick;
            }
        }
        return dp[n-1][target];
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 1, 1}, target = 3;
        int totalSum = 0;
        for(int i: nums) totalSum += i;
        if((totalSum - target) < 0 || (totalSum - target) % 2 == 1) {
            System.out.println(-1);
            return;
        }
        int s2 = (totalSum - target) / 2;
        System.out.println(countWays(nums, s2));
    }
}
