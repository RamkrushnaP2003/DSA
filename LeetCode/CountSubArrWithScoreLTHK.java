public class CountSubArrWithScoreLTHK {
    public static long countSubArrWithScoreLessThanK(int nums[], int k) {
        long left=0, right=0, n=nums.length, sum=0, count=0;
        while (right < n) {
            sum += nums[(int)right];
            while (sum * right-left+1 >= k) {
                sum -= nums[(int)left];
                left++;
            }
            count += right-left+1;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {2,1,4,3,5}, k=10;
        System.out.println(countSubArrWithScoreLessThanK(nums, k));
    }
}
