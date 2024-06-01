import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EventualSafeNodes {
    private boolean dfsCheck(int node, int[][] graph, int[] vis,
                             int[] pathVis, int[] check){
        vis[node] = 1;
        pathVis[node] = 1; check[node] = 0;
        for(int i: graph[node]){
            if(vis[i] == 0){
                if(dfsCheck(i, graph, vis, pathVis, check)){
                    return true;
                }
            }else if(pathVis[i]==1) return true;
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis = new int[graph.length];
        int[] pathVis = new int[graph.length];
        int[] check = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(vis[i]==0) dfsCheck(i, graph, vis, pathVis, check);
        }
        List<Integer> safeNode = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if(check[i]==1) safeNode.add(i);
        }
        return safeNode;
    }
}
