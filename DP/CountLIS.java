import java.util.Arrays;

public class CountLIS {
    public static int countLIS(int nums[]) {
        int n=nums.length, max=0;
        int[] dp = new int[n], count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j] && dp[j]+1 > dp[i]) {
                    dp[i] = dp[j]+1;
                    count[i] = count[j];
                } else if(nums[i] > nums[j] && dp[j]+1 == dp[i]) {
                    count[i] += count[j];
                }
            }
            max = Math.max(count[i], max);
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {1, 5, 4, 3, 2, 6, 7, 10, 8, 9};
        System.out.println(countLIS(nums));
    }
}
