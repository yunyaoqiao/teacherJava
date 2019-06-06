package stack;

import java.util.Stack;

//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
// 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
// （注意：这两个序列的长度是相等的）
public class IsPopOrder31 {
    //原理：将原数列依次压栈，把栈顶元素与所给出栈队列相比，如果相同则出栈，如果不同则继续压栈，直到原数列中所有数字压栈完毕。
    // 判断依据：最后，检测栈中是否为空。若空，说明出栈队列可由原数列进行栈操作得到。（是的话栈会变空）
    // 否则，说明出栈队列不能由原数列进行栈操作得到。
    public static boolean isPopOrder(int [] pushA,int [] popA) {
//注意：判断两个数组的长度应该一样
        if (pushA.length!=popA.length||pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> stack=new Stack<>();
        int index=0;//记录：与出栈队列要比较的位置
        for (int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            //注意！！一定要先看看栈是不是空的了，如果栈已经空了，这时看栈顶元素，会异常“EmptyStackException”
            while (!stack.empty()&&stack.peek()==popA[index]){
                stack.pop();
                index++;
            }
        }
        return stack.empty();//根据栈最后是否为空来判断：是否为出栈数组
    }
    public static void main(String[] args){
        int[] push = {1,2,3,4,5};
        int[] pop1 = {4,5,3,2,1};
        int[] pop2 = {4,3,5,1,2};
        System.out.println(isPopOrder(push,pop1));
        System.out.println(isPopOrder(push,pop2));
    }
}
