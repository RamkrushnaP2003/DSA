import java.util.*;

public class FindKRotation {
    public static int findKRotation(List<Integer> arr) {
        return findMin(arr);
    }

    public static int findMin(List<Integer> arr) {
        int left=0, right=arr.size()-1, min=Integer.MAX_VALUE, ans=-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if(arr.get(left) <= arr.get(mid)) {
                if(min > arr.get(left)) {
                    min = arr.get(left);
                    ans = left;
                }
                left = mid + 1;
            } else {
                if(min > arr.get(mid)) {
                    min = arr.get(mid);
                    ans = mid;
                }
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(5);
        arr.add(10);
        arr.add(2);
        arr.add(3);
        System.out.println(findKRotation(arr));
    }
}
