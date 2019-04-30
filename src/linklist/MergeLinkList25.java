package linklist;
//合并两个顺序链表
public class MergeLinkList25 {
    //递归实现。a,b链表，如果a1<b1，则以a1为头、让a2跟b1比较合并；否则相反。最后返回头节点就行啦
    //注意空链表，以及第一个链表为空或第二个链表为空
    public static ListNode mergeLinkList(ListNode listNode1,ListNode listNode2){
        if (listNode1==null)
            return listNode2;
        if (listNode2==null)
            return listNode1;
        ListNode mergeHead=null;
        if (listNode1.val<listNode2.val){
            mergeHead=listNode1;
            mergeHead.next=mergeLinkList(listNode1.next,listNode2);
        }
        else {
            mergeHead=listNode2;
            mergeHead.next=mergeLinkList(listNode1,listNode2.next);
        }
        return mergeHead;
    }
    public static void main(String[] args){
        ListNode listNode1=new ListNode(1);
        listNode1.next=new ListNode(3);
        listNode1.next.next=new ListNode(5);
        ListNode listNode2=new ListNode(2);
        listNode2.next=new ListNode(2);
        listNode2.next.next=new ListNode(4);
        ListNode head=mergeLinkList(listNode1,listNode2);
        System.out.println(head);
    }

}
