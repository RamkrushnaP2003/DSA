import java.util.HashMap;
public class SubArrayWithGiverXOR {
    public static int subArrayWithGiverXOR(int nums[], int target) {
        int count = 0;
        for(int i=0; i<nums.length; i++) {
            int sum = nums[i];
            if(sum == target) count++;
            for(int j=i+1; j<nums.length; j++) {
                sum ^= nums[j];
                if(sum == target) count++;
            }
        }
        return count;
    }

    public static int subArrayWithGiverXOR(int target, int nums[]) {
        int count = 0, sum=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0; i<nums.length; i++) {
            sum ^= nums[i];
            if(map.containsKey(sum^target)) {
                count += map.get(sum^target);
            }  map.put(sum, map.getOrDefault(sum, 0)+1);

        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {4, 2, 2, 6, 4};
        int target = 6;
        System.out.println(subArrayWithGiverXOR(nums, target));
        System.out.println(subArrayWithGiverXOR(target, nums));
    }
}