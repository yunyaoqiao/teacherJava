package stack;
import java.util.Stack;
//用两个栈，实现队列的从队尾插入元素offer()和从队头抛出元素poll()

public class TwoStackToQueue9 {
    //两个栈，栈1负责插入、栈2负责弹出。
    // 弹出方案：
    // 1.stack2不是空，就直接pop删除；
    // 2.stack2是空的，删除队列头->把元素从1加入2，弹出栈顶
    Stack<Integer> stack1=new Stack<>();
    Stack<Integer> stack2=new Stack<>();
    public void push(int data){
        stack1.push(data);
    }

    public int pop(){
        if (stack2.isEmpty()&&stack1.isEmpty())//注意处理两个栈都为空的情况
            throw new RuntimeException("queue is empty");
        int node;
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                node=stack1.pop();//2为空时，取出1的元素
                stack2.push(node);//1的元素加入2
            }
        }
        return stack2.pop();
    }
    public static void main(String[] args){
        TwoStackToQueue9 myQueue = new TwoStackToQueue9();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        myQueue.push(4);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }
}
