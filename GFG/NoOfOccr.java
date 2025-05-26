public class NoOfOccr {
    public static int countFreq(int[] arr, int target) {
        int n=arr.length-1;
        if(arr[0] == target) {
            return getRightIdx(arr, target, 0, n)+1;
        }
        if(arr[n]==target) {
            return n-getLeftIdx(arr, target, 0, n)+1;
        }
        int left = getLeftIdx(arr, target, 0, n);
        if(left == -1) return 0;
        return (getRightIdx(arr, target, 0, n) - left) + 1;
    }
    
    private static int getLeftIdx(int arr[], int target, int left, int right) {
        int ans = -1;
        while(left <= right) {
            int mid = (left+right)/2;
            if(arr[mid]==target) {
                ans = mid;
                right = mid - 1;
            } else if(arr[mid]<target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    
    private static int getRightIdx(int arr[], int target, int left, int right) {
        int ans = -1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid]==target) {
                ans = mid;
                left = mid + 1;
            } else if(arr[mid]<target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 2, 2, 2, 2, 3};
        System.out.println(countFreq(arr, 2));
    }
}
