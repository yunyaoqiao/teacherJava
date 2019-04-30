package linklist;
//1.在o(1)时间内删除单链表的节点。
//2.删除排序链表中重复的节点,重复的结点不保留，返回链表头指针。{1，2，3，3，4，4，5}-->{1,2,5}
public class DeleteDuplication18 {
    //考虑多种情况：要删除的节点是不是尾部，链表是不是只有一个节点
    //如果要删除节点是尾节点，需要遍历链表找到后删除；如果只有1个节点，删除后置空；
    //如果是其他节点，将下一个节点的值覆盖要删除的节点，要删除节点的指针指向下一个节点的下一个节点
    public static ListNode deleteNode(ListNode head,ListNode node){
        if (node==head)
            return head.next;
        else if (node.next!=null){
            node.val=node.next.val;
            node.next=node.next.next;
            return head;
        }
        else {
            ListNode listNode=head;
            while (listNode.next!=null)
                listNode=listNode.next;//遍历到尾节点
            listNode.next=null;
            return head;
        }
    }
    //考虑多种情况：头节点是不是就发生重复，或者只有一个节点。
    //1.首先添加一个头节点，以方便碰到第一个，第二个节点就相同的情况
    //2.双指针法！！设置 first ，second 指针， first 指针指向当前确定不重复的那个节点，
    // 而second指针相当于工作指针，一直往后面搜索找值相等的就跳过。
    public static ListNode deleteDuplication(ListNode pHead){
        if (pHead==null||pHead.next==null)
            return pHead;
        ListNode head=new ListNode(-1);
        head.next=pHead;
        ListNode first=head;
        ListNode second=first.next;
        while (second!=null){
            if (second.next!=null&&second.val==second.next.val){
                while (second.next!=null&&second.val==second.next.val){
                    second=second.next;
                }
                first.next=second.next;//跳过所有相等的节点，把唯一节点指向second.next
            }
            else
                first=first.next;//没有重复节点
            second=second.next;
        }
        return head.next;//返回头节点。初始的head是真正头节点的前一个
    }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next= new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(3);
        System.out.println(head);
        head = deleteDuplication(head);
        System.out.println(head);
    }
}
