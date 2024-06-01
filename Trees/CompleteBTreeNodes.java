import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CompleteBTreeNodes {
    public static int counTreeNodes(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<TreeNode> ans = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            ans.add(curr);
            if(curr.left!=null) q.offer(curr.left);
            if(curr.right!=null) q.offer(curr.right);
        }
        return ans.size();
    }
}
