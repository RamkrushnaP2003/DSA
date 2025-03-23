import java.util.*;;

public class AccountsMerge {
    static class DisjointSet {
        int[] rank, parent;
    
        public DisjointSet(int n) {
            this.rank = new int[n+1];
            this.parent = new int[n+1];
            for(int i=0; i<=n; i++) {
                this.rank[i] = 0;
                this.parent[i] = i;
            }
        }

        public int findParent(int node) {
            if(node == parent[node]) {
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }

        public void unionByRank(int u, int v) {
            int ult_u = findParent(u);
            int ult_v = findParent(v);
            if(ult_u==ult_v) return;
            if(rank[ult_u] < rank[ult_v]) {
                parent[ult_u] = ult_v;
            } else if(rank[ult_u] > rank[ult_v]) {
                parent[ult_v] = ult_u;
            } else {
                parent[ult_v] = ult_u;
                rank[ult_u]++;
            }
        }
    }

    public static void accountMerge(ArrayList<ArrayList<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            for(int j=1; j<accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if(map.containsKey(mail)) {
                    ds.unionByRank(i, map.get(mail));
                } else {
                    map.put(mail, i);
                }
            }
        }

        @SuppressWarnings("unchecked")
        ArrayList<String>[] ans = new ArrayList[n];
        for(int i=0; i<n; i++) {
            ans[i] =  new ArrayList<>();
        }

        for(String s: map.keySet()) {
            int idx = ds.findParent(map.get(s));
            ans[idx].add(s);
        }

        ArrayList<ArrayList<String>> mergedAcc = new ArrayList<>();
        for(int i=0; i<n; i++) {
            if(ans[i].size()==0) continue;
            Collections.sort(ans[i]);
            String s = accounts.get(i).get(0);
            ArrayList<String> temp = new ArrayList<>();
            temp.add(s);
            for(String str: ans[i]) {
                temp.add(str);
            }
            mergedAcc.add(temp);
        }

        for(int i=0; i<mergedAcc.size(); i++) {
            System.out.println(mergedAcc.get(i));
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> accounts = new ArrayList<>();
        for(int i=0; i<=5; i++) {
            accounts.add(new ArrayList<>());
        }
        accounts.get(0).add("John");
        accounts.get(0).add("J1@com");
        accounts.get(0).add("J2@com");
        accounts.get(0).add("J3@com");

        accounts.get(1).add("John");
        accounts.get(1).add("J4@com");

        accounts.get(2).add("Raj");
        accounts.get(2).add("R1@com");
        accounts.get(2).add("R2@com");

        accounts.get(3).add("John");
        accounts.get(3).add("J1@com");
        accounts.get(3).add("J5@com");

        accounts.get(4).add("Raj");
        accounts.get(4).add("R2@com");
        accounts.get(4).add("R3@com");

        accounts.get(5).add("Mary");
        accounts.get(5).add("M1@com");
        for(int i=0; i<accounts.size(); i++) {
            System.out.println(accounts.get(i));
        }
        System.out.println("------------------------------------------");
        accountMerge(accounts);
    }
}