import java.util.Arrays;

public class CountPartitionsWithGivenDifference {
    public static int countPartitionsWithGivenDifference(int nums[], int ind, int target) {
        if(ind == 0) {
            if(nums[0]==0 && target==0) return 2;
            else if(nums[0]==target || target==0) return 1;
            return 0;
        }
        int pick = 0;
        if(nums[ind]<=target) pick = countPartitionsWithGivenDifference(nums, ind-1, target-nums[ind]);
        int nonPick = countPartitionsWithGivenDifference(nums, ind-1, target);
        return pick + nonPick;
    }

    public static int countPartitionsWithGivenDifference(int nums[], int ind, int target, int dp[][]) {
        if(ind == 0) {
            if(nums[0]==0 && target==0) return 2;
            else if(nums[0]==target || target==0) return 1;
            return 0;
        }
        if(dp[ind][target]!=-1) return dp[ind][target];
        int pick = 0;
        if(nums[ind]<=target) pick = countPartitionsWithGivenDifference(nums, ind-1, target-nums[ind]);
        int nonPick = countPartitionsWithGivenDifference(nums, ind-1, target);
        return dp[ind][target] = pick + nonPick;
    }

    public static int countPartitionsWithGivenDifference(int nums[], int target) {
        int n=nums.length;
        int dp[][] = new int[n][target+1];
        if(nums[0]==0) {
            dp[0][0] = 2;
        } else {
            dp[0][0] = 1;
        } 
        if(nums[0]!=0 && nums[0]==target) { // nums[0]!=0 convert dp[0][nums[0]] = 2 -> 1 then will give wrong ans 
            dp[0][nums[0]] = 1;
        }
        for(int i=1; i<n; i++) {
            for(int j=1; j<=target; j++) {
                int pick = 0;
                if(nums[i]<=j) pick = dp[i-1][j-nums[i]];
                int nonPick = dp[i-1][j];
                dp[i][target] = pick + nonPick;
            }
        }
        return dp[n-1][target];
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 1}, d=0; // 0 <= nums[i] <= 6 && 1 <= nums.length <= 50
        int totalSum = 0;
        for(int i: nums) totalSum += i;
        int target = (totalSum - d) / 2;
        int dp[][] = new int[nums.length][target];
        for(int i[]: dp) Arrays.fill(i, -1);
        System.out.println(countPartitionsWithGivenDifference(nums, nums.length-1, target));
        System.out.println(countPartitionsWithGivenDifference(nums, nums.length-1, target));
        System.out.println(countPartitionsWithGivenDifference(nums, nums.length-1, target));
    }
}
