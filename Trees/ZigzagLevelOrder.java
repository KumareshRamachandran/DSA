import java.util.*;

public class ZigzagLevelOrder {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(9); t.right = new TreeNode(20);
        t.left.left = new TreeNode(3); t.left.right = new TreeNode(5);
        System.out.println(zigzagLevelOrder(t));
    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean flag = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                row.add(temp.val);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            if(!flag){
                Collections.reverse(row);
            }
            flag = !flag;
            result.add(row);
        }
        return result;
    }
}
