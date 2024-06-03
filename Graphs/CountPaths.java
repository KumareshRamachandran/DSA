import java.util.*;

public class CountPaths {
    static class Pair{
        long first, second;
        public Pair(long first, long second) {
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
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(x->x.first));
        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0; ways[0]=1;
        pq.add(new Pair(0,0));
        int mod = (int) (1e9+7);
        while(!pq.isEmpty()){
            long dis = pq.peek().first, node = pq.peek().second;
            pq.remove();
            for(Pair it: adj.get((int) node)){
                long adjNode = it.first, wt = it.second;
                if(dis+wt<dist[(int)adjNode]){
                    dist[(int)adjNode] = dis + wt;
                    pq.add(new Pair(dis+wt, adjNode));
                    ways[(int)adjNode] = ways[(int)node];
                }else if(dis+wt==dist[(int)adjNode]){
                    ways[(int)adjNode] = (ways[(int)adjNode]+ways[(int)node])%mod;
                }
            }
        }
        return (int) ways[n-1]%mod;
    }
}
