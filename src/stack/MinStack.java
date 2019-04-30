package stack;

import java.util.Stack;

//定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。min、push、pop的时间复杂度为o1
public class MinStack {
    //用一个栈stack保存数据，用另外一个栈temp保存依次入栈最小的数
    //eg.stack中依次入栈:5, 3, 4, 10, 2, 12, 1, 8。则temp依次入栈:5, 3, 3，3, 2, 2, 1, 1
    //所以：每次入栈的时候，如果入栈的元素比min中的栈顶元素小或等于则入栈，否则用最小元素入栈。
    static class StackWithMin{
        static Stack<Integer> stack=new Stack();
        static Stack<Integer> temp=new Stack();
        static int min=Integer.MAX_VALUE;//2^23-1
        public static void push(int node){
            stack.push(node);
            if (node<min){
                temp.push(node);
                min=node;
            }
            else
                temp.push(min);
        }
        //注意：弹出元素、取最小值，都要先判断栈是否为空
        public static Integer pop(){
            if (stack.isEmpty())
                return null;
            temp.pop();
            return stack.pop();
        }
        public static Integer min(){
            if (temp.isEmpty())
                return null;
           /* int m=temp.pop();
            temp.push(m);*/
            return temp.peek();//查看栈顶元素，但是不会移除它
        }
    }
    public static void main(String[] args){
        StackWithMin stack = new StackWithMin();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(1);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());

    }
}
