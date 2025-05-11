public class Sudoku {
    public static void sudokuSolver(char[][] matrix) {
        // solve(matrix);
        sudoku(matrix, 0, 0);
    }

    public static boolean sudoku(char[][] matrix, int row, int col) {
        if(row == matrix.length) return true;
        int newRow = row, newCol=col;
        if(col==matrix.length) {
            newRow = row+1;
            newCol = 0;
        }
        if(matrix[newRow][newCol] == '.') {
            return sudoku(matrix, newRow, newCol+1);
        }
        for(char ch='1'; ch<='9'; ch++) {
            if(isPossible(matrix, ch, newRow, newCol)) {
                matrix[newRow][newCol] = ch;
                if(sudoku(matrix, newRow, newCol+1)) {
                    return true;
                }
                matrix[newRow][newCol] = '.';
            }
        }
        return false;
    }

    public static boolean solve(char[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == '.') {
                    for(char ch='1'; ch<='9'; ch++) {
                        if(isPossible(matrix, ch, i, j)) {
                            matrix[i][j] = ch;
                            if(solve(matrix)) {
                                return true;
                            } else {
                                matrix[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isPossible(char[][] matrix, char ch, int row, int col) {
        for(int i=0; i<matrix.length; i++) {
            if(matrix[row][i]==ch || matrix[i][col]==ch) return false;
        }
        int startRow=(row/3)*3;
        int startCol=(col/3)*3;
        for(int i=startRow; i<startRow+3; i++) {
            for(int j=startCol; j<startCol+3; j++) {
                if(matrix[i][j]==ch) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char matrix[][] = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},
        {'.','.','.','.','8','.','.','7','9'}};
        solve(matrix);
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}