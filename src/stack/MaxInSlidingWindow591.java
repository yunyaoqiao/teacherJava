package stack;

import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayDeque;
import java.util.ArrayList;

//给定一个数组和滑动窗口的大小，请找出所有滑动窗口的最大值。
// 例如，输入数组{2,3,4,2,6,2,5,1}和数字3，那么一共存在6个滑动窗口，
// 他们的最大值分别为{4,4,6,6,6,5}。
public class MaxInSlidingWindow591 {
    //方一：长度为k的滑动窗口其实可以看成一个队列，而滑动窗口的移动可以看成队列的出队和入队，
    // 因此本题可以转化为求长度为k的队列的最大值。

    //借助之前做过的9.用两个栈实现队列（实现长度为k的队列的入队时间复杂度o(1)，出队时间复杂度o(n),空间复杂度为o(n)）
    // 和30.包含min函数的栈（o(1)），我们可以实现求队列的最大值。(复杂度：o(n))

//方二：把可能成为最大值数字的下标放入双端队列deque，最大值位于队列开头。从而减少遍历次数。
    //数组中任何一个元素的下标都会入队：所有在没有查看后面数字的情况下，任何一个节点都有可能成为某个状态的滑动窗口的最大值。
    // 关键在于出队，以下两种情况下，该下标（在数组中的位置）对应的数字不会是窗口的最大值需要出队：
    // (1)该下标已经在窗口之外。比如窗口长度为3，下标5入队，那么最大值只可能在下标3,4,5中出现，队列中如果有下标2则需要出队；
    // (2)后一个元素大于前面的元素，那么前面的元素出队。比如目前队列中有下标3、4，data[3] = 50,data[4]=40，下标5入队，但data[5] = 70，则队列中的3，4都需要出队。

//数组{2,3,4,2,6,2,5,1}的长度为3的滑动窗口最大值求解步骤如下
//步骤    插入数字    滑动窗口    队列中的下标   最大值
//1       2          2           0(2)          N/A
//2       3          2,3         1(3)          N/A-------2出队<3
//3       4          2,3,4       2(4)          4---------3出队<4
//4       2          3,4,2       2(4),3(2)     4
//5       6          4,2,6       4(6)          6---------2、4出队<6
//6       2          2,6,2       4(6),5(2)     6
//7       5          6,2,5       4(6),6(5)     6---------2出队<5
//8       1          2,5,1       6(5),7(1)     5---------6出队：下标为7，窗口长度为3，则最大值在5.6.7中，故下标4出队

    //从头开始扫描数组，最大值永远位于队列开头
    //　如果遇到的数字比队列中所有的数字都大，那么它就是最大值，其它数字不可能是最大值了，将队列中的所有数字清空，放入该数字，该数字位于队列头部；
    //　如果遇到的数字比队列中的所有数字都小，那么它还有可能成为之后滑动窗口的最大值，放入队列的末尾；
    //　如果遇到的数字比队列中最大值小，最小值大，那么将比它小数字不可能成为最大值了，删除较小的数字，放入该数字。
    //　由于滑动窗口有大小，因此，队列头部的数字如果其下标离滑动窗口末尾的距离大于窗口大小，那么也删除队列头部的数字
    public static ArrayList<Integer> maxInWindows(int[] data,final int size){
        ArrayList<Integer> res=new ArrayList<>();
        if (data==null||data.length==0||data.length<size)
            return res;
        ArrayDeque<Integer> indexDeque=new ArrayDeque<>();
        for(int i=0;i<size-1;i++){
            while(!indexDeque.isEmpty() && data[i]> data[indexDeque.getLast()])//indexDeque.getLast()得到队列里最后一位数字的下标
                indexDeque.removeLast();//如果遇到的数字比队列中所有的数字都大，那么它就是最大值，其它数字不可能是最大值了，将队列中的所有数字清空，放入该数字，该数字位于队列头部；
            indexDeque.addLast(i);
        }

        for(int i=size-1;i<data.length;i++){
            while(!indexDeque.isEmpty() && data[i]> data[indexDeque.getLast()])
                indexDeque.removeLast();//如果遇到的数字比队列中所有的数字都大，那么它就是最大值，其它数字不可能是最大值了，将队列中的所有数字清空，放入该数字，该数字位于队列头部；
            if(!indexDeque.isEmpty() && (i-indexDeque.getFirst())>=size)
                indexDeque.removeFirst();//由于滑动窗口有大小，因此，队列头部的数字如果其下标离滑动窗口末尾的距离大于窗口大小，那么也删除队列头部的数字
            indexDeque.addLast(i);//如果遇到的数字比队列中的所有数字都小，那么它还有可能成为之后滑动窗口的最大值，放入队列的末尾；
            res.add(data[indexDeque.getFirst()]);//获取第一个队列的第一个元素
        }

        return res;
    }

    public static void main(String[] args){
        int[] data = new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer> result = maxInWindows(data,3);
        for(int i=0;i<result.size();i++){
            System.out.print(result.get(i));
            System.out.print("\t");
        }
    }
}
