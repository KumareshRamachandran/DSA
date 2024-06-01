import java.util.*;

public class ShortestPath {
    public static void main(String[] args) {
        System.out.println(shortestPath(5, 6,
                new int[][]{{1,2,2}, {2,5,5}, {2,3,4}, {1,4,1},{4,3,3},{3,5,1}}));
    }
    static class Pair{
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static List<Integer> shortestPath(int n, int m, int[][] edges){
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.first));
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            dist[i] = (int) 1e9;
            parent[i]= i;
        }
        dist[1] = 0;
        pq.add(new Pair(0, 1));
        while(!pq.isEmpty()){
            Pair it = pq.peek();
            pq.remove();
            int node = it.second, dis = it.first;
            for(Pair iter: adj.get(node)){
                int adjNode = iter.first;
                int wt = iter.second;
                if(dis+wt<dist[adjNode]){
                    dist[adjNode] = dis + wt;
                    pq.add(new Pair(dis + wt, adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(dist[n] == 1e9){
            path.add(-1);
            return path;
        }
        int node = n;
        while(parent[node]!=node){
            path.add(node); node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        path.addFirst(dist[n]);
        return path;
    }
}
