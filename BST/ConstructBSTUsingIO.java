import java.util.ArrayList;
import java.util.List;

public class ConstructBSTUsingIO {
    public static void main(String[] args) {
        TreeNode root = bstFromPreorder(new int[]{8,5,1,7,10,12});
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
        System.out.println(ans);
    }
    public static TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, 0, preorder.length-1);
    }
    public static TreeNode helper(int[] preorder, int preStart, int preEnd){
        if(preStart>preEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int i = preStart;
        while(i<preorder.length && preorder[i]<=root.val) i++;
        root.left = helper(preorder, preStart+1, i-1);
        root.right = helper(preorder, i, preEnd);
        return root;
    }
    public static void preorder(TreeNode root, List<Integer> ans){
        if(root==null) return;
        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
}
