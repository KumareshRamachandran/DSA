import java.util.*;

public class CheapestFlight {
    static class Pair{
        int first, second, third;
        public Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    static class Pair2{
        int first, second;
        public Pair2(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair2>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] flight: flights){
            adj.get(flight[0]).add(new Pair2(flight[1], flight[2]));
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, src, 0));
        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));
        dist[src] = 0;
        while (!q.isEmpty()){
            Pair pair = q.poll();
            int stops = pair.first, node = pair.second, cost = pair.third;
            if(stops>k) continue;
            for(Pair2 i: adj.get(node)){
                int adjNode = i.first, wt = i.second;
                if(cost+wt<dist[adjNode] && stops<=k){
                    dist[adjNode] = cost+wt;
                    q.add(new Pair(stops+1, adjNode, cost+wt));
                }
            }
        }
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
}
