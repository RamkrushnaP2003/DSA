import java.util.Arrays;

public class PartitionArrayMaxSum {
    public static int maxSum(int nums[] , int k, int i) {
        if(i==nums.length) return 0;
        int maxEle = Integer.MIN_VALUE, maxAns = Integer.MIN_VALUE;
        int maxlen = Math.min(k+i, nums.length);
        for(int j=i; j<maxlen; j++) {
            maxEle = Math.max(maxEle, nums[j]);
            int sum = ((j-i+1) * maxEle) + maxSum(nums, k, j+1);
            maxAns = Math.max(maxAns, sum);
        }
        return maxAns;
    }

    public static int maxSum(int nums[] , int k, int i, int dp[]) {
        if(i==nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int maxEle = Integer.MIN_VALUE, maxAns = Integer.MIN_VALUE;
        int maxlen = Math.min(k+i, nums.length);
        for(int j=i; j<maxlen; j++) {
            maxEle = Math.max(maxEle, nums[j]);
            int sum = ((j-i+1) * maxEle) + maxSum(nums, k, j+1, dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[i] = maxAns;
    }

    public static int maxSum(int nums[] , int k) {
        int n=nums.length;
        int dp[] = new int[n+1];
        dp[n]=0;
        for(int i=n-1; i>=0; i--) {
            int maxEle = Integer.MIN_VALUE, maxAns = Integer.MIN_VALUE;
            int maxlen = Math.min(k+i, nums.length);
            for(int j=i; j<maxlen; j++) {
                maxEle = Math.max(maxEle, nums[j]);
                int sum = ((j-i+1) * maxEle) + dp[j+1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int nums[] = {1, 15, 7, 9, 2, 5, 10}, k=3; // -> ans = {1, 15, 7 | 9 | 2, 5, 10} = {15, 15, 15 | 9 | 10, 10, 10} = 84;
        System.out.println(maxSum(nums, k, 0));
        int dp[] = new int[nums.length+1];
        Arrays.fill(dp, -1);
        System.out.println(maxSum(nums, k, 0, dp));
        System.out.println(maxSum(nums, k));
    }
}
