import java.util.*;

public class SubArrSumWithK {
    public static int subArraySum(int nums[], int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0, sum=0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum-k)) {
                count += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1}, k=2;
        System.out.println(subArraySum(nums, k));
    }
}
