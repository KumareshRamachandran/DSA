import java.util.HashMap;

public class InorderSuccessor {
    public static void findPreSuc(Node root, int key) {
        Node successor = null, preceder = null;
        Node temp1 = root;
        while (temp1!=null){
            if(key>=temp1.data) {
                preceder = temp1;
                temp1 = temp1.right;
            }
            else{
                successor = temp1;
                temp1 = temp1.left;
            }
        }
    }

}
