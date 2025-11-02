import java.util.Arrays;

public class FrogJump {
    public static int frogJump(int stones[], int n) {
        if(n==0) return 0;
        int left = frogJump(stones, n-1) + Math.abs(stones[n] - stones[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1) right = frogJump(stones, n-2) + Math.abs(stones[n] - stones[n-2]);
        return Math.min(left, right);
    }

    public static int frogJumpM(int stones[], int n, int dp[]) {
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int left = frogJumpM(stones, n-1, dp) + Math.abs(stones[n] - stones[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1) right = frogJumpM(stones, n-2, dp) + Math.abs(stones[n] - stones[n-2]);
        return dp[n] = Math.min(left, right);
    }

    public static int frogJumpT(int stones[], int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i=1; i<=n; i++) {
            int left = dp[i-1] + Math.abs(stones[i-1] - stones[i]);
            int right = Integer.MAX_VALUE;
            if(i>1) right = dp[i-2] + Math.abs(stones[i-2] - stones[i]);
            dp[i] = Math.min(left, right);
        }
        return dp[n];
    }

    public static int frogJumpSO(int stones[], int n) {
        int m2=0, m1=0;
        for(int i=1; i<stones.length; i++) {
            int left = m1 + Math.abs(stones[i] - stones[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1) right = m2 + Math.abs(stones[i] - stones[i-2]);
            int curr = Math.min(left, right);
            m2 = m1;
            m1 = curr;
        }
        return m1;
    }

    public static void main(String[] args) {
        int stones[] = {30, 10, 60, 10, 60, 50}, n=stones.length;
        System.out.println(frogJump(stones, n-1));
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(frogJumpM(stones, n-1, dp));
        System.out.println(frogJumpT(stones, n-1));
        System.out.println(frogJumpSO(stones, n));
    }
}
