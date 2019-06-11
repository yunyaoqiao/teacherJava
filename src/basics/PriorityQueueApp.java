package basics;

import java.util.Comparator;
import java.util.PriorityQueue;
//PriorityQueue（优先队列），一个基于优先级堆的无界优先级队列。
//实际上是一个堆（不指定Comparator时默认为最小堆），通过传入自定义的Comparator函数可以实现大顶堆。
public class PriorityQueueApp {
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();//小顶堆，默认容量11
    PriorityQueue<Integer> maxHeap=new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });//大顶堆，初始容量11

    //　插入方法（offer()： 将指定的元素插入此优先级队列。
    // 、add() ：将指定的元素插入此优先级队列。
    // 、poll()： 获取并移除此队列的头，如果此队列为空，则返回 null。
    // 、remove():获取并移除此队列的头。队列为空抛出异常）时间复杂度为O(log(n))

    //　remove(Object)：从此队列中移除指定元素的单个实例（如果存在）。
    // 和 contains(Object) ：如果此队列包含指定的元素，则返回 true。时间复杂度为O(n)；

    //　检索方法（peek：获取但不移除此队列的头；如果此队列为空，则返回 null。
    // 、element：获取但不移除此队列的头。队列为空抛出异常
    // 和 size）时间复杂度为常量。
}
