import java.util.Arrays;

public class MazeObstacle {
    public static int mazeObstacle(int maze[][], int n, int m) {
        if(n==0 && m==0) return 1;
        if(n<0 || m<0 || maze[n][m]==-1) return 0;
        return mazeObstacle(maze, n-1, m) + mazeObstacle(maze, n, m-1);
    }

    public static int mazeObstacle(int maze[][], int n, int m, int dp[][]) {
        if(n==0 && m==0) return 1;
        if(n<0 || m<0 || maze[n][m]==-1) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        return dp[n][m] = mazeObstacle(maze, n-1, m) + mazeObstacle(maze, n, m-1);
    }

    public static int mazeObstacle(int n, int m, int maze[][]) {
        int dp[][] = new int[n+1][m+1];
        for(int i[]: dp) {
            Arrays.fill(i, -1);
        }
        dp[0][0] = 1;
        for(int i=0; i<=n; i++) {
            for(int j=0; j<=m; j++) {
                if(maze[i][j]==-1) dp[i][j] = 0;
                else if(i==0&&j==0) {
                    dp[i][j]=1;
                } else {
                    int top=0, left=0;
                    if(i>0)top = dp[i-1][j];
                    if(j>0)left = dp[i][j-1];
                    dp[i][j] = top + left;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        int maze[][] = {{0, 0, 0},
                        {0, -1, 0},
                        {0, 0, 0}};
        int n=maze.length, m=maze[0].length;
        System.out.println(mazeObstacle(n-1, m-1, maze));
        int dp[][] = new int[n][m];
        for(int i[]: dp) {
            Arrays.fill(i, -1);
        }
        System.out.println(mazeObstacle(maze, n-1, m-1, dp));
        System.out.println(mazeObstacle(maze, n-1, m-1));
    }
}
