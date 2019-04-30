package linklist;
//输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
// 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
public class ComplexClone35 {
    public static class RandomListNode {
        int val;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int val) {
            this.val = val;
        }
    }
    //思路一：1.先复制原始链表 2.存储<N,N'>的信息到hash表。设置指向任意位置的指针：如果原始N->S,则N'->S'，可以在hash表根据S找S'
    //思路二：不用占用空间，且复杂度为o(1)
    //1.复制原始链表，将N'链接在N的后面（原始串和本串 交替着存在一起）
    // 2.N'是N的next点，S'是S的next点---->所以如果N->S,则N'->S'.即根据旧链表的兄弟节点，初始化新链表的兄弟节点
    //3.从旧链表拆分得到新链表
    public static RandomListNode clone(RandomListNode pHead){
        RandomListNode head=pHead;//原始链表的中要被处理的节点
        while (head!=null){
            RandomListNode node=new RandomListNode(head.val);//新链表的头节点（要处理的节点），值与原始链表的头节点值相等
            node.next=head.next;//新链表的下一个节点，与旧链表的节点连接
            head.next=node;//旧链表的节点与新链表的节点连接
            head=node.next;//继续处理。下一个要处理的原始链表的节点---->循环直到旧链表所有的点都复制完
        }//1.复制原始链表
        head=pHead;
        while (head!=null){
            pHead.next.random= (pHead.random==null?null:pHead.random.next);//先判断要处理的节点有没有指向任意节点的指针。
            //如果有指向任意节点的指针，那么新链表的节点的任意指针就指向旧链表任意指针的下一个节点
            head=head.next.next;//继续处理旧链表中的点
        }//2.复制任意指针
        head=pHead;
        RandomListNode res=head.next;//最终的复制链表的头
        while (head!=null){
            RandomListNode node=head.next;//新链表中要处理的节点
            head.next=node.next;//把旧链表要链接起来，要把它的下一个指针指向新链表的下一个点
            node.next=(head.next==null?null:head.next.next);//注意！！先判断新链表还有没有下一个点
            head=head.next;//继续处理
        }
        return res;
    }
    public static void main(String[] args){
        RandomListNode head = new RandomListNode(1);
        RandomListNode c2 = new RandomListNode(2);
        RandomListNode c3 = new RandomListNode(3);
        RandomListNode c4 = new RandomListNode(4);
        RandomListNode c5 = new RandomListNode(5);
        head.next = c2;
        head.random = c3;
        head.next.next = c3;
        head.next.random = c5;
        head.next.next.next = c4;
        head.next.next.next.next = c5;
        head.next.next.next.random = c2;
        System.out.println("original:"+'\t'+head);
        System.out.println("clone1:  "+'\t'+clone(head));
    }
}
