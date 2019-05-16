package array;

import java.util.ArrayList;
import java.util.HashMap;

//输入一个递增排序的数组和一个数字S，在数组中查找两个数，
// 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
public class FindNumbersWithSum571 {
    //方一：用一个HashMap，key存储“数S与当前数字的差值”，value存储当前的数字，
    // 比较S=15, 当前的数为4，则往hashmap中插入(key=11, value=4)。
    // 遍历数组，判断hashmap中的key否存在当前的数字（key=4），如果存在，说明存在着另一个数与当前的数相加和为S.
    // 我们就可以判断它们的乘积是否小于之前的乘积，如果小的话就替换之前的找到的数字，如果大就放弃当前找到的。

    // 如果hashmap中的key不存在当前的数字，说明还没有找到相加和为S的两个数，那就把S与当前数字的差作为key，
    // 当前数字作为value插入到hashmap中，继续遍历
    public static ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res=new ArrayList<>();
        if (array.length<2)
            return res;
        HashMap<Integer,Integer> map=new HashMap<>();
        int les=Integer.MAX_VALUE;
        for (int i=0;i<array.length;i++){
            if (map.containsKey(array[i])){//如果当前map中有key=array[i]，就认为有两个数和为s
                if (array[i]*map.get(array[i])<les){
                    les=array[i]*map.get(array[i]);//新的最小的使得和为s的两个数的乘积
                    res.clear();// 移除此列表中的所有元素。
                    res.add(map.get(array[i]));//=s-array[i]
                    res.add(array[i]);
                }
            }
            else{ //没有和为s的两个数.则在map加入元组：key为差值，value为当前值
                int key=sum-array[i];
                map.put(key,array[i]);
            }
        }
        return res;
    }

    //!!数组递增排序，而且要求和为sd 最小乘积组合。
    // 左右夹逼的方法。a+b=sum，a和b越远乘积越小，因为数组是递增排序，
    // 所以一头一尾两个指针往内靠近的方法找到的就是乘积最小的情况。
    //若ai + aj == sum，就是答案（相差越远乘积越小）
    //若ai + aj > sum，说明 aj 太大了，j --
    //若ai + aj < sum，说明 ai 太小了，i ++
    public static ArrayList<Integer> findNumbersWithSum2(int [] array,int sum) {
        ArrayList<Integer> res=new ArrayList<>();
        if (array.length<2)
            return res;
        int i=0,j=array.length-1;//双指针法
        while (i!=j){
            if (array[i]+array[j]==sum){
                res.add(array[i]);
                res.add(array[j]);
                break;
            }else if (array[i]+array[j]<sum)
                i++;
            else
                j--;
        }
        return res;
    }
    public static void main(String[] args){
        int[] data = new int[]{1,2,4,7,11,15};
        ArrayList result = findNumbersWithSum2(data,15);
        System.out.println(result.get(0));
        System.out.println(result.get(1));
    }
}
