package array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

//输入n个整数，找出其中最小的K个数。
// 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
public class GetLeastNumbers_Solution40 {

    //法1：先对数组排序，然后取出前k个。/用partition函数，基于数组第k个数调整。----partition函数，o(n)复杂度，要改输入数组
    //分析：创建大小为k的容器，存最小的k个数。容器中数<k，则直接加入；容器数=>k,1.找出容器中最大数、
    //     2.判断删除最大数（最大数 > 新进来的数，就要删掉了） 3. 插入新进来的数
    //     所以用最大堆，堆顶是最大值，o(1)内可以得到最大值，o(logk)插入删除。不修改原数组，适合海量数据
    //     更好实现，红黑树。------------o(nlogk)复杂度，不用改数组
    //法2：利用最大堆保存这k个数，每次只和堆顶比，如果比堆顶小，删除堆顶，新数入堆。最终的最小的k个数，用list表示
    public static ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res=new ArrayList<>();
        //注意:若k的数量>input数组长度等等
        if (k>input.length||k==0){
            return res;
        }
        PriorityQueue<Integer> maxHeap =new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);//如果该 Integer 等于 Integer 参数，则返回 0 值；如果该 Integer 在数字上小于 Integer 参数，则返回小于 0 的值；如果 Integer 在数字上大于 Integer 参数，则返回大于 0 的值（有符号的比较）
            }
        });//使用指定的初始容量创建一个 PriorityQueue，并根据指定的比较器对元素进行排序。
        //PriorityQueue默认是一个小顶堆，然而可以通过传入自定义的Comparator函数来实现大顶堆。
        for (int i=0;i<input.length;i++){
            if (maxHeap.size()!=k)
                maxHeap.offer(input[i]);
            else if (maxHeap.peek()>input[i]){
                Integer temp=maxHeap.poll();
                temp=null;
                maxHeap.offer(input[i]);
            }
        }

        for (Integer integer:maxHeap){
            res.add(integer);
        }
        return res;
    }

    public static void main(String[] args){
        int[] data1 = {6,1,3,5,4,2};
        System.out.println(getLeastNumbers_Solution(data1,5));
    }
}
