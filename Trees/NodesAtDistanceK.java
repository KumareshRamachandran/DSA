import java.util.*;

public class NodesAtDistanceK {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(3);
        t.left = new TreeNode(5); t.right = new TreeNode(1);
        t.left.left = new TreeNode(6); t.left.right = new TreeNode(2);
        t.right.left = new TreeNode(0); t.right.right = new TreeNode(8);
        t.left.right.left = new TreeNode(7); t.left.right.right = new TreeNode(4);
        System.out.println(distanceK(t, t.left, 2));
    }
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        HashMap<TreeNode, TreeNode> mpp = new HashMap<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        makeParents(mpp, root);
        Queue<TreeNode> q = new LinkedList<>();
        visited.put(target, true);
        q.offer(target); int count = 0;
        while(!q.isEmpty()){
            if(count==k) break;
            count++;
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if(mpp.get(curr)!=null && visited.get(mpp.get(curr))==null){
                    q.offer(mpp.get(curr));
                    visited.put(mpp.get(curr), true);
                }
            }
        }
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
    public static void makeParents(HashMap<TreeNode, TreeNode> track, TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left!=null){
                track.put(curr.left, curr);
                q.offer(curr.left);
            }
            if(curr.right!=null){
                track.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
}
