public class LowerBound {
    public static int lowerBound(int nums[], int x) {
        if(x <= 0) return -1;
        int n=nums.length-1;
        if(nums[n] >= x) return n;
        int left=0, right=n, ans = -1;
        while (left <= right) {
            int mid = (left + right)/2;
            if(nums[mid] <= x) {
                ans = Math.max(ans, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 8, 10, 10, 12, 19};
        System.out.println(lowerBound(nums, 20));
    }
}
