package algorithm;
//给定一个数字，按照如下规则翻译成字符串：0翻译成“a”，1翻译成“b”...25翻译成“z”。
// 一个数字有多种翻译可能，例如12258一共有5种，分别是bccfi，bwfi，bczi，mcfi，mzi。
// 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
public class TranslateNumbersToStrings46 {
    //自上而下，从最大的问题开始，递归 ：
    //                     12258
    //                   /       \
    //              b+2258       m+258
    //              /   \         /   \
    //          bc+258 bw+58  mc+58  mz+8
    //          /  \      \        \     \
    //      bcc+58 bcz+8   bwf+8   mcf+8  mzi
    //        /        \       \     \
    //   bccf+8        bczi    bwfi   mcfi
    //     /
    // bccfi
    //有很多子问题被多次计算，比如258被翻译成几种这个子问题就被计算了两次。f(r)=f(r+1)+g(i,i+1)*f(i+2).
    //
    //自下而上，动态规划，从最小的问题开始---从右向左翻译 ：
    //f(r)表示以r为开始（r最小取0）到最右端所组成的数字能够翻译成字符串的种数。对于长度为n的数字，f(n)=0,f(n-1)=1,求f(0)。
    //递推公式为 f(r-2) = f(r-1)+g(r-2,r-1)*f(r)；
    //其中，如果r-2，r-1组合后翻译成字符数值在10-25内，则g(r-2,r-1)=1，否则为0。
    //因此，对于12258：
    //f(5) = 0
    //f(4) = 1
    //f(3) = f(4)+0*f(5) = 1  ...g(3,4)=>58>25,故为0
    //f(2) = f(3)+f(4) = 2    ...g(2,3)=>25,为1
    //f(1) = f(2)+f(3) = 3
    //f(0) = f(1)+f(2) = 5
    public static int getTranslationCount(int number){
        if (number<0)
            return 0;
        if (number==1)
            return 1;
        return getTranslationCount(Integer.toString(number));//把数字翻译成字符串
    }

    private static int getTranslationCount(String number) {
        int f1=0,f2=1,g=0;//对于长度为n的数字，f(r)=0,f(r-1)=1,求f(0)。
        int temp;
        for (int i=number.length()-2;i>=0;i--){
            if (Integer.parseInt(number.charAt(i)+""+number.charAt(i+1))<26)
                g=1;//r-2,r-1的数字变为字符串组合后，判断是否在10-25
            else
                g=0;
            temp=f2;
            f2= f2+g*f1;//f(r-2) = f(r-1)+g(r-2,r-1)*f(r)；
            f1=temp;//f1表示从r到最右端组成的数字可以翻译的次数
        }
        return f2;
    }
    public static void main(String[] args){
        System.out.println(getTranslationCount(-10));  //0
        System.out.println(getTranslationCount(1234));  //3
        System.out.println(getTranslationCount(12258)); //5
    }
}
