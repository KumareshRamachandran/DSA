import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int num; TreeNode node;
    public Pair(TreeNode node, int num) {
        this.num = num;
        this.node = node;
    }
}
public class MaxWidthOfBT {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0)); int ans = 1;
        while(!q.isEmpty()){
            int size = q.size(), min = q.peek().num, first = 0, last = 0;
            for(int i=0; i<size; i++){
                int currId = q.peek().num-min;
                TreeNode currNode = q.peek().node;
                q.poll();
                if(i==0) first = currId;
                if(i==size-1) last = currId;
                if(currNode.left!=null){
                    q.offer(new Pair(currNode.left, currId*2+1));
                }
                if(currNode.right!=null){
                    q.offer(new Pair(currNode.right, currId*2+2));
                }
            }
            ans = Math.max((last-first+1), ans);
        }
        return ans;
    }
}
