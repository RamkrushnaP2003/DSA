import java.util.*;

public class RomanToInt {
    // Not Optimal but Okay...
    public static int romanToInt(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        String symbols = "IVXLCDM";
        int arr[] = {1, 5, 10, 50, 100, 500, 1000};
        for(int i=0; i<arr.length; i++) {
            map.put(symbols.charAt(i), arr[i]);
        }

        int count = map.get(str.charAt(str.length()-1));
        for(int i=str.length()-2; i>=0; i--) {
            char ch = str.charAt(i);
            int value = map.get(ch);
            if(value >= map.get(str.charAt(i+1))) {
                count += value;
            } else {
                count -= value;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "MCMXCIV";
        System.out.println(romanToInt(str));
    }
}
