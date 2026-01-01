import java.util.Arrays;

public class LongestStringChain {
    public static int longestStrChain(String strs[]) {
        Arrays.sort(strs, (a , b) -> a.length() - b.length());
        int n=strs.length, max=0;
        int dp[] = new int[n];
        dp[0] = 1;
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(compairStr(strs[j], strs[i]) && dp[j]+1 > dp[i]) {
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    private static boolean compairStr(String str1, String str2) {
        if(str1.length()+1 != str2.length()) return false;
        int i=0, j=0;
        while (i < str1.length()) {
            if(str1.charAt(i)==str2.charAt(j)) {
                i++;j++;
            } else {
                j++;
            }
        }
        return str1.length()==i && str2.length()==j;
    }

    public static void main(String[] args) {
        String strs[] = {"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(strs));
    }
}
