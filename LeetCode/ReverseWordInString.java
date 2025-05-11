public class ReverseWordInString {
    public static String reverseWords(String str) {
        String strs[] = str.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=strs.length-1; i>=0; i--) {
            if(strs[i]!="") {
                sb.append(strs[i]+" ");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "1234 wqlfnq lgkfnsdoi ";
        System.out.println(reverseWords(str));
    }
}
