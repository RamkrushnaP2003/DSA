import java.util.*;

public class Permutation {
    // time complexity -> O(n!*n)
    public static void permutation(int nums[]) {
        List<List<Integer>> ans = new ArrayList<>();
        // recursion(nums, new boolean[nums.length], ans, new ArrayList<>());
        recursion2(nums, 0, new ArrayList<>(), ans);
        System.out.println(ans);
    }

    public static void recursion(int nums[], boolean[] vis, List<List<Integer>> ans, List<Integer> per) {
        if(per.size()==nums.length) {
            ans.add(new ArrayList<>(per));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(!vis[i]) {
                vis[i] = true;
                per.add(nums[i]);
                recursion(nums, vis, ans, per);
                per.remove(per.size()-1);
                vis[i] = false;
            }
        }
    }

    public static void recursion2(int nums[], int idx, List<Integer> per, List<List<Integer>> ans) {
        if(idx == nums.length) {
            ans.add(new ArrayList<>(per));
            return;
        }
        for(int i=idx; i<nums.length; i++) {
            swap(nums, idx, i);
            per.add(nums[idx]);
            recursion2(nums, idx+1, per, ans);
            per.remove(per.size()-1);
            swap(nums, i, idx);
        }
    }

    private static void swap(int nums[], int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        permutation(nums);
    }
}