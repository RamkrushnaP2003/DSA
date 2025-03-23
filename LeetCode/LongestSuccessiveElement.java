import java.util.Arrays;
import java.util.HashSet;

public class LongestSuccessiveElement {
    public static int longestSuccessiveEle(int nums[]) {
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0; i<n; i++) {
            System.out.print(nums[i]+" ");
        }
        int count=1, maxLenOfSuccesiveEle=1;
        for(int i=0; i<n-1; i++) {
            if(nums[i]+1 == nums[i+1]) {
                count++;
            } else if(nums[i] == nums[i+1]) {
                continue;
            } else {
                maxLenOfSuccesiveEle = Math.max(maxLenOfSuccesiveEle, count);
                count=1;
            }
        }
        return maxLenOfSuccesiveEle;
    }

    public static int longestSuccessiveEle2(int nums[]) {
        HashSet<Integer> set = new HashSet<>();
        int maxLen = 1;
        for(int i: nums) {
            set.add(i);
        }
        for(int key: set) {
            if(!set.contains(key-1)) {
                int count = 1;
                int tempKey = key;
                while(set.contains(tempKey+1)) {
                    count++;
                    tempKey = tempKey+1;
                }
                maxLen = Math.max(maxLen, count);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int nums[] = {5, 8, 3, 2, 1, 4};
        System.out.println(longestSuccessiveEle2(nums));
    }
}
