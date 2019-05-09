package array;


//如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对总数P。
//并将P对1000000007取模的结果输出。即输出P%1000000007
// 例如输入{7,5,6,4}，一共有5个逆序对，分别是（7,6），（7,5），（7,4），（6,4），（5,4）。
public class InversePairs51 {
    //思路1：暴力解决。顺序扫描数组，对于每个元素，与它后面的数字进行比较，因此这种思路的时间复杂度为o(n^2)。
    //思路2：归并排序。
    //1.先把数组逐步分隔成长度为1的子数组，统计出子数组内部的逆序对个数，（4个数的数组先分为2个长度为2的数组，再分为长度为1的数组）
    // 2.然后再将相邻两个子数组合并成一个有序数组并统计数组之间的逆序对数目，（长度为1的子数组合并、排序，统计逆序对）
    // 直至合并成一个大的数组。其实，这是二路归并的步骤，只不过在归并的同事要多进行一步统计。（对长度为2的子数组合并排序--双指针法。统计逆序对）
    //时间复杂度o(nlogn)，空间复杂度o(n)，如果使用原地归并排序，可以将空间复杂度降为o(1)。
    //           [7     5    6    4]
    //            /              \                  分：将长度为4的数组分成长度为2的数组
    //        [7    5]         [6    4]
    //        /      \         /      \             分：将长度为2的数组分成长度为1的数组
    //     [7]       [5]    [6]        [4]
    //      \         /        \       /            和：1->2，并记录子数组内的逆序对
    //        [5    7]         [4    6]
    //           \                 /                和：2->4，并记录子数组内的逆序对
    //           [4     5    6    7]
    private static int res;
    static int[] temp;
    public static int inversePairs(int[] data){
        if (data==null||data.length<=0)//无效输入
            return 0;
        res=0;
        temp=new int[data.length];
        mergeSortCore(data,0,data.length-1);
        return res;
    }

    private static void mergeSortCore(int[] data, int start, int end) {
        if (start>=end)
            return ;
        int mid=start+(end-start)/2;
        mergeSortCore(data,start,mid);//左侧有序
        mergeSortCore(data,mid+1,end);//右侧有序
        mergeSortMerge(data,start,mid,end);//合并比较
    }

    private static void mergeSortMerge(int[] data, int start, int mid, int end) {
        int i=mid;
        int j=end;
        int index=end;//辅助数组
        for (int k=start;k<=end;k++)
            temp[k]=data[k];
        while (i>=start&&j>=mid+1){
            if (temp[i]>temp[j]){
                data[index--]=temp[i--];//i、index向前移动
                res=res+j-mid;//逆序对数目是第二个子数组中剩余的数字数目
                if (res>1000000007)
                    res=res%1000000007;
            }
            else
                data[index--]=temp[j--];//j、index向前移动
        }
        while (i>=start)//排序
            data[index--]=temp[i--];
        while (j>=mid+1)//注意等号。如排{7，5}的逆序对。上面的循环后结果为{7，7}，现在需要把数字重新排序好为{5，7}
            data[index--]=temp[j--];
    }

    public static void main(String[] args){
        System.out.println(inversePairs(new int[]{7,5,6,4}));
        System.out.println(inversePairs(new int[]{5,6,7,8,1,2,3,4}));
    }
}
