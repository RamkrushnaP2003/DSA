public class ClimbingStairs {
    // same as fibo but diff edge case
    public static int climbingStairs(int n) {
        if(n==0 || n==1) return 1;
        return climbingStairs(n-1) + climbingStairs(n-2);
    }

    public static void main(String[] args) {
        int n=3;
        System.out.println(climbingStairs(n));
    }
}