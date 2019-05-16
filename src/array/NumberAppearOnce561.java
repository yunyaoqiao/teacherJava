package array;
//数组中只出现一次的两个数字
//一个整数数组里除了两个数字出现一次，其他数字都出现两次。
// 请找出这两个数字。要求时间复杂度为o(n)，空间复杂度为o(1)。
//eg:{2,4,3,6,3,2,5,5},其中4,6只出现了一次，输出他们
public class NumberAppearOnce561 {
    //难！！考虑：数组中只有一个数组只出现了一次，其他出现两次。
    //异或运算：从头到尾依次异或数组中的数字，结果就是那个只有一次的数字。eg:2^4^3^3^2=4(2^2=0)
    //所以：把原数组分为两个部分，每个部分仅有一个只出现一次的数字，其他出现两次。

    //依旧把所有数字异或，最终的结果就是那两个出现一次的数字a,b异或的结果。因为a，b不相等，因此结果肯定不为0，
    //那么结果的二进制表示至少有一位为1，找到那个二进制结果里的第一个1的位置n，然后我们就可以根据"第n位是否为1"将所有的数字分成两堆.
    //这样相同的数子的任意一位都一样，出现了两次的数据会被分配到同一个子数组里。
    //eg:{2,4,3,6,3,2,5,5},异或结果：0100^0110=0010,根据倒数第二位是否为1分为两个子数组。{2，3，6，3，2} {4，5，5}
    public static int[] findNumsAppearOnce(int [] data) {

        int res=0;
        for (int i=0;i<data.length;i++)
            res^=data[i];//求字符串的异或结果
        int indexOf1=findFirstBit(res);//结果中从右边起，第一个1的位置
        int ret[]=new int[]{0,0};

        for (int i=0;i<data.length;i++){
            if (((data[i]>>indexOf1)&1)==1)//判断indexOf1上的数是不是1，如果是的话相与=1。
                ret[0]=ret[0]^data[i];//indexOf1位上是1的所有数相与的结果
            else
                ret[1]=ret[1]^data[i];
        }
        return ret;
    }

    private static int findFirstBit(int num) {
        if (num<0)
            return -1;
        int indexOf1=0;
        while (((num&1)==0)&&(indexOf1<8*4)){//相与=0，代表这一位是0不是1，要继续往前找
            num=num>>1;
            ++indexOf1;
        }
        return indexOf1;//从右数，得到第一个出现1的位置
    }
    public static void main(String[] args){
        int[] data = new int[]{2,4,3,6,3,2,5,5};
        int[] result = findNumsAppearOnce(data); // 4,6
        System.out.println(result[0]);
        System.out.println(result[1]);
        }
}
