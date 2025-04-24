public class SplitArray {
    public static int splitArray(int nums[], int k) {
        int left=0, right=0, ans=-1;
        for(int i=0; i<nums.length; i++) {
            left = Math.max(left, nums[i]);
            right += nums[i];
        }
        while (left <= right) {
            int mid = (left + right)/2;
            if(isPossible(nums, k, mid)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean isPossible(int nums[], int k, int mid) {
        int count=1, sum=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]+sum<=mid) {
                sum+=nums[i];
            } else {
                sum = nums[i];
                count++;
                if(count>k) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int nums[] = {7,2,5,10,8}, k=2;
        System.out.println(splitArray(nums, k));
    }
}