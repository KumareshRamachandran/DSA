import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {
    public static void dfs(int node, boolean[] vis,
                           ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ls){
        vis[node] = true;
        ls.add(node);
        for(Integer i: adj.get(node)){
            if(!vis[i]) dfs(i, vis, adj, ls);
        }
    }
    public static int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for(int i=0; i<isConnected.length; i++){
            adjLs.add(new ArrayList<>());
        }
        for(int i=0; i<isConnected.length; i++){
            for(int j=0; j<isConnected[0].length; j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }
        boolean[] vis = new boolean[isConnected.length];
        int cnt = 0;
        for(int i=0; i<isConnected.length; i++){
            if(!vis[i]){
                cnt++;
                dfs(i, vis, adjLs, new ArrayList<>());
            }
        }
        return cnt;
    }
}
