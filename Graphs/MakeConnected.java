public class MakeConnected {
    public static int makeConnected(int n, int[][] connections) {
        Disjoint ds = new Disjoint(n);
        int cntExtras = 0;
        for (int[] connection : connections) {
            int u = connection[0], v = connection[1];
            if (ds.findUPar(u) == ds.findUPar(v)) {
                cntExtras++;
            } else {
                ds.union(u, v);
            }
        }
        int cntC = 0;
        for (int i = 0; i < n; i++) {
            if(ds.parent[i]==i) cntC++;
        }
        int ans = cntC - 1;
        if(cntExtras>=ans) return ans;
        return -1;
    }
}
