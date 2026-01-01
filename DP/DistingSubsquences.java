import java.util.Arrays;

public class DistingSubsquences {
    public static int distingSubsquences(String str1, String str2, int n, int m) {
        if(m<0) return 1; // base case order matter here
        if(n<0) return 0;
        if(str1.charAt(n) == str2.charAt(m)) {
            return distingSubsquences(str1, str2, n-1, m-1) + distingSubsquences(str1, str2, n-1, m);
        } else {
            return distingSubsquences(str1, str2, n-1, m);
        }
    }

    public static int distingSubsquences(String str1, String str2, int n, int m, int dp[][]) {
        if(m<0) return 1; // base case order matter here
        if(n<0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        if(str1.charAt(n) == str2.charAt(m)) {
            return dp[n][m] = distingSubsquences(str1, str2, n-1, m-1) + distingSubsquences(str1, str2, n-1, m);
        } else {
            return dp[n][m] = distingSubsquences(str1, str2, n-1, m);
        }
    }

    public static int distingSubsquences(String str1, String str2) {
        int n=str1.length(), m=str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int j=0; j<=m; j++) { // 0 col = 1 as per recusrion base case otherwise it will give wrong ans
            dp[0][j] = 0;
        }
        for(int i=0; i<=n; i++) { // 0 row = 0 as per recusrion base case otherwise it will give wrong ans
            dp[i][0] = 1;
        }
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1="rabbbit", str2="rabbit";
        System.out.println(distingSubsquences(str1, str2, str1.length()-1, str2.length()-1));
        int dp[][] = new int[str1.length()][str2.length()];
        for(int i[]: dp) Arrays.fill(i, -1);
        System.out.println(distingSubsquences(str1, str2, str1.length()-1, str2.length()-1, dp));
        System.out.println(distingSubsquences(str1, str2));
    }
}
