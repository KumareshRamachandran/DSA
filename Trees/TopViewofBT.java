import java.util.*;

public class TopViewofBT {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2); t.right = new TreeNode(3);
        System.out.println(topView(t));
    }
    static List<Integer> topView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return ans;
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            int curr = q.peek().val;
            for(int i=0; i<size; i++) {
                if (q.peek().left!=null) q.offer(q.peek().left);
                if (q.peek().right != null) q.offer(q.peek().right);
                curr = q.poll().val;
            }
            ans.add(curr);
        }
        return ans;
    }
}
