// Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

import java.util.HashMap;

public class LongestSubArrWithSumK {

    // It only works when k is +ve
    public static int longestSubArrWithSumK(int arr[], int k) {
        int i = 0, j = 0, n=arr.length, sum=0, max=0;
        while (i < n) {
            sum += arr[i++];
            if(sum == k) {
                max = Math.max(max, i-j+1);
            }
            while (sum > k && j < n) {
                sum -= arr[j];
                j++;
            }
        }
        return max;
    }

    // optimal and also works for -ve k
    public static int longestSubArrWithSumK2(int nums[], int k) {
        int n=nums.length, sum=0, maxLen=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            sum += nums[i];
            if(sum == k) {
                maxLen = Math.max(maxLen, i+1);
            }
            if(map.containsKey(sum-k)) {
                maxLen = Math.max(maxLen, map.get(sum-k));
            }
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int arr[] = {-5, 8, -14, 2, 4, 12}, k=-5;
        System.out.println(longestSubArrWithSumK(arr, k));
        System.out.println(longestSubArrWithSumK2(arr, k));
    }
}
