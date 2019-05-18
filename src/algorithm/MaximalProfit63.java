package algorithm;

//　假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股票可能获得的利润是多少？
// 例如一只股票在某些时间节点的价格为{9, 11, 8, 5,7, 12, 16, 14}。
// 如果我们能在价格为5的时候买入并在价格为16时卖出，则能收获最大的利润11。
public class MaximalProfit63 {
    //遍历每一个数字，在第i个数字时，保存之前最小的数字（i-1中最小值）.
    // 两者差最大即为最大利润。
    public static int maxDiff(int[] arr) {
        if (arr==null||arr.length<2)
            return -1;
        int min=arr[0];//0~i-1中的最小值
        int maxDiff=arr[1]-min;//当前值与最小值的差距.  ！！不要求不能是负数。
        for (int i=1;i<arr.length;i++){
            if (arr[i-1]<min)
                min=arr[i-1];//更新最小值
            if (arr[i]-min>maxDiff)
                maxDiff=arr[i]-min;
        }//最大利润可以是负数，只要亏损最小就行
        return maxDiff;
    }
    public static void main(String[] args){
        int[] data1 = new int[]{9,11,8,5,7,12,16,14};
        int[] data2 = new int[]{9,8,7,6,5,4,3,1};
        System.out.println(maxDiff(data1)); //11
        System.out.println(maxDiff(data2)); //-1
    }
}
