import java.util.HashMap;

public class BuildTreePoIo {
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            mpp.put(inorder[i], i);
        }
        return helper(postorder, 0,postorder.length-1, inorder, 0, inorder.length-1, mpp);
    }
    public static TreeNode helper(int[] postorder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd,
                                  HashMap<Integer, Integer> mpp){
        if(postStart>postEnd || inStart>inEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inIdx = mpp.get(root.val); int numsLeft = inIdx-inStart;
        root.left = helper(postorder, postStart, postStart+numsLeft-1, inorder, inStart, inIdx-1, mpp);
        root.right = helper(postorder, postStart+numsLeft, postEnd-1, inorder, inIdx+1, inEnd, mpp);
        return root;
    }
}
