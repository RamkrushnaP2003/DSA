public class KThMissingPositiveNum {
    public static int findKthPositive(int nums[], int k) {
        int n=nums.length;
        int left=0, right=n-1;
        while (left<=right) {
            int mid = (left + right) / 2;
            if((nums[mid] - (mid+1)) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        /* return nums[right] + (k-(nums[right] - (right+1))); 
        this line equal to 
        let x = nums[right]
        therefor :- x + (k - (x - (right + 1)))
                    x + k - x + (right + 1)    -> x - x is cancel
                    k + right + 1

                    or return low + k
        */
        return k + right + 1;
    }

    public static void main(String[] args) {
        int nums[] = {2}, k=1;
        System.out.println(findKthPositive(nums, k));
    }
}
