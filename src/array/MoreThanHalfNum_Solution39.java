package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
// 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
public class MoreThanHalfNum_Solution39 {
    //排序。数组排序后，如果某个数字出现次数超过数组的长度的一半，则一定会数组中间的位置。
    // 所以我们取出排序后中间位置的数，统计一下它的出现次数是否大于数组长度的一半；
    //时间复杂度0（n）
    public static int moreThanHalfNum_Solution1(int [] array) {
         Arrays.sort(array);
         int half=array.length/2;
         int count=0;
         for (int i=0;i<array.length;i++){
             if (array[i]==array[half])
                 count++;
         }//判断排序后数组中中间的数字出现了几次
         if (count>half)
             return  array[half];
         else
             return 0;
    }

     //借助hashmap存储数组中每个数出现的次数，最后看是否有数字出现次数超过数组长度的一半；
    public static int moreThanHalfNum_Solution2(int [] array) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<array.length;i++){
            if (!map.containsKey(array[i]))
                map.put(array[i],1);
            else
                map.put(array[i],map.get(array[i])+1);
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()){
            if (entry.getValue()*2>array.length)
                return entry.getKey();
        }
        return 0;
    }

    //某个数字出现的次数大于数组长度的一半，意思就是它出现的次数比其他所有数字出现的次数和还要多。
    // 因此我们可以在遍历数组的时候记录两个值：1. 数组中的数字;2. 次数。
    // 遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；
    // 若次数为0，则保存下一个数字，并将次数置为1。遍历结束后，所保存的数字即为所求。--只知道它是出现最多的数字，不知道有多少个
    // 最后再判断它是否符合条件
    public static int moreThanHalfNum_Solution3(int [] array) {
        int res=array[0],count=1;
        for (int i=1;i<array.length;i++){
            if (array[i]==res)
                count++;
            else
                count--;
            if (count==0){
                res=array[i];
                count=1;
            }
        }//得到出现最多的数字，存在res里
        count=0;
        for (int i=0;i<array.length;i++){
            if (array[i]==res)
                count++;
        }//判断res对应的数字出现多少次
        return count>array.length/2?res:0;
    }
    public static void main(String[] args){
        int[] data = {4,4,2,3,3,3,3,3,5};
        System.out.println(moreThanHalfNum_Solution1(data));
        System.out.println(moreThanHalfNum_Solution2(data));
        System.out.println(moreThanHalfNum_Solution3(data));
    }

}
