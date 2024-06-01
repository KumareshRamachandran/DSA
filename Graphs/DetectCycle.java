import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycle {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if(!vis[i]){
                if(checkForCycle(i, V, adj, vis)) return true;
            }
        }
        return false;
    }
    public static boolean checkForCycle(int sr, int V, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
        vis[sr] = true;
        Queue<PairTwo> q = new LinkedList<>();
        q.add(new PairTwo(sr, -1));
        while(!q.isEmpty()){
            PairTwo pair = q.poll();
            for(int adjNode: adj.get(pair.row)){
                if(!vis[adjNode]){
                    vis[adjNode] = true;
                    q.add(new PairTwo(adjNode, pair.row));
                }else if(pair.col!=adjNode) return true;
            }
        }
        return false;
    }
}
