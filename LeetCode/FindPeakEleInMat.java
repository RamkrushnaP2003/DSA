public class FindPeakEleInMat {
    public static int[] findPeakEleInMat(int mat[][]) {
        int n=mat.length, m=mat[0].length;
        int start=0, end=m-1;
        while (start <= end) {
            int mid = (start + end) / 2;
            int maxRowIdx = -1, max=0;
            for(int i=0; i<n; i++) {
                if(mat[i][mid] > max) {
                    max = mat[i][mid];
                    maxRowIdx = i;
                }
            }
            int left = mid - 1 >= 0 ? mat[maxRowIdx][mid-1] : -1;
            int right = mid + 1 < m ? mat[maxRowIdx][mid+1] : -1;
            if(left < mat[maxRowIdx][mid] && mat[maxRowIdx][mid] > right) {
                return new int[] {maxRowIdx, mid};
            }
            if(mat[maxRowIdx][mid] < left) {
                start = mid -1;
            } else {
                end = mid + 1;
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int mat[][] = {{70,50,40,30,20}, {100,1,2,3,4}};
        for(int i: findPeakEleInMat(mat)) {
            System.out.print(i+" ");
        }
    }
}
