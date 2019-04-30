package algorithm;
//给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
public class Power {
    //注意指数为负数的情况
    //指数为负数：对指数求绝对值、然后将结果求导；底数为0，指数为负，就抛出异常
//0的0次可以为0或1；
//a^n=a^(n/2)*a^(n/2),n为偶数；=a^((n-1)/2)*((n-1)/2)*a,n为奇数---->递归实现
    public static double power(double base, int exponent) {
        int n=exponent;
        if (exponent==0)
            return 1;//指数为0
        else if (exponent<0){//指数为负数，判基数
            if (base==0) throw new RuntimeException("分母不可为0");
            else n=-exponent;
        }
        double res=powerOperation(base,n);
        return exponent<0?1/res:res;//指数为负数时要求导才是最终结果；正数的话就是最终值
    }
    public static double powerOperation(double base,int n){
        if (n==0)
            return 1;
        if (n==1)
            return base;
        double res=powerOperation(base,n/2);//递归。n/2可以改为右移1位
        res=res*res;
        if (n%2==1)//改为与1相与“&”
            res=res*base;
        return res;
    }
    public static void main(String[] args){
        System.out.println("2^3="+power(2,-3));
        System.out.println("0^3="+power(0,3));
        System.out.println("0^-3="+power(0,-3));
    }
}
