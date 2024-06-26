import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2); t.right = new TreeNode(3);
        t.left.right = new TreeNode(5);
        System.out.println(binaryTreePaths(t));
    }
    public static List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<String> finalAns = new ArrayList<>();
        getPath(root, new ArrayList<>(), ans);
        for(List<Integer> i: ans){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<i.size(); j++){
                sb.append(i.get(j));
                if(j<i.size()-1){
                    sb.append("->");
                }
            }
            finalAns.add(sb.toString());
        }
        return finalAns;
    }
    public static void getPath(TreeNode root, List<Integer> arr, List<List<Integer>> ans){
        if (root == null) {
            return;
        }
        arr.add(root.val);
        if (root.left == null && root.right == null) {
            ans.add(new ArrayList<>(arr));
        }
        getPath(root.left, arr, ans);
        getPath(root.right, arr, ans);
        arr.removeLast();
    }

}
