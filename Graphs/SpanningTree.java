import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SpanningTree {
    static class Pair{
        int node, distance;
        public Pair(int distance, int node) {
            this.node = node;
            this.distance = distance;
        }
    }
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x->x.distance));
        int[] vis = new int[V];
        pq.add(new Pair(0,0));
        int sum = 0;
        while(!pq.isEmpty()){
            int wt = pq.peek().distance, node = pq.peek().node;
            pq.remove();
            if(vis[node]==1) continue;
            vis[node] = 1; sum += wt;
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if(vis[adjNode]==0){
                    pq.add(new Pair(edW, adjNode));
                }
            }
        }
        return sum;
    }
}
