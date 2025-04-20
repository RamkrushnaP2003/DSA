public class SmallDivsorGivenThreshold {
    private static int getMax(int nums[]) {
        int max=nums[0];
        for(int i: nums) {
            max = Math.max(i, max);
        }
        return max;
    }

    public static int smallestDivisor(int nums[], int threashold) {
        int left=1, right=getMax(nums), ans=-1;
        while (left<=right) {
            int mid = (left + right) / 2;
            int divisor = getDivisors(nums, mid);
            if(divisor <= threashold) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private static int getDivisors(int nums[], int divisor) {
        int count=0;
        for(int i: nums) {
            count += Math.ceil(i/ (double)divisor);
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,5,9}, threashold=6;
        System.out.println(smallestDivisor(nums, threashold));
    }
}
