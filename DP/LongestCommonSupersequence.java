public class LongestCommonSupersequence {
    public static int longestCommonSupersequence(String str1, String str2) {
        int n=str1.length(), m=str2.length();
        int dp[][] = new int[n+1][m+1];
        int minLen = longestCommonSubsequence(str1, str2, dp, n, m);
        String ans="";
        int i=n, j=m;
        while (i>0 && j>0)   {
            if(str1.charAt(i-1) == str2.charAt(j-1)) {
                ans += str1.charAt(i-1);
                i--;j--;
            } else if(dp[i-1][j] > dp[i][j-1]) {
                ans += str1.charAt(i-1);
                i--;
            } else {
                ans += str2.charAt(j-1);
                j--;
            }
        }
        while (i>0) {
            ans+=str1.charAt(i-1);
            i--;
        }
        while (j>0) {
            ans+=str2.charAt(j-1);
            j--;
        }
        System.out.println(rev(ans));
        return minLen;
    }

    private static String rev(String str) {
        String ans = "";
        for(int i=str.length()-1; i>=0; i--) {
            ans+=str.charAt(i);
        }
        return ans;
    }

    private static int longestCommonSubsequence(String str1, String str2, int dp[][], int n, int m) {
        for(int i=0; i<=n; i++) dp[i][0] = 0;
        for(int j=0; j<=m; j++) dp[0][j] = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1="brute", str2="groot";
        System.out.println(longestCommonSupersequence(str1, str2));
    }
}
