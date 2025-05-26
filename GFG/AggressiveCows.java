import java.util.Arrays;

public class AggressiveCows {
    public static int aggressiveCows(int stalls[], int k) {
        Arrays.sort(stalls);
        int n=stalls.length;
        int left = 1, right = stalls[n-1]-stalls[0];
        while (left<=right) {
            int mid = (left + right) / 2;
            if(canPlaceCows(stalls, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private static boolean canPlaceCows(int stalls[], int k, int dist) {
        int cows = 1, idx=1, leftIdx=0;
        while (idx < stalls.length) {
            if(stalls[idx] - stalls[leftIdx] >= dist) {
                cows++;
                if(cows == k) return true;
                leftIdx = idx;
            }
            idx++;
        }
        return false;
    }

    public static void main(String[] args) {
        int stalls[] = {10, 1, 2, 7, 5}, k=3;
        System.out.println(aggressiveCows(stalls, k));
    }
}
