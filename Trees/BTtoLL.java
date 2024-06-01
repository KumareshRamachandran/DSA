import java.util.ArrayList;
import java.util.List;

public class BTtoLL {
    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preOrder(list, root); TreeNode temp = root;
        while(!list.isEmpty()){
            temp.left = null;
            temp.right = list.getFirst(); list.removeFirst();
            temp = temp.right;
        }
    }
    public static void preOrder(List<TreeNode> list, TreeNode root){
        if(root==null){
            return;
        }
        list.add(root);
        preOrder(list, root.left);
        preOrder(list, root.right);
    }
}
