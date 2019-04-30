package bitOperation;

//实现一个函数，输入一个int型整数，输出该数字在计算机中二进制表示形式的1的个数。
//类似题目：m、n,改变m二进制的多少位，才能得到n. 先将两数异或，得到不同的位数的个数为1（1010^1101=0111）,求1的个数
public class NumberOf1_15 {
    //好方法：整数-1:右边数第一个1开始，所有的位取反（1100-1=1011）
    //该结果与原数相与，右边第一个1开始的所有位置都变为0（1011&1100=1000）
    //这样的计算可以算几次，就代表原数有几个1
    public static int numberOf1(int n){
        int count=0;
        while (n!=0){
            n=(n-1)&n;
            count++;
        }
        return count;
    }
    //差方法：将原数与1相与，则最右边的结果如果是1就代表该位是1；将1左移.
    //直到最后flag左移变为负数结束
    public static int numberOf1_2(int n){
        int count=0;
        int flag=1;
        while(flag!=0){
            if((n&flag)!=0)
                count++;
            flag<<=1;
        }
        return count;
    }
    public static void main(String[] args){

            System.out.println(numberOf1_2(3));

    }
}
