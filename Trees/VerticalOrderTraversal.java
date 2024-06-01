import java.util.*;

class Tuple{
    TreeNode node; int row, col;
    public Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
public class VerticalOrderTraversal {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> verticalTraversal(TreeNode root){
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node; int x = tuple.row, y = tuple.col;
            if(!map.containsKey(x)) map.put(x, new TreeMap<>());
            if(!map.get(x).containsKey(y)) map.get(x).put(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);
            if(node.left!=null) q.offer(new Tuple(node.left, x-1, y+1));
            if(node.right!=null) q.offer(new Tuple(node.right, x+1, y+1));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys: map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes: ys.values()){
                while(!nodes.isEmpty()){
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
        return ans;
    }
}
