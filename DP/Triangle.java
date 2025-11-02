import java.util.Arrays;

public class Triangle {
    static int oneEnine = 100000000;

    public static int triangle(int a[][], int i, int j) {
        if(a.length-1==i) return a[i][j];
        int down = a[i][j] + triangle(a, i+1, j);
        int diagonal = a[i][j] + triangle(a, i+1, j+1);
        return Math.min(down, diagonal);
    }

    public static int triangle(int a[][], int i, int j, int dp[][]) {
        if(a.length-1==i) return a[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int down = a[i][j] + triangle(a, i+1, j, dp);
        int diagonal = a[i][j] + triangle(a, i+1, j+1, dp);
        return dp[i][j] = Math.min(down, diagonal);
    }

    public static int triangle(int a[][]) {
        int n=a.length;
        int dp[][] = new int[n][n];
        for(int j=0; j<n; j++) {
            dp[n-1][j] = a[n-1][j];
        }
        for(int i=n-2; i>=0; i--) {
            for(int j=i; j>=0; j--) {
                int down = a[i][j] + dp[i+1][j];
                int diagonl = a[i][j] + dp[i+1][j+1];
                dp[i][j] = Math.min(diagonl, down);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] a = {{1},
                     {6, 3},
                     {4, 5, 6},
                     {7, 8, 9, 10}};
        System.out.println(triangle(a, 0, 0));
        int dp[][] = new int[a.length][a[a.length-1].length];
        for(int i[]: dp) Arrays.fill(i, -1);
        System.out.println(triangle(a, 0, 0, dp));
        System.out.println(triangle(a));
    }
}
