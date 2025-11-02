public class PartitionASetIntoTwoSubsetsWithMinimumAbsoluteSumDifference {
    public static int minDiff(int nums[]) {
        int target=0;
        for(int i: nums) target += i;
        int n=nums.length;
        boolean dp[][] = new boolean[n][target+1];
        for(int i=0; i<n; i++) {
            dp[i][0] = true;
        }
        if(nums[0]>target) dp[0][nums[0]] = true;
        for(int i=1; i<nums.length; i++) {
            for(int j=1; j<=target; j++) {
                boolean pick = false;
                if(nums[i]<=j) pick = dp[i-1][j-nums[i]];
                boolean nonPick = dp[i-1][j];
                dp[i][j] = pick || nonPick;
            }
        }
        int len=target/2, min=Integer.MAX_VALUE;
        for(int i=0; i<len; i++) {
            if(dp[n-1][i]) {
                min = Math.min(min, Math.abs(target - 2*i));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 3, 3, 4};
        System.out.println(minDiff(nums));
    }
}
