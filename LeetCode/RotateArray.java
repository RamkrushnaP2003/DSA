// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

public class RotateArray {
    // Brute force
    public static void rotate(int nums[], int k) {
        int n = nums.length;
        int ans[] = new int[n];
        k=k%n;
        int idx = 0;
        while(idx < n) {
            ans[k] = nums[idx++];
            k = (k+1)%n;
        }
        for(int i=0; i<n; i++) {
            nums[i] = ans[i];
            System.out.print(ans[i]+" ");
        }
    }

    // optimal
    public static void rotateOpt(int nums[], int k) {
        int n=nums.length;
        k%=n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
        for(int i: nums) {
            System.out.print(i+" ");
        }
    }
    
    public static void reverse(int nums[], int left, int right){
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; right--;
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7}, k = 3;
        rotateOpt(nums, k);

    }
}