import java.util.PriorityQueue;

public class SortCharByFreq {
    static class Pair implements Comparable<Pair> {
        char ch;
        int count;
        
        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        public int compareTo(Pair p2) {
            if(p2.count == this.count) {
                return this.ch - p2.ch;
            } else {
                return p2.count - this.count;
            }
        }
    }

    public static String frequencySort(String str) {
        int[] map = new int[256];
        for(int i=0; i<str.length(); i++) {
            map[str.charAt(i)]++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int i=0; i<256; i++) {
            if(map[i]!=0) {
                pq.offer(new Pair((char)i, map[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            for(int i=0; i<p.count; i++) {
                sb.append(p.ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "tree";
        System.out.println(frequencySort(str));
    }
}
