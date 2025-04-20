import java.util.*;

public class CombinationSum2 {
    public static void uniqueCombinations(int nums[], int target) {
        List<List<Integer>> ans = new ArrayList<>();
        recursion(nums, 0, target, new ArrayList<>(), ans);        
        System.out.println(ans);
    }

    public static void recursion(int nums[], int index, int target, List<Integer> combination, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(combination));
            return;
        }
        for(int i=index; i<nums.length; i++) {
            if(i>index && nums[i] == nums[i-1]) continue;
            if(nums[i] > target) break;
            combination.add(nums[i]);
            recursion(nums, i+1, target-nums[i], combination, ans); // if index+1 instead i+1 then it will print all the combinations with unique index
            combination.remove(combination.size()-1);
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 2, 2}, target=4;
        uniqueCombinations(nums, target);
    }
}
