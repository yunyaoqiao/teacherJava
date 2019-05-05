package algorithm;
//把只包含质因子2、3和5的数称作丑数（Ugly Number）。
// 例如6、8都是丑数，但14不是，因为它包含质因子7。
// 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
public class GetUglyNumber49 {
    //方法一：最简单的方法就是让这个数不断除以2，3，5。
    // 要求第N个丑数，只要从1开始，依次判断每个数是不是丑数，如果是，则相应的序号加1，直到序号为N，就是我们要的丑数了。
    //方法二（空间换时间）：每个丑数必然是由小于它的某个丑数乘以2，3或5得到的，这样我们把求得的丑数都保存下来，
    // 用之前的丑数分别乘以2，3，5，找出这三这种最小的并且大于当前最大丑数的值，即为下一个我们要求的丑数。
    private static int getUglyNumber(int index) {
        if (index<=0)
            return 0;
        if (index==1)
            return 1;
        int t2=0,t3=0,t5=0;//表示数字最先开始里面没有2，3，5的因子。其中t2表示有因子2的个数，t3表示有因子3的个数。
        int[] res=new int[index];//初始化数组，用来存储从1-index所有的丑数
        res[0]=1;//第一个丑数是1
        for (int i=1;i<index;i++){
            res[i]=min(res[t2]*2,res[t3]*3,res[t5]*5);//找到t2（2的个数）个2构成的数*2，t3个3构成的数*3等等
            if (res[i]==res[t2]*2) t2++;//该丑数由多*2得到，故t2的值+1
            if (res[i]==res[t3]*3) t3++;
            if (res[i]==res[t5]*5) t5++;
        }
        return res[index-1];//返回存储的最后一个丑数
    }

    private static int min(int i1, int i2, int i3) {
        int min=(i1<i2)?i1:i2;
        return min<i3?min:i3;
    }

    public static void main(String[] args){
        System.out.println(getUglyNumber(5));
    }
}
