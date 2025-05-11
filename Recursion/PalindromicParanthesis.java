import java.util.*;
public class PalindromicParanthesis {
    public static List<List<String>> partition(String str) {
        List<List<String>> ans = new ArrayList<>();
        recursion(str, 0, ans, new ArrayList<>());
        return ans;
    }

    public static void recursion(String str, int idx, List<List<String>> ans, List<String> pp) {
        if(idx == str.length()) ans.add(new ArrayList<>(pp));
        for(int i=idx; i<str.length(); i++) {
            if(isPossible(str,idx, i)) {
                pp.add(str.substring(idx, i+1));
                recursion(str, i+1, ans, pp);
                pp.remove(pp.size()-1);
            }
        }
    }

    private static boolean isPossible(String str, int left, int right) {
        while(left <= right) {
            if(str.charAt(left)!=str.charAt(right)) {
                return false;
            }
            left++;right--;
        }
        return true;
    }

    public static void main(String args[]) {
        String str = "aab";
        System.out.println(partition(str));
    }
}
