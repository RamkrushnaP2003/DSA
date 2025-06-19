import java.util.Arrays;
import java.util.Scanner;

public class Fibo {
    public static int fibo1(int n) {
        if(n<=1) {
            return n;
        }
        return fibo1(n-1) + fibo1(n-2);
    }

    public static int fibo2(int n, int dp[]) {
        if(n==0 || n==1) return n;
        if(dp[n]!=-1) return dp[n];
        dp[n] = fibo1(n-1) + fibo1(n-2);
        return dp[n];
    }

    public static int fibo3(int n, int dp[]) {
        if(n==0 || n==1) return n;
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int fibo4(int n) {
        int prev = 0, curr = 1;
        for(int i=2; i<=n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;;
        }
        return curr;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp1[] = new int[n+1];
        Arrays.fill(dp1, -1);
        int dp2[] = new int[n+1];
        Arrays.fill(dp2, -1);
        System.out.println(fibo1(n));
        System.out.println(fibo2(n, dp1));
        System.out.println(fibo3(n, dp2));
        System.out.println(fibo4(n));
        sc.close();
    }
}