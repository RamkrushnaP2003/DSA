public class FindNthRootOfM {
    public static int nthRoot(int n, int m) {
        int left=1, right=m;
        while (left<=right) {
            int mid = (left+right)/2;
            long nMul = getMid(n, m, mid);
            if(nMul == 1) {
                return mid;
            } 
            if(nMul == 2) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static long getMid(int n, int m, int mid) {
        long nMul = 1;
        for(int i=1; i<=n; i++) {
            nMul *= mid;
            if(nMul > m) return 2;
        }
        return (nMul == m) ? 1 : 0;
    }

    public static void main(String[] args) {
        int n=9, m=262144;
        System.out.println(nthRoot(n, m));
    }
}
