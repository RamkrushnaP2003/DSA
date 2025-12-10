public class LongestBitonicSubsequence {
    public static int LBS(int nums[]) {
        int n=nums.length;
        int dp1[] = new int[n], dp2[] = new int[n];
        dp1[0] = dp2[n-1] = 1;
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j] && dp1[j]+1 > dp1[i]) {
                    dp1[i] = dp1[j]+1;
                }
            }
            int idx = n-i-1;
            for(int j=n-1; j>idx; j--) {
                if(nums[idx] > nums[j] && dp2[j]+1 > dp2[idx]) {
                    dp2[idx] = dp2[j]+1;
                }
            }
        }
        for(int i=0; i<n; i++) {
            System.out.print(dp1[i]+"  ");
        }
        System.out.println();
        for(int i=0; i<n; i++) {
            System.out.print(dp2[i]+"  ");
        }
        System.out.println();
        int max = 0;
        for(int i=0; i<n; i++) {
            max = Math.max(dp1[i] + dp2[i] - 1, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(LBS(nums));
    }
}
