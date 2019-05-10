package linklist;

import java.util.Stack;

//输入两个单链表，找出它们的第一个公共节点。
public class CommonNodesInLists52 {
//1.暴力破解：每遍历到第一个链表中的一个字符，就遍历整个第二个链表查找（时间复杂度o(mn)）
    //2.从链表的尾部向前看，发现尾部是相同的，向前走会分叉，找到分叉点即可。对于单链表，
    // 本身是前节点->后节点，想要得到后节点->前节点，可以借助于栈的后进先出特性。
    // 两个单链表分别入栈，得到[1,2,3,6,7],[4,5,6,7]，然后不断出栈即可找到分叉点。(空间复杂度o(m+n))
    //3.对于单链表，如果从头结点开始找公共节点，一个麻烦点是两个链表长度可能不一致，因此两个指针不同步。
    //所以：1）先遍历两个链表，分别得到长度，两个链表的长度差。2）在较长链表先走几步
    // 3）同时在两个链表遍历，找到的第一个相同点就是公共点。（节省了空间复杂度）
    public static ListNode indFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> stack1=new Stack<>();
        Stack<ListNode> stack2=new Stack<>();
        while (pHead1!=null){
            stack1.push(pHead1);//入栈
            pHead1=pHead1.next;
        }
        while (pHead2!=null){
            stack2.push(pHead2);
            pHead2=pHead2.next;
        }
        ListNode res=null;
        while (!stack1.isEmpty()&&!stack2.isEmpty()&&stack1.peek()==stack2.peek()){
            stack1.pop();
            res=stack2.pop();//如果两个栈顶元素相同就不断出栈，直到最后一个相同的元素出栈
        }
        return res;
}
    public static ListNode indFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null)
            return null;
        int count1=1,count2=1;
        ListNode p1=pHead1;//！！对于计算链表中元素个数的节点，一定要初始化新值。不然都在pHead上做，
        //下一步移动长字符串链表时，就会已经移动到了最末尾
        ListNode p2=pHead2;
        while (p1!=null){
            p1=p1.next;
            count1++;
        }
        while (p2!=null){
            p2=p2.next;
            count2++;
        }
        if (count1>count2){
            int dif=count1-count2;//两个链表相差的元素个数
            while (dif!=0){
                pHead1=pHead1.next;//链表1先走dif个元素
                dif--;
            }
        }
        else {
            int dif=count2-count1;
            while (dif!=0){
                pHead2=pHead2.next;
                dif--;
            }
        }
        while (pHead1!=null&&pHead2!=null){
            if (pHead1==pHead2)
                return pHead1;//返回第一个相等的节点
            pHead1=pHead1.next;
            pHead2=pHead2.next;
        }
        return null;
    }
    public static void main(String[] args){
        // 1->2->3->6->7
        //    4->5↗
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode commonNode = indFirstCommonNode(node1,node4);
        ListNode commonNode1 = indFirstCommonNode2(node1,node4);
        System.out.println(commonNode.val);
        System.out.println(commonNode1.val);
    }
}
