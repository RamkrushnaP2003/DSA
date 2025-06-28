import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MaxSubSequence {
    public static void maxSubSequence(int nums[], int k) {
        int n=nums.length;
        int mapArr[][] = new int[n][2];
        for(int i=0; i<n; i++) {
            mapArr[i][0] = i;
            mapArr[i][1] = nums[i];
        }
        Arrays.sort(mapArr, Comparator.comparingDouble(o -> o[1]));
        @SuppressWarnings({ "rawtypes", "unchecked" })
        TreeMap<Integer, Integer> map = new TreeMap();
        for(int i=(n-k); i<n; i++) {
           map.put(mapArr[i][0], mapArr[i][1]);
        }
        int[] ans = map.values().stream().mapToInt(Integer::intValue).toArray();
        for(int i=0; i<k; i++) {

            System.out.print(ans[i]+" ");
        }
        System.out.println();
    }

    public static void maxSubSequence2(int[] nums, int k) {
        int mapValueToIdx[][] = new int[nums.length][2];
        for(int i=0; i<nums.length; i++) {
            mapValueToIdx[i] = new int[] {i, nums[i]};
        }
        Arrays.sort(mapValueToIdx, (a, b) -> b[1] - a[1]);
        Arrays.sort(mapValueToIdx, 0, k, (a, b) -> a[0] - b[0]);
        for(int i=0; i<k; i++) {
            System.out.print(mapValueToIdx[i][1]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int nums[] = {-1, 4, -2, 3};
        maxSubSequence2(nums, 3);
    }
}