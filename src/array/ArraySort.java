package array;


import edu.princeton.cs.algs4.StdOut;
import sun.misc.FpUtils;

import java.util.*;

public class ArraySort {
    private static int[] sim;
    private static int[] simRep;
    public void setOrder(){
//        Arrays.sort(sim);
//        selectSort(sim);
//        insertSort(sim);
//        shellSort(sim);
//        mergeSort(sim);
//          quickSort(sim);
          bubbleSort(sim);
    }
    private static void exch(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    public void selectSort(int[] a){
        //选择排序：1.找到最小元素，将其和第一个元素调换位置
        //2.继续找到剩下里最小的，与数组第二个元素调换位置
        //所以：内循环比较当前元素与目前已知最小的元素
        for (int i = 0; i<a.length; i++){
            int min=i;//设置最小元素的索引
            for (int j=i+1;j<a.length;j++){
                if(a[j]<a[min])//现在操作的这个数比最小值还小，要移到前面！！
                    min=j;//找到了i+1到a.length的最小值
                exch(a,i,min);//将最小值与第一个元素交换位置,把最小值移到前面
            }
        }
        ////比较（n-1）+(n-2)+..+2+1=n^2/2;交换n次
    }

    public void insertSort(int[] a){
        //插入排序：1.将元素a[i]插入到已经有序的数组(a[j-1]..j[j-n])中的适当位置
        //2.将剩余元素右移,即交换a[j]与a[j-1]
        for (int i=1;i<a.length;i++){//从1处开始与之前的有序数组比较
            for (int j=i;j>0&&(a[j]<a[j-1]);j--){//现在操作的这个数，比之前的数还小！！
                ////从索引位与之前有序的数组一一比较，如果小了，就交换位置
                exch(a,j,j-1);//交换位置
            }
        }
        //平均比较、交换次数是n^2/4。最好比较n-1、交换次数是0。
        //最坏比较、交换次数是n^2/2
    }

    public void bubbleSort(int[] a){
        //冒泡排序：1.内循环中将相邻的两个数比较，把大数移到后面
        //2.外循环一直遍历到数组结束
        for (int i=0;i<a.length-1;i++){
            for (int j=0;j<a.length-1-i;j++){
                //内循环，依次把倒数第一位，倒数第二位等待排好
                //两两比较，直到n-1-i位，把最大的数字放到最后
                if (a[j]>a[j+1])//现在操作的这个数是个比较大的数，要移到后面！！
                    exch(a,j,j+1);
            }
        }
    }

    public void shellSort(int[] a){
        //希尔排序：1.将数组分成h大小的独立数组；
        // 2.独立数组间a[j]与a[j-h]比较，相当于隔h个值来进行交换
        int h=1;
        while (h<a.length/3)
            h=3*h+1;
        while (h>=1){//外部循环用来控制分割数组的大小
            for (int i=h;i<a.length;i++){
                for (int j=i;j>=h&&(a[j]<a[j-h]);j-=h){
                    exch(a,j,j-h);
                }
            }
            h=h/3;
        }
        //性能难以分析，适合大数组，不需要额外内存空间。
        //比较次数<=n*h（h为分组大小）

    }

    public void mergeSort(int[] a){
        //归并排序。需要一个辅助的数组完成。
        simRep=new int[a.length];
//        mergeSort1(a);
        mergeSort(a,0,a.length-1);//调用递归函数
        //性能：相当于把一个数组不断二分为一个二叉树，在各个树内做好排序后再整体排
        //自顶向下要访问、比较数组和nlgn次成正比（lgn层树）；
        //但是需要额外的空间N开销
    }

    private void mergeSort1(int[] a){
        for (int sz=1;sz<a.length;sz=sz+sz)//sz为子数组的大小，从1开始，每次扩充一倍
            for (int lo = 0; lo<a.length-sz; lo+=sz+sz){
             merge(a,lo,lo+sz-1,Math.min(lo+sz+sz-1,a.length-1));//merge(a,0,0,1)
            }
    }//自底向上
    private void mergeSort(int[] a,int lo,int hi){
        //切割数组
        if (hi<=lo) return;
        int mid=lo+(hi-lo-1)/2;
        mergeSort(a,lo,mid);//不断的递归，直到分割成a[0]、a[1]在一个数组，合并他们
        mergeSort(a,mid+1,hi);
        merge(a,lo,mid,hi);//将其合并，merge(a,0,0,1)
    }
    private void merge(int[] a,int lo,int mid,int hi){
        //合并数组1(lo,....,mid) 2(mid+1,....hi)
        int i=lo,j=mid+1;
        for (int k=lo;k<=hi;k++){
            simRep[k]=a[k];//复制数组；(左右两侧有序，但是总体无序)
        }
        for (int k=lo;k<=hi;k++){///注意：a[k]是最终真正排好序的。一定是在复制数组simRep中做比较操作
            if (i>mid) a[k]=simRep[j++];//左边用尽，取右边
            else if (j>hi)  a[k]=simRep[i++];//右边用尽，取左边
            else if (simRep[j]<simRep[i]) a[k]=simRep[j++];//右边数字小，取右边-->索引+1
            //之前写的时候不小心比较错了对象，让复制数组的数字和原数组比较了。。。
            else a[k]=simRep[i++];//左边数字小，取左边
        }
    }
    /*private void merge(int[] arr, int start, int mid, int end) {
        int[] temp=new int[end-start+1];    //存放排序号数据的临时区域
        int k=0;        //临时区域的指针
        int i=start;    //第一个有序区的指针
        int j=mid+1;    //第二个有序区的指针

        while(i<=mid && j<=end) {
            if(arr[i]<=arr[j])
                temp[k++]=arr[i++];
            else
                temp[k++]=arr[j++];
        }
        while(i<=mid)
            temp[k++]=arr[i++];
        while(j<=end)
            temp[k++]=arr[j++];

        for(k=0;k<=end-start;k++)
            arr[k+start]=temp[k];
    }*/

    public static int[] shuffle(int[] a){
        //打乱数组顺序.但是不能把数组定为static
        List list=new ArrayList();
        for (int i=0;i<a.length;i++){
            list.add(a[i]);
        }
        Collections.shuffle(list);
        Iterator iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString()+" ");
        }
        list.toArray();
        return a;
    }
    public void quickSort(int[] a){
//         shuffle(a);//打乱数组顺序
         sort(a,0,a.length-1);//调用递归函数
        //性能：排序的最终效率依赖切分元素的值。最好的情况是刚好对半切分，此时刚好nlgn。
        //最坏就是第一次从最小切分，第二次从二小切分，这样会有过多次切分。
        //平均是nlgn的排序时间
    }
    private void sort(int[] a,int lo,int hi){
//        if (hi<=lo) return;
        int M=5;//取值为5-15
        if (hi<=lo+M){
            insertSort(a);
            return;
        }
        int j=partition(a,lo,hi);//每一次都把切分元素放在了最终位置
        sort(a,lo,j-1);//递归，将左侧排序
        sort(a,j+1,hi);
    }

    private int partition(int[] a,int lo,int hi){
        int i=lo,j=hi+1;//索引位在数组的头部和尾部
        int v=a[lo];//切分元素
        while (true){
            while (a[++i]<v) if (i==hi) break;//与切分元素比较，有比切分元素小的，就给索引+1
            //直到到达数组的右端，跳出。此时的i的位置，代表第一个比切分元素大的数字的位置。
            while (v<a[--j]) if (j==lo) break;//j代表从右侧起，第一个比切分小的数字的位置
            if (i>=j) break;//结束的条件
            exch(a,i,j);//将i(左侧起第一个大于v的数字)、j(右侧起第一个小于v的数字)交换
        }//循环的目的：让这样的交换一直进行，直到让v前都比他小，后面都比他大
        exch(a,lo,j);//将切分元素从lo,放入到正确位置j.
        return j;
    }


    public static void heapSort(Comparable[] a){
        //堆排序：1.先构造一个堆(根节点大于等于它的两个子).数组可以构造完全二叉树
        //2.循环，每次把堆顶元素取出到数组最后一位，然后重新构造堆
        int n=a.length;//n=7
        for (int k=n/2;k>=1;k--){//k=3
            sink(a,k,n);//堆构造函数。通过下沉，从数组右侧到左侧构建
        }
        while (n>1){
            exch(a,1,n--);//将堆顶元素与数组最后一位进行交换。
            sink(a,1,n);//重新构造
        }
        //性能：堆排序排n个元素要比较2nlgn+2n次。
        //同时最优的利用空间和时间，但是无法利用缓存
    }
    private static void sink(Comparable[] a,int key,int n){
        while (2*key<=n){//判断索引key的位置是否到达了底部
            int j=2*key;//子节点
            if (j<n&&(less(a,j,j+1))) j++;//子节点中较大的一个，记为j
            if (!less(a,key,j)) break;//若key比两个子都大，就跳出去
            exch(a,key,j);//交换key索引和其中较大的子节点j
            key=j;//跳入到子节点中，继续下沉
        }
    }
    private static boolean less(Comparable[] a, int i, int j) {
        return a[i-1].compareTo(a[j-1]) < 0;
        //比较函数这里一定要减一，才是真正要比较的两个子的序号
    }
    private static void exch(Object[] pq, int i, int j) {
        Object swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    public ArraySort(int[] s){
      sim=s;
    }
    public static void main(String[] args){
       /* String[] a = {"7","9","5","8","4","1","6"};
        System.out.println("want to know"+a.length);
        heapSort(a);
        show(a);*/
       ArraySort arraySort=new ArraySort(new int[]{7,9,5,8,4,6,1});
       arraySort.setOrder();
        for (int i=0;i<sim.length;i++){
            System.out.println(sim[i]);
        }
    }
}
