import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMaximizedCapital {
    static class Pair{
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> minCapital = new PriorityQueue<>(Comparator.comparingInt(x -> x.first));
        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Comparator.comparingInt(x -> x));
        for (int i = 0; i < profits.length; i++) {
            minCapital.add(new Pair(capital[i], profits[i]));
        }
        for (int i = 0; i < k; i++) {
            while(!minCapital.isEmpty() && minCapital.peek().first<=w){
                Pair p = minCapital.poll();
                maxProfit.add(-1 * p.second);
            }
            if(maxProfit.isEmpty()) break;
            w += -1 * maxProfit.poll();
        }
        return w;
    }
}
