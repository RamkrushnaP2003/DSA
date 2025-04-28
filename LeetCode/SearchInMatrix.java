public class SearchInMatrix {
    public static boolean searchInMatrix(int matrix[][], int target) {
        int n=matrix.length, m=matrix[0].length;
        int left = 0, right = (n*m)-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(matrix[mid/m][mid%m]==target) {
                return true;
            }
            if(matrix[mid/m][mid%m] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}}, target=13;
        System.out.println(searchInMatrix(matrix, target));
    }
}
