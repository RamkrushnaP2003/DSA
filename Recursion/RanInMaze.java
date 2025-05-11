import java.util.*;

public class RanInMaze { // Ans Must Follow Lexicographical Order.
    public static List<String> ratInMaze(int[][] matrix) {
        List<String> ans = new ArrayList<>();
        int dx[] = {+1, 0, 0, -1};
        int dy[] = {0, -1, +1, 0};
        if(matrix[0][0]==1) recursion(matrix, 0, 0, new boolean[matrix.length][matrix[0].length], ans, "");
        if(matrix[0][0]==1) recursion(matrix, new boolean[matrix.length][matrix[0].length], 0, 0, ans, "", dx, dy);
        return ans;
    }

    public static void recursion(int[][] matrix, int row, int col, boolean[][] vis, List<String> ans, String str) {
        if(row==matrix.length-1 && col==matrix[0].length-1) {
            ans.add(str);
            return;
        }
        
        // Down
        if(row+1 < matrix.length && !vis[row+1][col] && matrix[row+1][col]==1) {
            vis[row+1][col] = true;
            recursion(matrix, row+1, col, vis, ans, str+'D');
            vis[row+1][col] = false;
        }

        // Left
        if(col-1 >= 0 && !vis[row][col-1] && matrix[row][col-1]==1) {
            vis[row][col-1] = true;
            recursion(matrix, row, col-1, vis, ans, str+'L');
            vis[row][col-1] = false;
        }

        // Right
        if(col+1 < matrix[0].length && !vis[row][col+1] && matrix[row][col+1]==1) {
            vis[row][col+1] = true;
            recursion(matrix, row, col+1, vis, ans, str+'R');
            vis[row][col+1] = false;
        }

        // Up
        if(row-1 >= 0 && !vis[row-1][col] && matrix[row-1][col]==1) {
            vis[row-1][col] = true;
            recursion(matrix, row-1, col, vis, ans, str+'U');
            vis[row-1][col] = false;
        }
    }

    public static void recursion(int matrix[][], boolean[][] vis, int row, int col, List<String> ans, String str, int[] dx, int dy[]) {
        if(row==matrix.length-1 && col==matrix[0].length-1) {
            ans.add(str);
            return;
        }
        String dir = "DLRU";
        for(int i=0; i<4; i++) {
            int nRow = row + dx[i];
            int nCol = col + dy[i];
            if(nRow >= 0 && nCol >= 0 && nRow < matrix.length && nCol < matrix[0].length && !vis[nRow][nCol] && matrix[nRow][nCol]==1) {
                vis[nRow][nCol] = true;
                recursion(matrix, vis, nRow, nCol, ans, str+dir.charAt(i), dx, dy);
                vis[nRow][nCol] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 0}, {1, 1, 0, 0}, {1, 1, 0, 0}, {0, 1, 1, 1}};
        System.out.println(ratInMaze(matrix));
    }    
}
