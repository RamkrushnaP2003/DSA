public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        while(n-1 >= 0) {
            if(m-1>=0 && nums2[n-1] < nums1[m-1]) {
                nums1[n+m-1] = nums1[m-1];
                m--;
            } else {
                nums1[n+m-1] = nums2[n-1];
                n--;
            }
        }
    }

    public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0}, nums2[] = {2,5,6}, m=0, n=1;
        merge(nums1, m, nums2, n);
        for(int i=0; i<m+n; i++) {
            System.out.print(nums1[i]+" ");
        }
        System.out.println();
    }
}
