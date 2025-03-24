public class MaxProductSubArr {
    public static int maxProductSubArr(int nums[]) {
        int max = 0;
        int left = 0, right=nums.length-1;
        int leftp=1, rightp=1;
        while (left < nums.length && right >= 0) {
            if(leftp==0) leftp=1;
            if(rightp==0) rightp=1;
            leftp *= nums[left] ;
            rightp *= nums[right];
            max = Math.max(max, Math.max(leftp, rightp));
            left++;right--;
        }
        return max;
    }

    public static void main(String[] args) {
        int nums[] = {3, 2, -1, 4, -6, 3, -2, 6};
        System.out.println(maxProductSubArr(nums));
    }
}
