package linklist;

import java.util.LinkedList;
import java.util.List;
//倒数第k个节点
//求链表中间节点：两个指针，第一个指针一次走一步、第二个指针一次走两步
public class KthFromEnd22 {
    //双指针法：快慢指针！！第一个指针先走k-1步
    //从第k步起，两个指针一起走，当第一个指针走到末尾,返回第二个节点
    //注意鲁棒性：head为null、链表节点数<k、k=0时k-1得到的不是-1、、
    public static ListNode findKthToTail(ListNode head,int k){
        if (head==null||k==0)//k计数从1开始，0没有意义
            return null;
        ListNode temp=head;
        for(int i=0; i < k-1; i++){
            if(temp.next != null)
                temp = temp.next;
            else
                return null;
        }//判断k是不是比链表节点数还多？  到k-1之前，所有的节点都有下一个数
        ListNode slow=head;
        ListNode fast=head;
        for (int i=0;i<k-1;i++){
                fast=fast.next;
        }//第一个节点先走k-1步

        //写错一次，fast!=null，空指针异常
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }//从第k步开始，两个节点一起走，直到第一个节点走到末尾
        return slow;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next= new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(findKthToTail(head,1).val);
        System.out.println(findKthToTail(head,2).val);
        System.out.println(findKthToTail(head,3).val);
        System.out.println(findKthToTail(head,4).val);
    }
}

