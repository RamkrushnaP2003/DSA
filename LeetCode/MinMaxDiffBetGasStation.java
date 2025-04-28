import java.util.PriorityQueue;

public class MinMaxDiffBetGasStation {
    public static class Pair {
        double val;
        int idx;
        public Pair(double val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    // time complexity -> O(n*k) TLE
    public static double minimizeDistance(int nums[], int k) {
        int n=nums.length;
        int howMany[] = new int[n-1];
        for(int gasStation=1; gasStation<=k; gasStation++) {
            double maxVal=-1, maxIdx=-1;
            for(int i=0; i<n-1; i++) {
                double diff = nums[i+1] - nums[i];
                double section = diff / (howMany[i]+1);
                if(maxVal < section) {
                    maxVal = section;
                    maxIdx = i;
                }
            }
            howMany[(int)maxIdx]++;
        }
        double maxAns = -1;
        for(int i=0; i<n-1; i++) {
            int sectionlength = (nums[i+1]-nums[i])/(howMany[i]+1);
            maxAns = Math.max(sectionlength, maxAns);
        }
        return maxAns;
    }

    // time complexity -> O(n log n) + O(k log n)
    // space complexity -> O(n-1)
    public static double minimizeGasStationDistance(int nums[], int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.val, a.val));
        int n=nums.length;
        int howMany[] = new int[n-1];
        for(int i=0; i<n-1; i++) {
            pq.add(new Pair(nums[i+1] - nums[i], i));
        }
        for(int i=1; i<=k; i++) {
            Pair p = pq.poll();
            howMany[p.idx]++;
            pq.offer(new Pair((nums[p.idx+1] - nums[p.idx]) / (double)(howMany[p.idx]+1), p.idx));
        }
        return pq.peek().val;
    }

    public static double minimizeStationDistance(int nums[], int k) {
        int n=nums.length;
        double left=0, right=0;
        for(int i=0; i<n-1; i++) {
            right = Math.max(right, (double)(nums[i+1] - nums[i]));
        }
        double diff = Math.pow(10, -6);
        while (right-left > diff) {
            double mid = (left + right) / 2.0;
            int count = numberOfGasStation(nums, mid);
            if(count > k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private static int numberOfGasStation(int nums[], double dist) {
        int count = 0;
        for(int i=1; i<nums.length; i++) {
            int numInBetween = (int)((nums[i] - nums[i-1]) / dist);
            if((nums[i] - nums[i-1]) / dist == numInBetween*dist) {
                numInBetween--;
            }
            count += numInBetween;
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, k=9;
        System.out.println(minimizeStationDistance(nums, k));
    }
}