import java.util.Arrays;

public class LongestCommonSubstring {
    public static int maxi=0;
    public static int longestCommonSubstring(String str1, String str2, int idx1, int idx2) {
        if(idx1<1 || idx2<1) return 0;
        if(str1.charAt(idx1-1)==str2.charAt(idx2-1)) {
            int subStrLen = 1 + longestCommonSubstring(str1, str2, idx1-1, idx2-1);
            maxi = Math.max(maxi, subStrLen);
            return subStrLen;
        } else {
            longestCommonSubstring(str1, str2, idx1-1, idx2);
            longestCommonSubstring(str1, str2, idx1, idx2-1);
            return 0;
        }
    }

    public static int longestCommonSubstring(String str1, String str2, int idx1, int idx2, int dp[][]) {
        if(idx1<1 || idx2<1) return 0;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(str1.charAt(idx1-1)==str2.charAt(idx2-1)) {
            int subStrLen = 1 + longestCommonSubstring(str1, str2, idx1-1, idx2-1, dp);
            maxi = Math.max(maxi, subStrLen);
            return dp[idx1][idx2] = subStrLen;
        } else {
            dp[idx1][idx2] = longestCommonSubstring(str1, str2, idx1-1, idx2, dp);
            dp[idx1][idx2] = longestCommonSubstring(str1, str2, idx1, idx2-1, dp);
            return 0;
        }
    }

    public static int longestCommonSubsequence(String str1, String str2) {
        int n=str1.length(), m=str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<=n; i++) dp[i][0] = 0;
        for(int i=0; i<=m; i++) dp[0][i] = 0;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(str1.charAt(i-1)==str2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String str1="abcdc", str2="dcabcdc";
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for(int i[]: dp) Arrays.fill(i, -1);
        longestCommonSubstring(str1, str2, str1.length(), str2.length(), dp);
        System.out.println(maxi);
        System.out.println(longestCommonSubsequence(str1, str2));
    }
}
