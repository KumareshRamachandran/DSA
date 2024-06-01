public class InsertGCDbwLL {
    public static void main(String[] args) {
        System.out.println(gcd(18,6));
    }
    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) return head;
        ListNode temp = head;
        while(temp.next!=null){
            ListNode first = temp;
            ListNode second = temp.next;
            ListNode mid = new ListNode(gcd(first.val, second.val));
            first.next = mid;
            mid.next = second;
            temp = second;
        }
        return head;
    }
    public static int gcd(int a, int b){
        if(b==0) return a;
        else return gcd(b, a%b);
    }
}
