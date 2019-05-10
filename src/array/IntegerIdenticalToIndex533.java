package array;
//数组中数值和下标相等的元素
//假设一个单调递增的数组里的每个元素都是整数且是唯一的。
// 编写一个程序，找出数组中任意一个数值等于其下标的元素。
// 例如，输入{-3,-1,1,3,5}，输出3
public class IntegerIdenticalToIndex533 {
    //数组单调递增-->用二分法
    public static int getNumberSameAsIndex(int[] data){
        if (data==null||data.length==0)
            return -1;
        int lo=0,hi=data.length-1,mid;
        if (data[lo]>0||data[hi]<0)//说明根本不存在那个索引与值相等的数
            return -1;
        while (lo<=hi){
            mid=lo+(hi-lo)/2;
            if (data[mid]==mid)
                return mid;//找到了索引与值相等的数
            else if (data[mid]<mid)
                lo=mid+1;//索引大，值小-->说明两者相等的位置在后半段
            else
                hi=mid-1;
        }
        return -1;
    }
    public static void main(String[] args){
        System.out.println(getNumberSameAsIndex(new int[]{-3,-1,1,3,5})); //3
        System.out.println(getNumberSameAsIndex(new int[]{0,1,2,3,4}));   //0~4
        System.out.println(getNumberSameAsIndex(new int[]{4,5,6,7,8}));   //-1
    }
}
