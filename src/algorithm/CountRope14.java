package algorithm;
//给你一根长度为n的绳子，请把绳子剪成m段，记每段绳子长度为k[0],k[1]...k[m-1],求k[0]k[1]...k[m-1]的最大值。
// 已知绳子长度n为整数，m>1(至少要剪一刀，不能不剪)，k[0],k[1]...k[m-1]均要求为整数。
//例如，绳子长度为8时，把它剪成3-3-2，得到最大乘积18；绳子长度为3时，把它剪成2-1，得到最大乘积2。

public class CountRope14 {
    //动态规划
    //我们定义长度为n的绳子剪切后的最大乘积为f(n),剪了一刀后,f(n)=max(f(i)*f(n-i));
// 假设n为10，第一刀之后分为了4-6，而6也可能再分成2-4（6的最大是3-3，但过程中还是要比较2-4这种情况的），
// 而上一步4-6中也需要求长度为4的问题的最大值，可见，各个子问题之间是有重叠的，所以可以先计算小问题，
// 存储下每个小问题的结果，逐步往上，求得大问题的最优解。
    public static int maxCutting(int length){
        if (length<2) return 0;
        if (length==2) return 1;
        if (length==3) return 2;
        int[] dp=new int[length+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        int max=0;
        int temp=0;
        //j代表每次分割后的长度；i代表绳子的长度
        //注意：要循环到到达i=length;j=i/2的地步，不然是0
        for (int i=4;i<=length;++i){
            for (int j=1;j<=i/2;++j){
                temp=dp[j]*dp[i-j];
                if (temp>max)
                    max=temp;
            }
            dp[i]=max;
        }
        return dp[length];
    }
   /* //贪心算法：n>=5时，尽可能剪长度为3的绳子；剩下长度为4时，剪成两段为2的绳子
    public static int maxCutting1(int length){
        if (length<2) return 0;
        if (length==2) return 1;
        if (length==3) return 2;
        int timesOf3=length/3;
        if (length-timesOf3*3==1)
            timesOf3-=1;
        int timeOf2=(length-timesOf3*3)/2;
        return  (3*timesOf3)*(2*timeOf2);
    }*/
    public static void main(String[] args){
        for(int i=2;i<10;i++){
            System.out.println("长度为"+i+"的最大值->"+maxCutting(i));
        }
    }
}
