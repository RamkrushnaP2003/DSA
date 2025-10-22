import java.util.Arrays;

public class SubsetSumEqualTarget {
    public static boolean isContainsTargainInNums(int nums[], int n, int target) {
        if(target==0) return true;
        if(n==0) return nums[n]==target;
        boolean pick = false;
        if(nums[n]<=target) {
            pick = isContainsTargainInNums(nums, n-1, target-nums[n]);
        }
        boolean nonPick = isContainsTargainInNums(nums, n-1, target);
        return pick || nonPick;
    }

    public static boolean isContainsTargainInNums(int nums[], int n, int target, int dp[][]) {
        if(target==0) return true;
        if(n==0) return nums[n]==target;
        if(dp[n][target]!=-1) {
            if(dp[n][target]==0) return false;
            else return true;
        }
        boolean pick = false;
        if(nums[n]<=target) {
            pick = isContainsTargainInNums(nums, n-1, target-nums[n]);
        }
        boolean nonPick = isContainsTargainInNums(nums, n-1, target);
        dp[n][target] = (pick || nonPick) ? 1 : 0;
        return pick || nonPick;
    }

    public static boolean isContainsTargainInNums(int target ,int nums[]) {
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
        int nums[] = {3, 34, 4, 12, 5, 2}, target=10, n=nums.length;
        System.out.println(isContainsTargainInNums(nums, n-1, target));
        int dp[][] = new int[n+1][target+1];
        for(int i[]: dp) {
            Arrays.fill(i, -1);
        }
        System.out.println(isContainsTargainInNums(nums, n-1, target, dp));
        System.out.println(isContainsTargainInNums(target, nums));
    }
}
