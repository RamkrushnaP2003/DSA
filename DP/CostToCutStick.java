import java.util.Arrays;

public class CostToCutStick {
    public static int minCost(int cuts[], int i, int j) {
        if(i>j) return 0;
        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j; k++) {
            int cost = cuts[j+1] - cuts[i-1] + minCost(cuts, i, k-1) + minCost(cuts, k+1, j);
            min = Math.min(min, cost);
        }
        return min;
    }

    public static int minCost(int cuts[], int i, int j, int dp[][]) {
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k=i; k<=j; k++) {
            int cost = cuts[j+1] - cuts[i-1] + minCost(cuts, i, k-1) + minCost(cuts, k+1, j);
            min = Math.min(min, cost);
        }
        return dp[i][j] = min;
    }

    public static int minCost(int cuts[], int N) {
        int newCuts[] = new int[cuts.length+2];
        newCuts[0] = 0;
        newCuts[cuts.length+1] = N;
        for(int i=0; i<cuts.length; i++) {
            newCuts[i+1] = cuts[i];
        }
        Arrays.sort(newCuts);
        int n = cuts.length;
        int dp[][] = new int[newCuts.length][N+1];
        for(int i=n; i>=1; i--) {
            for(int j=1; j<=n; j++) {
                if(i > j) continue;
                int min = Integer.MAX_VALUE;
                for(int k=i; k<=j; k++) {
                    int cost = newCuts[j+1] - newCuts[i-1] + dp[i][k-1] + dp[k+1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][newCuts.length-2];
    }

    public static void main(String[] args) {
        int cuts[] = {5, 4, 1, 3}, N=7;
        System.out.println(minCost(cuts, N));
        int newCuts[] = new int[cuts.length+2];
        newCuts[0] = 0;
        newCuts[cuts.length+1] = N;
        for(int i=0; i<cuts.length; i++) {
            newCuts[i+1] = cuts[i];
        }
        Arrays.sort(newCuts);
        System.out.println(minCost(newCuts, 1, newCuts.length-2));
        int dp[][] = new int[N][N];
        for(int i[]: dp) Arrays.fill(i, -1);
        System.out.println(minCost(newCuts, 1, newCuts.length-2, dp));
    }   
}
