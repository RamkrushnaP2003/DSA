import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonSubsequence {
    public static void lcs(String str, int idx, String s, List<String> ans) {
        if(idx==str.length()) {
            ans.add(s);
            return;
        }
        lcs(str, idx+1, s+str.charAt(idx), ans);
        lcs(str, idx+1, s, ans);        
    }

    public static void longestCommonSubsequence(String str1, String str2) {
        List<String> ans1 = new ArrayList<>();
        List<String> ans2 = new ArrayList<>();
        lcs(str1, 0, "", ans1);
        lcs(str2, 0, "", ans2);
        System.out.println(ans1);
        System.out.println(ans2);
        int max = Integer.MIN_VALUE;
        String ans="";
        for(String i: ans1) {
            for(String j: ans2) {
                if(i.equalsIgnoreCase(j)) {
                    if(i.length() > max) {
                        max = i.length();
                        ans = i;
                    }
                }
            }
        }
        System.out.println(ans+" : "+max);
    }

    public static int longestCommonSubsequence(String str1, String str2, int idx1, int idx2) {
        if(idx1==-1 || idx2==-1) return 0;
        if(str1.charAt(idx1) == str2.charAt(idx2)) {
            return 1 + longestCommonSubsequence(str1, str2, idx1-1, idx2-1);
        } else {
            return Math.max(longestCommonSubsequence(str1, str2, idx1-1, idx2), longestCommonSubsequence(str1, str2, idx1, idx2-1));
        }
    }

    public static int longestCommonSubsequence(String str1, String str2, int idx1, int idx2, int[][] dp) {
        if(idx1==0 || idx2==0) return 0;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(str1.charAt(idx1-1) == str2.charAt(idx2-1)) {
            return dp[idx1][idx2] = 1 + longestCommonSubsequence(str1, str2, idx1-1, idx2-1, dp);
        } else {
            return dp[idx1][idx2] = Math.max(longestCommonSubsequence(str1, str2, idx1-1, idx2, dp), longestCommonSubsequence(str1, str2, idx1, idx2-1, dp));
        }
    }

    public static int longestCommonSubsequenceT(String str1, String str2) {
        int n=str1.length(), m=str2.length();
        int dp[][] = new int[n+1][m+1];
        StringBuilder ans = new StringBuilder();
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
        int i=n, j=m;
        while (i>0 && j>0) {
            if(str1.charAt(i-1)==str2.charAt(j-1)) {
                ans.append(str1.charAt(i-1));
                i--;j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println(ans.reverse());
        return dp[n][m];
    }

    public static void main(String[] args) {
        String str1="abcakjdsjkasddc", str2="dcajnsdnsadbd";
        longestCommonSubsequence(str1, str2);
        System.out.println(longestCommonSubsequence(str1, str2, str1.length()-1, str2.length()-1));
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        for(int i[]: dp) Arrays.fill(i, -1);
        System.out.println(longestCommonSubsequence(str1, str2, str1.length(), str2.length(), dp));
        System.out.println(longestCommonSubsequenceT(str1, str2));
    }
}
