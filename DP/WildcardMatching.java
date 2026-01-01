import java.util.Arrays;

public class WildcardMatching {
    public static boolean wildcardMatching(String str1, String str2, int n, int m) {
        if(n==0) return m==0;
        if(m==0 && n>0) {
            for(int i=1; i<=n; i++) {
                if(str1.charAt(i-1)!='*') {
                    return false;
                }
            }
        }
        if(str1.charAt(n-1)==str2.charAt(m-1) || str1.charAt(n-1)=='?') {
            return wildcardMatching(str1, str2, n-1, m-1);
        } else if (str1.charAt(n-1)=='*') {
            return wildcardMatching(str1, str2, n-1, m) || wildcardMatching(str1, str2, n, m-1);
        } else {
            return false;
        }
    }

    public static boolean wildcardMatching(String str1, String str2, int n, int m, int dp[][]) {
        if(n==0) return m==0;
        if(m==0) {
            for(int i=1; i<=n; i++) {
                if(str1.charAt(i-1)!='*') {
                    return false;
                }
            }
        }
        if(dp[n][m]!=-1) return dp[n][m]==1 ? true : false;
        if(str1.charAt(n-1)==str2.charAt(m-1) || str1.charAt(n-1)=='?') {
            boolean match = wildcardMatching(str1, str2, n-1, m-1);
            dp[n][m] = (match ? 1 : 0);
            return match;
        } else if (str1.charAt(n-1)=='*') {
            boolean isMatch = wildcardMatching(str1, str2, n-1, m) || wildcardMatching(str1, str2, n, m-1);
            dp[n][m] = isMatch ? 1 : 0;
            return isMatch;
        } else {
            return false;
        }
    }

    public static boolean wildcardMatching(String str1, String str2) {
        int n=str1.length(), m=str2.length();
        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=1; i<=n; i++) {
            if(str1.charAt(i-1)!='*') break;
            dp[i][0] = true;
        }
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1) || str1.charAt(i-1)=='?') {
                    dp[i][j] = dp[i-1][j-1];
                } else if (str1.charAt(i-1)=='*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1="ab*cd", str2="adsbdefcd";
        System.out.println(wildcardMatching(str1, str2, str1.length(), str2.length()));
        int dp[][] = new int[str1.length()][str2.length()];
        for(int i[]: dp) Arrays.fill(i, -1);
        System.out.println(wildcardMatching(str1, str2, str1.length(), str2.length()));
        System.out.println(wildcardMatching(str1, str2));
    }
}
