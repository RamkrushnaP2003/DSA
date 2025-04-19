public class CapacityToShipPackagesWithinDDays {
    private static int[] getSum(int weights[]) {
        int sum = 0, max=weights[0];
        for(int i=0; i<weights.length; i++) {
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }
        return new int[] { max, sum};
    }
    public static int shipWithinDays(int weights[], int days) {
        int idx[] = getSum(weights);
        int left=idx[0], right=idx[1];
        while (left < right) {
            int mid = (left + right) / 2;
            if(isPossibleToShip(weights, days, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean isPossibleToShip(int weights[], int days, int capacity) {
        int sum = 0, count=1;
        for(int i=0; i<weights.length; i++) {
            if(sum + weights[i] > capacity) {
                count++;
                sum = weights[i];
            } else {
                sum += weights[i];
            }
        }
        return count <= days;
    } 

    public static void main(String[] args) {
        int weights[] = {3,2,2,4,1,4}, days=3;
        System.out.println(shipWithinDays(weights, days));
        System.out.println(isPossibleToShip(weights, days, 6));
    }
}
