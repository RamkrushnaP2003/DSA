import java.util.ArrayList;
import java.util.List;

public class PascleTriangle {

    // time complexity -> O(N * N) * O(3N) = O(N * N * N)
    public static void pascleTriangleBr(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        ans.add(row1);
        for(int i=2; i<=n; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j=1; j<=i; j++) {
                row.add(combination(i, j));
            }
            ans.add(row);
        }
        System.out.println(ans);
    }

    public static int combination(int row, int col) {
        row = row-1;
        col = col-1;
        int n = getFact(row);
        int r = getFact(col);
        int nMinR = getFact(row-col);
        return n/(r*nMinR);
    }

    public static int getFact(int n) {
        int fact = 1;
        for(int i=1; i<=n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void pascleTriangle(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=n; i++) {
            ans.add(printNthRowInPascleTriange(i, new ArrayList<>()));
        }
        System.out.println(ans);
    }

    public static List<Integer> printNthRowInPascleTriange(int n, List<Integer> ans) {
        int mul = 1;
        ans.add(mul);
        for(int i=1; i<n; i++) {
            mul = mul * (n-i);
            mul = mul / (i);
            ans.add(mul);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n=30;
        // pascleTriangleBr(n);
        System.out.println(printNthRowInPascleTriange(n, new ArrayList<>()));
        // pascleTriangle(n);
    }
}
