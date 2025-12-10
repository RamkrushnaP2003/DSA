import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static int lis(int nums[], int idx, int prevIdx) {
        if(nums.length == idx) return 0;
        int pick = 0;
        if(prevIdx==-1 || nums[idx] > nums[prevIdx]) {
            pick = 1 + lis(nums, idx+1, idx);
        }
        int nonPick = lis(nums, idx+1, prevIdx);
        return Math.max(pick, nonPick);
    }

    public static int lis(int nums[], int idx, int prevIdx, int dp[][]) {
        if(nums.length == idx) return 0;
        if(dp[idx][prevIdx+1]!=-1) return dp[idx][prevIdx+1];
        int pick = 0;
        if(prevIdx==-1 || nums[idx] > nums[prevIdx]) {
            pick = 1 + lis(nums, idx+1, idx);
        }
        int nonPick = lis(nums, idx+1, prevIdx);
        return dp[idx][prevIdx+1] = Math.max(pick, nonPick);
    }

    public static int lis(int nums[]) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int i=n-1; i>=0; i--) {
            for(int j=i-1; j>=-1; j--) {
                int pick = 0;
                if(j==-1 || nums[i] > nums[j]) {
                    pick = 1 + dp[i+1][i+1];
                }
                int nonPick = dp[i+1][j+1];
                dp[i][j+1] = Math.max(pick, nonPick);
            }
        }
        return dp[0][-1+1];
    }

    public static int lisSO(int nums[]) {
        List<Integer> ans = new ArrayList<>(); 
        int n = nums.length;
        int dp[] = new int[n+1];
        int hash[] = new int[n+1];
        for(int i=0; i<=n; i++) {
            hash[i] = i;
        }
        Arrays.fill(dp, 1);
        int max=0;
        int maxInd = -1;
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j] && dp[j]+1 > dp[i]) {
                    dp[i] = dp[j]+1;
                    hash[i] = j;
                }
            }
            if(max < dp[i]) {
                max = dp[i];
                maxInd = i;
            }
        }
        while (maxInd != hash[maxInd]) {
            ans.add(nums[maxInd]);
            maxInd = hash[maxInd];
        }
        ans.add(nums[maxInd]);
        System.out.println(ans);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 198};
        System.out.println(lis(nums, 0, -1));
        int dp[][] = new int[nums.length+1][nums.length+1];
        for(int i[]: dp) Arrays.fill(i, -1);
        System.out.println(lis(nums, 0, -1, dp));
        System.out.println(lis(nums));
        System.out.println(lisSO(nums));
    }
}