public class MinNoOfDayToMakeMBouquet {
    public static int minDays(int bloomDay[], int m, int k) {
        int n=bloomDay.length;
        if(m*k > n) return -1;
        int left=1, right=bloomDay[0], ans=-1;
        for(int i: bloomDay) {
            left = Math.min(left, i);
            right = Math.max(right, i);
        }
        while (left<=right) {
            int mid = left + (right - left)/2;
            int bouquet = getBouquets(bloomDay, mid, k);
            if(bouquet >= m) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public static int getBouquets(int bloomDay[], int b, int k) {
        int count=0, j=0;
        for(int i=0; i<bloomDay.length; i++) {
            if(b>=bloomDay[i]) {
                j++;
                if(j==k) {
                    count++;
                    j=0;
                }
            } else {
                j=0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int bloomDay[] = {1000000000,1000000000}, m=1, k=1;
        System.out.println(minDays(bloomDay, m, k));
    }
}
