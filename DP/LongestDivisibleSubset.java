import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestDivisibleSubset {
    public static int LDS(int nums[]) {
        int n=nums.length;
        int[] dp = new int[n], hash = new int[n];
        for(int i=0; i<n; i++) hash[i]=i;
        dp[0] = 1;
        int max=1, maxIdx=-1;
        Arrays.sort(nums);
        for(int i=1; i<n; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i]%nums[j]==0 && dp[i] < dp[j]+1) {
                    dp[i] = dp[j]+1;
                    hash[i] = j;
                }
            }
            if(max < dp[i]) {
                max = dp[i];
                maxIdx = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (maxIdx!=hash[maxIdx]) {
            ans.add(nums[maxIdx]);
            maxIdx = hash[maxIdx];
        }
        ans.add(nums[maxIdx]);
        System.out.println(ans);
        return max;    
    }

    public static void main(String[] args) {
        int nums[] = {1, 16, 4, 7, 8};
        System.out.println(LDS(nums));
    }
}
