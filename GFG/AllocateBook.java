public class AllocateBook {
    public static int allocateBook(int nums[], int student) {
        int maxAndSum[] = getMaxAndSum(nums);
        int left=maxAndSum[0], right=maxAndSum[1], ans=-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(isPossible(nums, student, mid)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int nums[], int student, int pages) {
        int count=1, sum=0;
        for(int i=0; i<nums.length; i++) {
            if(sum+nums[i] <= pages) {
                sum += nums[i];
            } else {
                sum = nums[i];
                count++;
                if(count > student) return false;
            }
        }
        return true;
    }

    private static int[] getMaxAndSum(int nums[]) {
        int max=nums[0], sum=0;
        for(int i: nums) {
            sum += i;
            max = Math.max(max, i);
        }
        return new int[] {max, sum};
    }

    public static void main(String[] args) {
        int nums[] = {15, 17, 20}, student=5;
        System.out.println(allocateBook(nums, student));
    }
}