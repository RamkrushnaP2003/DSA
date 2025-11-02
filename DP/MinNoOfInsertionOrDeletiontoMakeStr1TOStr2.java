import java.util.HashMap;

public class MinNoOfInsertionOrDeletiontoMakeStr1TOStr2 {
    public static int minNoOfupdationOrDeletiontoMakeStr1TOStr2(String str1, String str2) {
        int n=str1.length(), m=str2.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(str1.charAt(i), map.getOrDefault(str1.charAt(i), 0)+1);
        }
        for(int i=0; i<m; i++) {
            char ch = str2.charAt(i);
            if(map.containsKey(ch)) {
                if(map.get(ch) <= 1) {
                    map.remove(ch);
                } else {
                    map.put(ch, map.getOrDefault(ch, 0)-1);
                }
            } else {
                map.put(ch, map.getOrDefault(ch, 0)+1);
            }
        }
        int count=0;
        for(Integer key: map.values()) {
            count+=key;
        }
        return count;
    }

    public static int longestCommonSubsequence(String str1, String str2) {
        int n=str1.length(), m=str2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<n; i++) dp[i][0] = 0;
        for(int j=0; j<m; j++) dp[0][j] = 0;
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

    public static int minNoOfInsertionOrDeletiontoMakeStr1TOStr2(String str1, String str2) {
        return str1.length() + str2.length() - ( 2 * longestCommonSubsequence(str1, str2));
    }

    public static void main(String[] args) {
        String str1="heap", str2="pea";
        System.out.println(minNoOfupdationOrDeletiontoMakeStr1TOStr2(str1, str2));
        System.out.println(minNoOfInsertionOrDeletiontoMakeStr1TOStr2(str1, str2));
    }
}
