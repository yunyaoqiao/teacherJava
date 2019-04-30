package array;
//在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
// 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
// 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
// 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
public class FindGreatestSumOfSubArray42 {
    //遍历数组，用cur记录当前值，max记录最大值。
    //若cur<0，表示之前的数字中有负数，故要舍弃之前的数。cur=当前的数
    //否则的话cur=cur+当前的数。
    //比较cur、max.cur>max的时候就更新max
    //注意特殊情况：数组为空
    public static int FindGreatestSumOfSubArray(int[] array) {
       if (array.length<=0)
           return 0;
       int cur=array[0],max=array[0];
       for (int i=0;i<array.length;i++){
           if (cur<0)
               cur=array[i];//cur=当前数
           else
               cur=cur+array[i];
           if (cur>max)
               max=cur;
       }
       return max;
    }

    //动态规划。对于数据data[],申请一个数组dp[]，
    // 定义dp[i]表示以data[i]为末尾元素的子数组和的最大值。
    // dp的初始化及递推公式可表示为：dp[i] =  data[i]            i=0或dp[i-1]<=0
    //                                     dp[i-1]+data[i]    i!=0且dp[i-1]>0
    //由于只需知道前一个情况的dp值，因此可省去dp数组，申请个变量记录即可
    public static int FindGreatestSumOfSubArray2(int[] array) {
         if (array.length<=0)
            return 0;//特殊情况
         int dp=array[0],maxdp=dp;
         for (int i=1;i<array.length;i++){
             if (dp>0)
                 dp=dp+array[i];
             else
                 dp=array[i];
             if (dp>maxdp)
                 maxdp=dp;
         }
         return maxdp;
    }
    public static void main(String[] args){
        int[] data = {1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray(data));
        System.out.println(FindGreatestSumOfSubArray2(data));
    }
}
