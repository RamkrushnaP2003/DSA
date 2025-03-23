import java.util.*;

public class ReversePair {
    public static int countReversePairs(int nums[]) {
        int count = 0, n=nums.length;

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if(nums[i] > nums[j]*2) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countReversePair(int nums[]) {
        int count = 0, n=nums.length;
        int map[][] = new int[n][2];
        for(int i=0; i<n; i++) {
            map[i][0] = nums[i];
            map[i][1] = i;
        }
        Arrays.sort(map, Comparator.comparingDouble(o->o[0]));
        for(int i=0; i<n; i++) {
            if(map[i][1] > map[i][1]);
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {2,4,3,5,1};
        System.out.println(countReversePair(nums));
    }
}
