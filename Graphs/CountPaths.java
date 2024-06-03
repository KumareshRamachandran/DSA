import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class CountPaths {
    static class Pair{
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int countPaths(int n, int[][] roads) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[n];
        int[] ways = new int[n];
        Arrays.fill(dist, (int)(1e9));
        dist[0] = 0; ways[0]=1;
        pq.add(new Pair(0,0));
        int mod = (int) (1e9+7);
        while(!pq.isEmpty()){
            int dis = pq.peek().first, node = pq.peek().second;
            pq.remove();
            for(Pair it: adj.get(node)){
                int adjNode = it.first, wt = it.second;
                if(dis+wt<dist[adjNode]){
                    dist[adjNode] = dis + wt;
                    pq.add(new Pair(dis+wt, adjNode));
                    ways[adjNode] = ways[node];
                }else if(dis+wt==dist[adjNode]){
                    ways[adjNode] = (ways[adjNode]+ways[node])%mod;
                }
            }
        }
        return ways[n-1]%mod;
    }
}
