package bitOperation;
//数组中只出现一次的两个数字
//在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
public class NumberAppearOnce562 {
    //这道题中数字出现了三次，无法像56-1) 数组中只出现一次的两个数字一样通过利用异或位运算进行消除相同个数字。
    // 但是仍然可以沿用位运算的思路。
    //思路：将所有数字的二进制表示的对应位都加起来，如果某一位能被三整除，那么只出现一次的数字在该位为0；反之，为1。
    public static int findNumsAppearOnce(int[] data){
        if(data==null || data.length<=0)
            throw new RuntimeException();
        int[] bitSum=new int[32];//int占4字节，一共32比特位
        for (int i=0;i<32;i++)
            bitSum[i]=0;//初始化数字的二进制表示位上的求和结果
        for (int i=0;i<data.length;i++){
            int bitMask=1;
            for (int j=31;j>=0;j--){
                int bit=data[i]&bitMask;//通过"number"&bitMask的结果是否为0（bit=0,表明number里这一位是0），
                // bitMask=1不断左移，可以将一个数的二进制存储到32位的数组中。
                if (bit!=0)
                    bitSum[j]=bitSum[j]+1;//得到number在j比特位上的值后，求该j比特位上的数之和
                bitMask=bitMask<<1;
            }
        }
        //!!!可以将一个数的二进制存储到32位的数组中的方法。
        /*int number=100;
        int bitMask=1;
        for(int j=31;j>=0;j--) {
            int bit=number&bitMask;  //注意arr[i]&bitMask不一定等于1或者0，有可能等于00010000
            if(bit!=0)
                bits[j]=1;
            bitMask=bitMask<<1;
        }*/
        int res=0;
        for (int i=0;i<32;i++){
            res=res<<1;
            res=res+(bitSum[i]%3);//"bitSum[i]%3"为0，则这个唯一的数在改位上是0.为1则该位上是1.拼接后得到唯一数的二进制表示
        }//eg：{2, 2, 5, 2}-->0、1、3、1。res=0+1;10+0;100+1;=101=5;
        //!!!二进制转化位数字
        /*int result=0;
        for(int i=0;i<32;i++) {
            result=result<<1;
            result+=bits[i];
            //result=result<<1;  //不能放在后面，否则最前面一位就没了
        }*/
        return res;
    }
    public static void main(String[] args) {
        int[] data = new int[]{2, 2, 5, 2};
        int result = findNumsAppearOnce(data);
        System.out.println(result);
    }
}
