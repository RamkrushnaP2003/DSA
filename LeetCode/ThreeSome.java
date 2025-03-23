import java.util.*;

public class ThreeSome {
    public static List<List<Integer>> threeSum(int nums[]) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;        
        for(int i=0; i<n-2; i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1, right=n-1;
            while (left < right) {
                int sum = nums[i]+nums[left]+nums[right];
                if(sum==0) {
                    List<Integer> triplets = Arrays.asList(nums[i], nums[left], nums[right]);
                    if (!set.contains(triplets)) {
                        ans.add(triplets);
                        set.add(triplets);
                    }
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while (left < right && nums[right]==nums[right+1]) {
                        right--;
                    }
                } else if(sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10};
        System.out.println(threeSum(nums));
    }
}
