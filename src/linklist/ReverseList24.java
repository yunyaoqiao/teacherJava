package linklist;
//2.输入一个链表，反转链表后，输出新链表的头节点。
public class ReverseList24 {
    //调整指针，反转链表。
    // 需要保存三个节点pre cur post.一直遍历
    //cur.next=pre;pre=cur;cur=post;post是否为空？空就返回pre,结束
    public static ListNode ReverseList(ListNode head) {
        //三个节点，分别是pre、cur、post；遍历
        //1.cur的指针指向其前面的节点；2.原来的当前节点变为新的pre的节点；3.原来的后面的节点post,
        //变成新的当前节点cur.4.判断当前post后面有没有节点了，没用的话就返回pre,就是新的头。
        if ((head==null)||(head.next==null))
            return head;
        ListNode pre=null;
        ListNode cur=head;
        ListNode post=head.next;
        while (true){
            cur.next=pre;
            pre=cur;
            cur=post;
            if (post!=null){
                post=post.next;
            }
            else
                return pre;
        }
    }
    public static void main(String[] args){
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(3);
        listNode.next.next=new ListNode(5);
        listNode=ReverseList(listNode);
        System.out.println(listNode);
    }
}
