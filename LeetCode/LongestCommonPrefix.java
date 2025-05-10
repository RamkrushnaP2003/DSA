import java.util.Arrays;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1 = strs[0];
        int n = Math.min(str1.length(), strs[strs.length-1].length());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            if(str1.charAt(i) != strs[strs.length-1].charAt(i)) {
                return sb.toString();
            } else {
                sb.append(str1.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] str = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(str));
    }
}
