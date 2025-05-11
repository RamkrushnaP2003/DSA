public class NQueen {
    static int count=0;
    public static int nQueens(int n) {
        char mat[][] = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                mat[i][j] = 'X';
            }
        }
        recusrion(n, mat, 0);
        return count;
    }

    public static void recusrion(int n, char mat[][], int col) {
        if(col==n) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    System.out.print(mat[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            count++;
            return;
        }

        for(int row=0; row<n; row++) {
            if(isSafe(mat, n, row, col)) {
                mat[row][col] = 'Q';
                recusrion(n, mat, col+1);
                mat[row][col] = 'X';
            }
        }
    } 

    public static boolean isSafe(char mat[][], int n, int row, int col) {
        for(int i=0; i<=col; i++) {
            if(mat[row][i] == 'Q') {
                return false;
            }
        }
        for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
            if(mat[i][j] == 'Q') {
                return false;
            }
        }
        for(int i=row, j=col; i<n && j>=0; i++, j--) {
            if(mat[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(nQueens(n));
    }
}
