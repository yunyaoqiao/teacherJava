package linklist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
//1.输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。

public class PrintReverse6 {
    //将链表数据遍历入栈，再从栈中打印;遍历一遍
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        Stack<Integer> stack=new Stack<>();
        for (ListNode temp=listNode;temp!=null;temp=temp.next){
            stack.add(temp.val);
        }//将链表中所有的数据遍历加入栈

        while (!stack.isEmpty()){
            System.out.println(stack.pop());//出栈打印
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        while(listNode !=null){
            res.add(listNode.val);
            listNode = listNode.next;
        }
        return res;
    }

   //递归
   public static void printListFromTailToHead2(ListNode listNode){
       if (listNode==null)
           return;
       else {
           printListFromTailToHead2(listNode.next);
           System.out.println(listNode.val);
       }
   }
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        printListFromTailToHead(head);
        printListFromTailToHead2(head);
    }
}
