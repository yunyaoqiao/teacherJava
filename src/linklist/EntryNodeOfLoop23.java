package linklist;

import java.util.regex.Pattern;

//给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
public class EntryNodeOfLoop23 {
    public ListNode entryNodeOfLoop(ListNode pHead){
//a.设置两个指针，一个是快指针fast，一个是慢指针slow，fast一次走两步，slow一次走一步，
// 如果单链表有环那么当两个指针相遇时一定在环内。
// b.此时将一个指针指到链表头部，另一个不变，二者同时每次向前移一格,当两个指针再次相遇时即为环的入口节点。
// 如果fast走到null则无环(结束条件！！)

//其他思路：（1.判断有环，快慢指针 2.算环中节点数n。从相遇点开始，一次走一步，再次回到相遇点，那么就是环中节点数n。
// 3.求入口。两个指针从头开始，p1先走n步(就是那个快慢指针相遇点)，然后p1、p2同行每次走一步，相遇就是入口）
        if (pHead.next==null||pHead.next.next==null){
            return null;
        }
        ListNode slow=pHead.next;
        ListNode fast=pHead.next.next;
        while (fast!=null){
            if (fast==slow){//两个指针相遇。把其中一个指向头，另一个不变，再同时前移,直到相遇
                fast=pHead;
                while (fast!=slow){
                    fast=fast.next;
                    slow=slow.next;
                }
                return fast;
            }
            slow=slow.next;//两个指针向前走，slow一次一步，fast一次两步
            fast=fast.next.next;
        }
        return null;
    }
}
