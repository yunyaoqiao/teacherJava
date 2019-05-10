package array;
//找0~n中缺失的数字。一个长度为n的递增排序数组中的所有数字都是唯一的，
// 并且每个数字都在范围0~n之内。在范围0~n内的n个数字有且只有一个数字不在该数组中，请找出
public class GetMissingNumber532 {
    //二分法：用二分法找到数组中第一个数值不等于下标的数字
    public static int getMissingNumber(int[] data){
        int lo=0,hi=data.length-1,mid;
        while (lo<=hi){
            mid=lo+(hi-lo)/2;
            if (data[mid]==mid)//如果中间位置的索引（mid）与值相等（）

        }
    }
}
