import java.util.*;

public class Permutation {
    // time complexity -> O(n!*n)
    public static void permutation(int nums[]) {
        List<List<Integer>> ans = new ArrayList<>();
        recursion(nums, new boolean[nums.length], ans, new ArrayList<>());
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

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        permutation(nums);
    }
}