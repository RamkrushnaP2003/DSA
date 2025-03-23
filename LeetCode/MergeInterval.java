import java.util.*;

public class MergeInterval {
    public static void merge(int intervals[][]) {
        if(intervals.length <= 1) return;
        Arrays.sort(intervals, Comparator.comparingDouble(o->o[0]));
        List<int[]> ans = new ArrayList<>();
        for(int i=0; i<intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if(!ans.isEmpty() && start <= ans.get(ans.size()-1)[1]) {
                ans.get(ans.size()-1)[1] = Math.max(end, ans.get(ans.size()-1)[1]);
            } else {
                ans.add(new int[] {start, end});
            }
        }
        ans.toArray();
        for(int[] i: ans) {
            System.out.println(i[0]+" "+ i[1]);
        }
    }

    public static void main(String[] args) {
        int intervals[][] = {{8,10},{1,18}};
        merge(intervals);
    }
}
