import java.util.*;

public class KThPermutation {
    public static String kthpermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int fact = 1;
        for(int i=1; i<n; i++) {
            nums.add(i);
            fact *= i;
        }
        nums.add(n);
        k--; // for 0 based indexing
        String ans = "";
        while (true) {
            ans += (nums.get(k/fact));
            nums.remove(k/fact);
            if(nums.size() == 0) break;
            k = k % fact;
            fact = fact / nums.size();
        }
        return ans;
    }

    public static void main(String[] args) {
        int n=4, k=1;
        System.out.println(kthpermutation(n, k));
    }
}