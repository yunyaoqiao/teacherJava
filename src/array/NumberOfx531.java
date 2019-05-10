package array;
//统计一个数字在排序数组中出现的次数。
// 例如，输入{1,2,3,3,3,3,4,5}和数字3，由于3在这个数组中出现了4次，因此输出4。
public class NumberOfx531 {
    //数组是排序的，所以可以用二分查找法。
    //先用二分查找找到3，而后找到第一个3和最后一个3
    //利用二分法找到第一个3：用数组中间值与3比较。当相等时查看前一个是不是3，如果不是就是第一个3；否则继续二分
    public static int getNumberOfK(int[] data,int k){
        int start=getStartOfK(data,k);
        if (start==-1)
            return 0;
        int end=getEndOfK(data,start,k);
        return end-start+1;//最终数字k出现的次数
    }

    private static int getStartOfK(int[] data, int k) {
        if (data[0]>k||data[data.length-1]<k)
            return -1;//如果k不在数组中，返回-1
        int lo=0,hi=data.length-1,mid;
        while (lo<=hi){
            if (lo==hi){
                if (data[lo]==k)
                    return lo;
                else
                    return -1;
            }//递归结束，左右相等
            mid=lo+(hi-lo)/2;//！！！当长度为2，mid取左值
            if (data[mid]>k)//中间值更大，说明k应该在前半段
                hi=mid-1;
            else if (data[mid]<k)//中间值小，k在前半段
                lo=mid+1;
            else
                hi=mid;//相当于是找到了这个k值，然后要寻找第一个k:所以把数组长度截断到lo~mid之间，继续迭代
        }
        return -1;
    }

    private static int getEndOfK(int[] data, int start, int k){
        int lo=start,hi=data.length-1,mid;
        while (lo<=hi){
            if (lo==hi){
                if (data[lo]==k)
                    return lo;
                else
                    return -1;
            }
            mid=lo+(hi-lo+1)/2;//！！！//当长度为2，mid取右值
            if (data[mid]>k)//中间值更大，说明k应该在前半段
                hi=mid-1;
            else if (data[mid]<k)//中间值小，k在前半段
                lo=mid+1;
            else
                lo=mid;//把最低位定在中间值的位置上！
        }
        return -1;
    }

    public static void main(String[] args){
        int[] data1 = new int[]{1,2,3,3,3,3,5,6};
        int[] data2 = new int[]{1,2,3,3,3,3,4,5};
        int[] data3 = new int[]{3,3,3,3,3,3,3,3};
        System.out.println(getNumberOfK(data1,4));
        System.out.println(getNumberOfK(data2,3));
        System.out.println(getNumberOfK(data3,3));
    }
}
