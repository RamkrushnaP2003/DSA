import java.util.Arrays;

public class NinjaTraining { 
    // Problem Statement: A Ninja has an ‘N’ Day training schedule. He has to perform one of these three activities (Running, Fighting Practice, or Learning New Moves) each day. There are merit points associated with performing an activity each day. The same activity can’t be performed on two consecutive days. We need to find the maximum merit points the ninja can attain in N Days.

    // We are given a 2D Array POINTS of size ‘N*3’ which tells us the merit point of specific activity on that particular day. Our task is to calculate the maximum number of merit points that the ninja can earn.   
    
    public static int maxPointsBF(int[][] points, int last, int idx) {
        if(idx==0) {
            int max = 0;
            for(int i=0; i<=2; i++) {
                if(last != i) {
                    max = Math.max(max, points[idx][i]);
                }
            }
            return max;
        }
        int max=0;
        for(int i=0; i<=2; i++) {
            if(i!=last) {
                int point = points[idx][i] + maxPointsBF(points, i, idx-1);
                max = Math.max(max, point);
            }
        }
        return max;
    }

    public static int maxPointsM(int points[][], int last, int idx, int dp[][]) {
        if(idx == 0) {
            int max = 0;
            for(int i=0; i<=2; i++) {
                if(last != i) {
                    max = Math.max(max, points[idx][i]);
                }
            }
            return max;
        }
        int max = 0;
        if(dp[idx][last]!=0) return dp[idx][last];
        for(int i=0; i<=2; i++) {
            if (i!=last) {
                int point = points[idx][i] + maxPointsM(points, i, idx-1, dp);
                max = Math.max(max, point);
            }
        }
        return dp[idx][last] = max;
    }

    public static int maxPointsT(int points[][]) {
        int n=points.length;
        int dp[][] = new int[n][4];
        for(int i[]: dp) {
            Arrays.fill(i, -1);
        }
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]); 
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int days=1; days<n; days++) {
            for(int last=0; last<4; last++) {
                for(int task=0; task<3; task++) {
                    if(task!=last) { 
                        int point = dp[days-1][task] + points[days][task];
                        dp[days][last] = Math.max(point, dp[days][last]);
                    }
                }
            }
        }

        return dp[n-1][3];
    }

    public static void main(String[] args) {
        int[][] points = {
            {10, 40, 70},
            {20, 50, 80},
            {30, 60, 90}
        };
        int n = points.length;
        int[][] dp = new int[n][4];
        System.out.println("BF :: Maximum points: " + maxPointsBF(points, 3, n-1));
        System.out.println("M :: Maximum points: " + maxPointsM(points, 3, n-1, dp));
        System.out.println("T :: Maximum points: " + maxPointsT(points));
    }    
}
