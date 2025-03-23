public class MaxScoreFromSubArrMins {
    public static int pairsWithMaxSum(int nums[]) {
        int n=nums.length, maxSum=0;
        
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int firstMin = nums[i], secondMin=nums[i+1];
                for(int k=i; k<=j; k++) {
                    firstMin = Math.min(firstMin, nums[k]);
                }
                for(int k=i; k<=j; k++) {
                    if(nums[k] != firstMin) {
                        secondMin = Math.min(secondMin, nums[k]);
                    }
                }
                maxSum = Math.max(maxSum, firstMin+secondMin);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int nums[] = {4, 3, 1, 5, 6};
        System.out.println(pairsWithMaxSum(nums));
    }
}