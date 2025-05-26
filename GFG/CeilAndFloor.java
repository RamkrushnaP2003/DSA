import java.util.Arrays;

public class CeilAndFloor {
    // for unsorted array
    public static void ceilANdFloor(int nums[], int x) {
        int ceil=-1, floor=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]<=x) {
                ceil = Math.max(ceil, nums[i]);
            }
            if(nums[i]>=x) {
                floor = Math.min(floor, nums[i]);
            }
        }
        System.out.println(ceil+" "+ floor);
    }

    // for sorted array
    public static int[] ceilANdFloor2(int nums[], int x) {
        return new int[] {floor(nums, x, 0, nums.length-1), ceil(nums, x, 0, nums.length-1)};
    }

    public static int ceil(int nums[], int x, int left, int right) {
        int ans = Integer.MAX_VALUE;
        while (left<=right) {
            int mid = (left + right) / 2;
            if(nums[mid]<x) {
                ans = Math.min(ans, nums[mid]);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int floor(int nums[], int x, int left, int right) {
        int ans = -1;
        while (left<=right) {
            int mid = (left + right) / 2;
            if(nums[mid]>=x) {
                ans = Math.max(ans, nums[mid]);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {5, 6, 8, 9, 6, 5, 5, 6};
        Arrays.sort(nums);
        ceilANdFloor(nums, 6);
        for(int i: ceilANdFloor2(nums, 7)) {
            System.out.print(i+" ");
        }
    }
}
