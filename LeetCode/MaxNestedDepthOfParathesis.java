public class MaxNestedDepthOfParathesis {
    public static int maxDepth(String str) {
        int max = 0, count = 0;
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch=='(') {
                count++;
                max = Math.max(count, max);
            } else if(ch==')') {
                count--;
            }
        }
        return max;
    }

    public static void main(String args[]) {
        String str = "()(())((()()))";
        System.out.println(maxDepth(str));
    }
}
