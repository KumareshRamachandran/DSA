import java.util.ArrayList;

public class BoundaryTraversal{

    boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }
    void addLeft(Node root, ArrayList<Integer> res){
        Node curr = root.left;
        while(curr!=null){
            if(!isLeaf(curr)) res.add(curr.data);
            if(curr.left!=null) curr = curr.left;
            else curr = curr.right;
        }
    }
    void addRight(Node root, ArrayList<Integer> res){
        Node curr = root.right;
        ArrayList<Integer> temp = new ArrayList<>();
        while (curr!=null){
            if(!isLeaf(curr)) temp.add(curr.data);
            if(curr.right!=null) curr = curr.right;
            else curr = curr.left;
        }
        for(int i = temp.size()-1; i>=0; i--){
            res.add(temp.get(i));
        }
    }
    void addLeaves(Node root, ArrayList<Integer> res){
        if(isLeaf(root)){
            res.add(root.data);
            return;
        }
        if(root.left!=null) addLeaves(root.left, res);
        if(root.right!=null) addLeaves(root.right, res);
    }
    ArrayList<Integer> boundary(Node node){
        ArrayList<Integer> ans = new ArrayList<>();
        if(!isLeaf(node)) ans.add(node.data);
        addLeft(node, ans);
        addLeaves(node, ans);
        addRight(node, ans);
        return ans;
    }
}
