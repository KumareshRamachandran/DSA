public class SameTree {
    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(1);
        t3.left = new TreeNode(2); t3.right = new TreeNode(1);
        TreeNode k3 = new TreeNode(1);
        k3.left = new TreeNode(1); k3.right = new TreeNode(2);
        System.out.println(isSameTree(t3, k3));
    }
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null){
            return p==q;
        }
        boolean lN = isSameTree(p.left, q.left);
        boolean rN = isSameTree(p.right, q.right);
        return p.val == q.val && lN && rN;
    }
}
