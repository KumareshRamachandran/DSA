import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraAlgo {
    static class Pair{
        int distance, node;
        public Pair(int first, int second) {
            this.distance = first;
            this.node = second;
        }
    }
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));
        int[] dist = new int[V];
        Arrays.fill(dist, (int) (1e9));
        dist[S] = 0;
        pq.add(new Pair(0, S));
        while(!pq.isEmpty()){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int wt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if(dis + wt < dist[adjNode]){
                    dist[adjNode] = dis + wt;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}
