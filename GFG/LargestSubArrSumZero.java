import java.util.HashMap;

public class LargestSubArrSumZero {
    public static int maxlensubArrSumZero(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen=0;
        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            if(sum == 0) {
                maxLen = i+1;
            } else {
                if(map.get(sum)!=null) {
                    maxLen = Math.max(maxLen, i-map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int nums[] = {-42, 12, 20, 15, 31, -4, 0, 0, 15};
        System.out.println(maxlensubArrSumZero(nums));
    }
}
