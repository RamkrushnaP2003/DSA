import java.util.Arrays;

public class RodCutting {
    public static int maxPrice(int price[], int N, int n) {
        if(n==0) return N*price[n];
        int take = Integer.MIN_VALUE;
        int rodLen = n+1;
        if(rodLen<=N) take = price[n] + maxPrice(price, N-rodLen, n);
        int notTake = maxPrice(price, N, n-1);
        return Math.max(take, notTake);
    }

    public static int maxPrice(int price[], int N, int n, int dp[][]) {
        if(n==0) return N*price[n];
        if(dp[n][N]!=-1) return dp[n][N];
        int take = Integer.MIN_VALUE;
        int rodLen = n+1;
        if(rodLen<=N) take = price[n] + maxPrice(price, N-rodLen, n, dp);
        int notTake = maxPrice(price, N, n-1, dp);
        return dp[n][N] = Math.max(take, notTake);
    }

    public static int maxPrice(int price[]) {
        int n=price.length, rodLen = n;
        int dp[][] = new int[n][rodLen+1];
        for(int i=0; i<=rodLen; i++) dp[0][i] = i*price[0];
        for(int i=1; i<n; i++) {
            for(int j=1; j<=rodLen; j++) {
                int pick = Integer.MIN_VALUE;
                int rodLenght = i+1;
                if(rodLenght<=j) pick = price[i] + dp[i][j-rodLenght];
                int nonPick = dp[i-1][j];
                dp[i][j] = Math.max(pick, nonPick);
            }
        }
        return dp[n-1][rodLen];
    }

    public static void main(String[] args) {
        int price[] = {3, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(maxPrice(price, price.length, price.length-1));
        int dp[][] = new int[price.length][price.length+1];
        for(int i[]: dp) Arrays.fill(i, -1);
        System.out.println(maxPrice(price, price.length, price.length-1, dp));
        System.out.println(maxPrice(price));
    }
}
