import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class InfectedTree {
    public static void main(String[] args) {
        Node t = new Node(1);
        t.left = new Node(2); t.left.left = new Node(3); t.left.left.left = new Node(4);
        t.left.left.left.left = new Node(5);
        System.out.println(amountOfTime(t, 2));
    }
    public static int amountOfTime(Node root, int start) {
        HashMap<Node, Node> mpp = new HashMap<>();
        Node starNode = makeParents(root, mpp, start);
        return findMax(mpp, starNode);
    }
    public static Node makeParents(Node root, HashMap<Node, Node> mpp, int target){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Node ans = new Node(-1);
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.data==target) ans = curr;
            if(curr.left!=null){
                q.offer(curr.left);
                mpp.put(curr.left, curr);
            }
            if(curr.right!=null){
                q.offer(curr.right);
                mpp.put(curr.right, curr);
            }
        }
        return ans;
    }
    public static int findMax(HashMap<Node, Node> mpp, Node target){
        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Integer> visited = new HashMap<>();
        visited.put(target, 1);
        q.offer(target); int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int flag = 0;
            for(int i=0; i<size; i++){
                Node currNode = q.poll();
                if(currNode.left!=null && visited.get(currNode.left)==null){
                    flag = 1;
                    visited.put(currNode.left, 1);
                    q.offer(currNode.left);
                }
                if(currNode.right!=null && visited.get(currNode.right)==null){
                    flag = 1;
                    visited.put(currNode.right, 1);
                    q.offer(currNode.right);
                }
                if(mpp.get(currNode)!=null && visited.get(mpp.get(currNode))==null){
                    flag = 1;
                    visited.put(mpp.get(currNode), 1);
                    q.offer(mpp.get(currNode));
                }

            }
            if(flag==1) ans++;
        }
        return ans;
    }
}
