public class KokoEatingBanana {
    // time complexity -> O(n * max(arr))
    public static int minEatBanana(int nums[], int h) {
        int max=Integer.MIN_VALUE, n=nums.length;
        for(int i=0; i<n; max=Math.max(max, nums[i]), i++);
        for(int i=1; i<=max; i++) {
            long reqTime = getReqTime(nums, i);
            if(reqTime <= (long)h) return i;
        }
        return -1;
    }

    public static int minEatBananas(int nums[], int h) {
        int right=Integer.MIN_VALUE, min = Integer.MAX_VALUE, n=nums.length, left=1;
        for(int i=0; i<n; right=Math.max(right, nums[i]), i++);
        while (left <= right) {
            int mid = (left + right) / 2;
            long reqTime = getReqTime(nums, mid);
            if(reqTime <= (long)h) {
                min = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }

    public static long getReqTime(int nums[], int idx) {
        long totalReqTime = 0;
        for(int i=0; i<nums.length; i++) {
            totalReqTime += (long)Math.ceilDivExact(nums[i], idx);
        }
        return totalReqTime;
    }

    public static void main(String[] args) {
        int nums[] = {805306368,805306368,805306368}, h=1000000000;
        System.out.println(minEatBanana(nums, h));
        System.out.println(minEatBananas(nums, h));
    }
}
