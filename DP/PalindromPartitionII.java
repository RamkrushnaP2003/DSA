import java.util.Arrays;

public class PalindromPartitionII {
    public static int minPartition(String str, int i) {
        if(i==str.length()) return 0;
        int min = str.length()-1;
        for(int k=i; k<str.length(); k++) {
            if(isPalindrom(str, i, k)) {
                int count = 1 + minPartition(str, k+1);
                min = Math.min(min, count);
            }
        }
        return min;
    }

    private static boolean isPalindrom(String str, int i, int j) {
        while (i<j) {
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }

    public static int minPartition(String str, int i, int[] dp) {
        if(i==str.length()) return 0;
        if(dp[i]!=-1) return dp[i];
        int min = str.length()-1;
        for(int k=i; k<str.length(); k++) {
            if(isPalindrom(str, i, k)) {
                int count = 1 + minPartition(str, k+1);
                min = Math.min(min, count);
            }
        }
        return dp[i] = min;
    }

    public static int minPartition(String str) {
        int n=str.length();
        int dp[] = new int[n+1];
        dp[n]=0;
        for(int i=n-1; i>=0; i--) {
            int min = str.length()-1;
            for(int k=i; k<str.length(); k++) {
                if(isPalindrom(str, i, k)) {
                    int count = 1 + minPartition(str, k+1);
                    min = Math.min(min, count);
                }
            }
            dp[i] = min;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        String str = "bababcbadcede";
        System.out.println(minPartition(str, 0)-1);
        int dp[] = new int[str.length()];
        Arrays.fill(dp, -1);
        System.out.println(minPartition(str, 0, dp)-1);
        System.out.println(minPartition(str)-1);
    }
}
