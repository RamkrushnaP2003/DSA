import java.util.Arrays;

public class FrogJumpKDist {
    public static int frogJump(int stones[], int k, int n) {
        if(n==0) return 0;
        int minJump = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++) {
            int jump = Integer.MAX_VALUE;
            if(n-i>=0) jump = frogJump(stones, k, n-i) + Math.abs(stones[n] - stones[n-i]);
            minJump = Math.min(minJump, jump);
        }
        return minJump;
    }

    public static int frogJumpM(int stones[], int dp[], int k, int n) {
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int minJump = Integer.MAX_VALUE;
        for(int i=1; i<=k; i++) {
            int jump = Integer.MAX_VALUE;
            if(n-i>=0) jump = frogJumpM(stones, dp, k, n-i) + Math.abs(stones[n] - stones[n-i]);
            minJump = Math.min(minJump, jump);
        }
        return minJump;
    }

    public static int frogJumpT(int stones[], int k, int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for(int i=1; i<=n; i++) {
            int minJump = Integer.MAX_VALUE;
            for(int j=1; j<=k; j++) {
                int jump = Integer.MAX_VALUE;
                if(i-j>=0) jump = dp[i-j] + Math.abs(stones[i] - stones[i-j]);
                minJump = Math.min(minJump, jump);
            }
            dp[i] = minJump;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int stones[] = {30, 10, 60, 10, 60, 50};
        System.out.println(frogJump(stones, 2, stones.length-1));
        int dp[] = new int[stones.length];
        Arrays.fill(dp, -1);
        System.out.println(frogJumpM(stones, dp, 2, stones.length-1));
        System.out.println(frogJumpT(stones, 2, stones.length-1));
    }
}
