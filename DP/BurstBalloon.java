import java.util.Arrays;

public class BurstBalloon {
    public static int maxCoins(int nums[], int i, int j) {
        if(i > j) return 0;
        int maxCost = Integer.MIN_VALUE;
        for(int k=i; k<=j; k++) {
            int cost = (nums[i-1] * nums[k] * nums[j+1]) + maxCoins(nums, i, k-1) + maxCoins(nums, k+1, j);
            maxCost = Math.max(maxCost, cost);
        }
        return maxCost;
    }

    public static int maxCoins(int nums[], int i, int j, int dp[][]) {
        if(i > j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int maxCost = Integer.MIN_VALUE;
        for(int k=i; k<=j; k++) {
            int cost = (nums[i-1] * nums[k] * nums[j+1]) + maxCoins(nums, i, k-1) + maxCoins(nums, k+1, j);
            maxCost = Math.max(maxCost, cost);
        }
        return dp[i][j] = maxCost;
    }

    public static int maxCoins(int nums[]) {
        int newNums[] = new int[nums.length+2];
        newNums[0] = 1;
        for(int i=0; i<nums.length; i++) {
            newNums[i+1] = nums[i];
        }
        newNums[newNums.length-1] = 1;
        int dp[][] = new int[newNums.length][newNums.length];
        int n=newNums.length;
        for(int i=n-2; i>=1; i--) {
            for(int j=1; j<n-1; j++) {
                if(i > j) continue;
                int maxCost = Integer.MIN_VALUE;
                for(int k=i; k<=j; k++) {
                    int cost = (newNums[i-1] * newNums[k] * newNums[j+1]) + dp[i][k-1] + dp[k+1][j];
                    maxCost = Math.max(maxCost, cost);
                }
                dp[i][j] = maxCost;
            }
        }
        return dp[1][n-2];
    }

    public static void main(String[] args) {
        int nums[] = {3, 1, 5};
        System.out.println(maxCoins(nums));
        // adjust oveflow condition
        int newNums[] = new int[nums.length+2];
        newNums[0] = 1;
        for(int i=0; i<nums.length; i++) {
            newNums[i+1] = nums[i];
        }
        newNums[newNums.length-1] = 1;
        int dp[][] = new int[newNums.length][newNums.length];
        for(int i[]: dp) Arrays.fill(i, -1);
        System.out.println(maxCoins(newNums, 1, newNums.length-2));
        System.out.println(maxCoins(newNums, 1, newNums.length-2, dp));
    }
}
