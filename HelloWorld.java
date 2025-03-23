public class HelloWorld {
    public static String reverseVowels(String s) {
        if(s.length() <= 1) return s;
        StringBuilder ans = new StringBuilder();
        int left=0, v=s.length()-1;
        while(left<s.length()) {
            if(isVowel(s.charAt(left))) {
                while(!isVowel(s.charAt(v)) && v>=0) {
                    v--;
                }
                ans.append(s.charAt(v));
                v--;
                left++;
            } else {
                ans.append(s.charAt(left));
                left++;
            }
        }
        return ans.toString();
    }

    private static boolean isVowel(char ch) {
        return (ch=='a' || ch=='A' || ch=='e' || ch=='E' || ch=='i' || ch=='I' || ch=='o' || ch=='O' || ch=='u' || ch=='U');
    }

    public static void main(String[] args) {
        String s = "IceCreAm";
        System.out.println(reverseVowels(s));
    }
}