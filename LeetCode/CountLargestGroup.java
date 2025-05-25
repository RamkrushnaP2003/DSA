import java.util.HashMap;

public class CountLargestGroup {
    public static int countLargestGroup(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0, count=0;
        for(int i=1; i<=n; i++) {
            int sum=0, num=i;
            while (num!=0) {
                sum += (num%10);
                num /= 10;
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
            max = Math.max(max, map.get(sum));
        }
        for(int i: map.keySet()) {
            if(max == map.get(i)) count++;
        }
        return count;
    }

    public static int digiSum(int n) {
        int sum=0;
        while (n!=0) {
            sum += (n%10);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n=13;
        System.out.println(countLargestGroup(n));
        // System.out.println(digiSum(n));

    }
}
