import java.util.LinkedList;
import java.util.Queue;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        Node n = new Node(10);
        n.left = new Node(10);
        System.out.println(isSumProperty(n));
    }
    public static int isSumProperty(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            int sum = 0;
            if(curr.left!=null) {
                q.offer(curr.left);
                sum += curr.left.data;
            }
            if(curr.right!=null) {
                q.offer(curr.right);
                sum += curr.right.data;
            }
            if(curr.data!=sum && !(curr.left==null && curr.right==null)) return 0;
        }
        return 1;
    }
}
