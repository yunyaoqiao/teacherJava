package stack;

import java.util.ArrayDeque;

//定义一个队列并实现函数max得到队列里的最大值。要求max，pushBack，popFront的时间复杂度都是o(1)。
public class QueueWithMax592 {
    //思路1：借助之前做过的9.用两个栈实现队列和30.包含min函数的栈，我们可以实现求队列的最大值。
    // 入队时间复杂度o(1)，出队时间复杂度o(n),获取最大值时间复杂度o(1)，空间复杂度o(n)。

    //思路二：利用一个双端队列来存储当前队列里的最大值以及之后可能的最大值。
    //在定义题目要求功能的队列时，除了1.定义一个队列data存储数值，还需额外用2.一个队列maxmium存储可能的最大值；
    // 此外，还要3.定义一个数据结构，用于存放数据以及当前的index值，用于删除操作时确定是否删除maxmium中最大值。
    private ArrayDeque<InternalData> data=new ArrayDeque<>();
    private ArrayDeque<InternalData> maximum=new ArrayDeque<>();//得到最大值要用的
    private class InternalData{
        int number;
        int index;
        public InternalData(int number,int index){
            this.number=number;
            this.index=index;
        }
    }
    private int curIndex;

    public void pushBack(int number){//插入数据
        InternalData curData=new InternalData(number,curIndex);
        data.add(curData);

        while (!maximum.isEmpty() && maximum.getLast().number<number)
            maximum.removeLast();
        maximum.addLast(curData);

        curIndex++;//!!不要忘记
    }

    public void popFront(){
        if (data.isEmpty()){
            System.out.println("队列为空，不能删除");
            return;
        }
        InternalData curData=data.removeFirst();
        if (curData.index==maximum.getFirst().index)
            maximum.removeFirst();
    }

    public int max(){
        if (maximum==null){
            System.out.println("队列为空，没用最大值");
            return 0;
        }
        return maximum.getFirst().number;
    }

    public static void main(String args[]){
        QueueWithMax592 queue=new QueueWithMax592();
        queue.pushBack(2);
        queue.pushBack(3);
        queue.pushBack(4);
        queue.pushBack(5);
        System.out.println(queue.max());
    }
}
