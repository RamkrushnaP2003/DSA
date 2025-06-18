public class CountGoodNumber {
    public static int countGoodNumber(int n) {
        return (int)(Math.pow(4, (n/2)) * Math.pow(5, n-n/2)) % 1000000007;
    }

    public static void main(String[] args) {
        int n=50;
        System.out.println(countGoodNumber(n));
    }
}
