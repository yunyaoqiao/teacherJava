package array;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.ArrayList;

//找出所有和为S的连续正数序列
//eg:输入和为15.15=1+2+3+4+5=4+5+6=7+8，故输出1~5，4~6，7~8.
public class FindContinuousSequence572 {
    //滑动窗口的方法：用两个数字 start 和 end 分别表示序列的最小值和最大值，
    // 首先将 start 初始化为1，end 初始化为2。
    // 如果从start到end的和大于sum，我们就从序列中去掉较小的值(即增大start),
    //相反，则增大end。
    //终止条件为：至少有两个数--->start一直增加到"(1+sum)/2并且end小于sum"为止
    public static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();//{1~5，4~6，7~8}
        if (sum<3)
            return res;//1或2
        int start=1,end=2,mid=(1+sum)/2;
        while (start<mid){
            int s=totalSum(start,end);
            if (s==sum){
                res.add(getSequence(start,end));
                end++;//继续增加，看看还有没有别的组合方式
            }
            else if (s>sum)
                start++;//s>sum，去掉序列里较小的值
            else
                end++;//扩大序列值
        }
        return res;
    }

    private static ArrayList<Integer> getSequence(int start, int end) {
        ArrayList<Integer> temp=new ArrayList<>();
        for (int i=start;i<=end;i++){
            temp.add(i);
        }
        return temp;//返回”start-end“的正数组成的list
    }

    private static int totalSum(int start, int end) {//求和
        int sum=0;
        for (int i=start;i<=end;i++){
            sum+=i;
        }
        return sum;
    }
    public static void main(String[] args){
        System.out.println(findContinuousSequence(15));
    }
}
