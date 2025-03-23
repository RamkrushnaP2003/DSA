import java.util.HashSet;

public class FindMissingAndDup {
    public static int[] findMissingAndDup(int nums[]) {
        HashSet<Integer> set = new HashSet<>();
        int dupNo=0, missingNo=0, sum=0;
        for(int i=0; i<nums.length; i++) {
            if(set.contains(nums[i])) {
                dupNo=nums[i];
                continue;
            }
            sum+=nums[i];
            set.add(nums[i]);
        }
        int n=nums.length-1;
        missingNo = sum - ((n*(n-1))/2);
        return new int[]{dupNo, missingNo-1};
    }

    public static void main(String[] args) {
        int nums[] = {4, 3, 6, 2, 1, 1};
        for(int i: findMissingAndDup(nums)) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
