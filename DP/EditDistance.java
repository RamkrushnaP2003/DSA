import java.util.Arrays;

public class EditDistance {
    public static int editDistance(String str1, String str2, int n, int m) {
        if(m==0) return n;
        if(n==0) return m;
        if(str1.charAt(n-1)==str2.charAt(m-1)) {
            return editDistance(str1, str2, n-1, m-1);
        } else {
            int insert = 1 + editDistance(str1, str2, n, m-1);
            int delete = 1 + editDistance(str1, str2, n-1, m);
            int update = 1 +editDistance(str1, str2, n-1, m-1);
            return Math.min(update, Math.min(insert, delete));
        }
    }

    public static int editDistance(String str1, String str2, int n, int m, int dp[][]) {
        if(m==0) return n;
        if(n==0) return m;
        if(dp[n][m]!=-1) return dp[n][m];
        if(str1.charAt(n-1)==str2.charAt(m-1)) {
            return dp[n][m] = editDistance(str1, str2, n-1, m-1, dp);
        } else {
            int insert = 1 + editDistance(str1, str2, n, m-1, dp);
            int delete = 1 + editDistance(str1, str2, n-1, m, dp);
            int update = 1 + editDistance(str1, str2, n-1, m-1, dp);
            return dp[n][m] = Math.min(update, Math.min(insert, delete));
        }
    }

    public static int editDistance(String str1, String str2) {
        int n=str1.length(), m=str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<=n; i++) {
            dp[i][0] = i;
        }
        for(int j=0; j<=m; j++) {
            dp[j][0] = j;
        }
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int insert = 1 + dp[i][j-1];
                    int update = 1 + dp[i-1][j-1];
                    int delete = 1 + dp[i-1][j];
                    dp[i][j] = Math.min(insert, Math.min(update, delete));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1="intention", str2="execution";
        System.out.println(editDistance(str1, str2, str1.length()-1, str2.length()-1));
        int[][] dp = new int[str1.length()][str2.length()];
        for(int i[]: dp) Arrays.fill(i, -1);
        System.out.println(editDistance(str1, str2, str1.length()-1, str2.length()-1, dp));
        System.out.println(editDistance(str1, str2));
    }
}
