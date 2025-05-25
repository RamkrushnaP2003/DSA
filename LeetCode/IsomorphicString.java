import java.util.HashMap;

public class IsomorphicString {
    public static boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>(); 
        for(int i=0; i<s.length(); i++) {
            char chs = s.charAt(i), cht = t.charAt(i);
            if(!map.containsKey(chs)) {
                if(!map.containsValue(cht)) {
                    map.put(chs, cht);
                } else {
                    return false;
                }
            } else {
                if(map.get(chs) != cht) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s="badc", t="baba"; 
        System.out.println(isIsomorphic(s, t));
    }
}
