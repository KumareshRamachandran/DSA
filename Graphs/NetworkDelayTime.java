import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}},4,2));
    }
    static class Pair{
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public static int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] time: times){
            adj.get(time[0]).add(new Pair(time[1],time[2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(x->x.first));
        int[] time = new int[n+1];
        Arrays.fill(time, (int)(1e9));
        time[k] = 0;
        pq.add(new Pair(0, k));
        while(!pq.isEmpty()){
            int t = pq.peek().first, node = pq.peek().second;
            pq.remove();
            for(Pair i: adj.get(node)){
                int adjNode = i.first, wt = i.second;
                if(t+wt<time[adjNode]){
                    time[adjNode] = t + wt;
                    pq.add(new Pair(t+wt, adjNode));
                }
            }
        }
        int ans = -1;
        for(int i=1; i<time.length; i++){
            ans = Math.max(ans, time[i]);
        }
        return ans == (int)(1e9) ? -1 : ans;
    }
}
