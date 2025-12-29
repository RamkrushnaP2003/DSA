import java.util.Arrays;

public class EvaluateBooleanExpToTrue {
    public static long totalWays(String exp, int i, int j, boolean isTrue) {
        if(i>j) return 0;
        if(i==j) {
            if(isTrue) return (exp.charAt(i)=='T' ? 1 : 0);
            else return (exp.charAt(i)=='F' ? 1 : 0);
        }
        long ways = 0;
        for(int k=i+1; k<=j-1; k+=2) {
            long lt = totalWays(exp, i, k-1, true);
            long rt = totalWays(exp, k+1, j, true);
            long lf = totalWays(exp, i, k-1, false);
            long rf = totalWays(exp, k+1, j, false);
            if(exp.charAt(k)=='&') {
                if(isTrue) ways += (lt * rt);
                else ways += ((lt * rf) + (lf * rt) + (lf * rf));
            } else if(exp.charAt(k)=='|') {
                if(isTrue) ways += ((lt * rf) + (lf * rt) + (lf * rf));
                else ways += (lt * rt);
            } else if(exp.charAt(k)=='^') {
                if(isTrue) ways += ((lt * rf) + (lf * rt));
                else ways += ((lt * rt) + (lf * rf));
            }
        }
        return ways;
    }

    public static long totalWays(String exp, int i, int j, boolean isTrue, long dp[][][]) {
        if(i>j) return 0;
        if(i==j) {
            if(isTrue) return (exp.charAt(i)=='T' ? 1 : 0);
            else return (exp.charAt(i)=='F' ? 1 : 0);
        }
        if(dp[i][j][isTrue?1:0]!=-1) return dp[i][j][isTrue?1:0];
        long ways = 0;
        for(int k=i+1; k<=j-1; k+=2) {
            long lt = totalWays(exp, i, k-1, true, dp);
            long rt = totalWays(exp, k+1, j, true, dp);
            long lf = totalWays(exp, i, k-1, false, dp);
            long rf = totalWays(exp, k+1, j, false, dp);
            if(exp.charAt(k)=='&') {
                if(isTrue) ways += (lt * rt);
                else ways += ((lt * rf) + (lf * rt) + (lf * rf));
            } else if(exp.charAt(k)=='|') {
                if(isTrue) ways += ((lt * rf) + (lf * rt) + (lf * rf));
                else ways += (lt * rt);
            } else if(exp.charAt(k)=='^') {
                if(isTrue) ways += ((lt * rf) + (lf * rt));
                else ways += ((lt * rt) + (lf * rf));
            }
        }
        return dp[i][j][isTrue?1:0] = ways;
    }

    public static long totalWays(String exp) {
        int n = exp.length();
        long dp[][][] = new long[n][n][2];
        for(int i=0; i<n; i+=2) {
            for(int j=0; j<=1; j++) {
                if(j==1) {
                    dp[i][i][j] = (exp.charAt(i)=='T' ? 1 : 0);
                } else {
                    dp[i][i][j] = (exp.charAt(i)=='F' ? 1 : 0);
                }
            }
        }
        for(int i=n-1; i>=0; i-=2) {
            for(int j=i+2; j<n; j+=2) {
                for(int isTrue=0; isTrue<=1; isTrue++) {
                    // if(i==j) continue;
                    long ways = 0;
                    for(int k=i+1; k<=j-1; k+=2) {
                        long lt = dp[i][k-1][1];
                        long rt = dp[k+1][j][1];
                        long lf = dp[i][k-1][0];
                        long rf = dp[k+1][j][0];
                        if(exp.charAt(k)=='&') {
                            if(isTrue==1) ways += (lt * rt);
                            else ways += ((lt * rf) + (lf * rt) + (lf * rf));
                        } else if(exp.charAt(k)=='|') {
                            if(isTrue==1) ways += ((lt * rf) + (lf * rt) + (lf * rf));
                            else ways += (lt * rt);
                        } else if(exp.charAt(k)=='^') {
                            if(isTrue==1) ways += ((lt * rf) + (lf * rt));
                            else ways += ((lt * rt) + (lf * rf));
                        }
                    }
                    dp[i][j][isTrue] = ways;
                }
            }
        }
        return dp[0][n-1][1];
    }

    public static void main(String[] args) {
        String exp = "F|T^F";
        System.out.println(totalWays(exp, 0, exp.length()-1, true));
        long[][][] dp = new long[exp.length()][exp.length()][2];
        for(long i[][]: dp) {
            for(long j[]: i) {
                Arrays.fill(j, -1);
            }
        }
        System.out.println(totalWays(exp, 0, exp.length()-1, true, dp));
        System.out.println(totalWays(exp));
    }
}
