package algorithm;
//求斐波那契数列的第n项的值。f(0)=0, f(1)=1, f(n)=f(n-1)+f(n-2) n>1
//类似题目：青蛙跳台阶，一次跳一级或者跳两级，一共跳n级
//分析青蛙跳n,一种是一次跳1级，剩下有f(n-1)种；一次跳两级，剩下f(n-2)种
//类似题目：2*1矩形方格覆盖2*8矩形方格
public class Fibonacci10 {
    //原始递归 n^2
    public static int Fibonacci(int n) {
        if (n<=0)
            return 0;
        if (n==1)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }

    //自底向上的递归.求f(1)+f(2)=f(3) n
    public static int Fibonacci2(int n) {
        if (n<=0)
            return 0;
        if (n==1)
            return 1;
        int f1=0,f2=1;
        for (int i=2;i<=n;i++){
            f2=f2+f1;//1(f1)+2(f2)=3(f2),2(f1=f2-f1)+3(f2)=5(f2)
            f1=f2-f1;
        }
        return f2;
    }
    public static void main(String[] args){
        System.out.println(Fibonacci(13));
        System.out.println(Fibonacci2(13));
    }
}
