public class SymmetricTree {
    public static boolean isSymmetric(TreeNode root) {
        return root==null || helper(root.left, root.right);
    }
    public static boolean helper(TreeNode lNode, TreeNode rNode){
        if(rNode==null || lNode==null) return lNode==rNode;
        if(lNode.val!=rNode.val) return false;
        return helper(lNode.right, rNode.left) &&
                helper(lNode.left, rNode.right);
    }
}
