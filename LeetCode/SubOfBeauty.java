public class SubOfBeauty {
    public static int beautySum(String str) {
        int ans=0;
        for(int i=0; i<str.length(); i++) {
            int[] map = new int[26];
            for(int j=i; j<str.length(); j++) {
                char ch = str.charAt(j);
                map[ch-'a']++;
                int max=0, min=500;
                for(int c: map) {
                    max = Math.max(max, c);
                    if(c!=0)min = Math.min(min, c);
                }
                ans += (max - min);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "aabcbaa";
        System.out.println(beautySum(str));
    }
}