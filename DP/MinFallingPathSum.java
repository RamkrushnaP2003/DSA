import java.util.Arrays;

public class MinFallingPathSum {
    public final static int oneEnine=100000000;
    private static int f(int matrix[][], int i, int j, int n, int m, int dp[][]) {
        if(j<0 || j>=m) return 100000000; //for 1e9
        if(i==0) return matrix[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int top = matrix[i][j] + f(matrix, i-1, j, n, m, dp);
        int leftD = matrix[i][j] + f(matrix, i-1, j-1, n, m, dp);
        int rightD = matrix[i][j] + f(matrix, i-1, j+1, n, m, dp);
        return dp[i][j] = Math.min(top, Math.min(leftD, rightD));
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n=matrix.length, m=matrix[0].length;
        int min = Integer.MAX_VALUE;
        for(int j=0; j<m; j++) {
            int dp[][] = new int[n][m];
            for(int i[]: dp) {
                Arrays.fill(i, -1);
            }
            min = Math.min(min, f(matrix, n-1, j, n, m, dp));
        }
        return min;
    }

    public static int minFallingPathSumT(int[][] matrix) {
        int n=matrix.length, m=matrix[0].length;
        int dp[][] = new int[n][m];
        for(int i[]: dp) {
            Arrays.fill(i, -1);
        }
        for(int i=0; i<m; i++) {
            dp[0][i] = matrix[0][i];
        }
        int min=Integer.MAX_VALUE;
        for(int i=1; i<n; i++) {
            for(int j=0; j<m; j++) {
                int top = matrix[i][j] + dp[i-1][j];
                int leftD = oneEnine, rightD = oneEnine;
                if(j-1>=0) leftD = matrix[i][j] + dp[i-1][j-1];
                if(j+1<m) rightD = matrix[i][j] + dp[i-1][j+1];
                dp[i][j] = Math.min(top, Math.min(leftD, rightD));
                if(i==n-1) min = Math.min(dp[i][j], min);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(minFallingPathSum(matrix));
        System.out.println(minFallingPathSumT(matrix));
    }
}
