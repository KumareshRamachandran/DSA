import java.util.HashMap;
import java.util.Map;

public class RemoveStones {
    public static int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0, maxCol = 0;
        for (int[] stone : stones) {
            maxRow = Math.max(maxRow, stone[0]);
            maxCol = Math.max(maxCol, stone[1]);
        }
        Disjoint ds = new Disjoint(maxRow+maxCol+1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1]+maxRow+1;
            ds.union(nodeRow, nodeCol);
            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }
        int cnt = 0;
        for(Map.Entry<Integer, Integer> it: stoneNodes.entrySet()){
            if(ds.findUPar(it.getKey())==it.getKey()) cnt++;
        }
        return n - cnt;
    }
}
