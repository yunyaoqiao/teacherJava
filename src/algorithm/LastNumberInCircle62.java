package algorithm;

import linklist.ListNode;

import java.util.LinkedList;

//0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
public class LastNumberInCircle62 {
    //采用链表来存放数据，每次对长度取余来实现循环
    //将所有数字放入LinkedList链表中（LinkedList比ArrayList更适合增删操作）。
    // 假设当前删除的结点下标为removeIndex，则下一个要删除的结点的下标为：
    // (removeIndex+m)%list.size()，通过取余符号可以实现类型循环的操作。
    //0，1，2，3，4；删除第3个数。依次删除2，0，4，1，剩下3.如删除2，removeIndex=2,
    //下一个要删除的是（2+3）%5=0，则删除第0位的数字：0.

    //推导公式的办法：
//　　n个数字的圆圈，不断删除第m个数字，我们把最后剩下的数字记为f(n,m)。
//　　n个数字中第一个被删除的数字是(m-1)%n， 我们记作k，k=(m-1)%n。
//　　那么剩下的n-1个数字就变成了：0,1,……k-1,k+1,……,n-1，我们把下一轮第一个数字排在最前面，并且将这个长度为n-1的数组映射到0~n-2。
//　　原始数字：k+1,……,   n-1,       0,    1,……k-1
//　　映射数字：0    ,……,n-k-2, n-k-1, n-k,……n-2
//　　把映射数字记为x，原始数字记为y，那么映射数字变回原始数字的公式为 y=(x+k+1)%n。
//　　在映射数字中，n-1个数字，不断删除第m个数字，由定义可以知道，最后剩下的数字为f(n-1,m)。我们把它变回原始数字，由上一个公式可以得到最后剩下的原始数字是（f(n-1,m)+k+1)%n，而这个数字就是也就是一开始我们标记为的f(n,m)，所以可以推得递归公式如下：
//　　　　　　　　　　f(n,m) =（f(n-1,m)+k+1)%n
//　　将k=(m-1)%n代入，化简得到：
//　　　　　　　　　　f(n,m) =（f(n-1,m)+m)%n
//　　　　　　　　　　f(1,m) = 0
//　　代码中可以采用循环或者递归的方法实现该递归公式。时间复杂度为O(n)，空间复杂度为O(1)。
    public static int lastRemaining_Solution1(int n, int m) {//0~n-1个数，删除第m个
        if (n<1||m<1)
            return -1;
        int removeIndex=0;//索引位从1开始。
        for (int i=2;i<=n;i++)
            removeIndex=(removeIndex+m)%i;//i表示此时数字的数目
        return removeIndex;
    }

    //方法二：采用链表来存放，每次对长度取余来实现循环
public static int lastRemaining_Solution2(int n, int m) {
    if(n<1 || m<1)
        return -1; //出错
    ListNode head=new ListNode(0);
    ListNode cur=head;
    for (int i=1;i<n;i++){
        ListNode node=new ListNode(i);
        cur.next=node;
        cur=cur.next;
    }//初始化链表

    cur.next=head;
    cur=head;
    while (true){
        if (cur.next==cur)
            return cur.val;//找出了最后剩下的数
        for (int i=1;i<m;i++)
            cur=cur.next;//向后移动到第m位
        cur.val=cur.next.val;//删除当前节点
        cur.next=cur.next.next;//删除后，cur停止被删除节点的后一个节点上
    }
}
    public static void main(String[] args){
        System.out.println(lastRemaining_Solution1(5,3)); //3
        System.out.println(lastRemaining_Solution2(5,3)); //3
    }
}
