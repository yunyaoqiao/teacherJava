package algorithm;

import java.text.NumberFormat;

//把n个骰子仍在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值的出现概率。
public class DicesProbability60 {
    //用数组存放每种骰子点数和出现的次数。令数组中下标为n的元素存放点数和为n的次数。
    // 我们设置循环，每个循环多投掷一个骰子.
    // 假设某一轮循环中，1.我们已知了各种点数和出现的次数；
    // 2.在下一轮循环时，我们新投掷了一个骰子，那么此时点数和为n的情况出现的次数就等于上一轮点数
    // 和为n-1,n-2,n-3,n-4,n-5,n-6的情况出现次数的总和。
    // 从第一个骰子开始，循环n次，就可以求得第n个骰子时各种点数和出现的次数。
    // 也就是说n个骰子掷出的和s为f(n),f(n)=f(n-1)+f(n-2)+f(n-3)+f(n-4)+f(n-5)+f(n-6)

    //用两个数组来分别存放本轮循环与下一轮循环的各种点数(索引位)和出现的次数（值），不断交替使用
    private static final int maxValue = 6;
    public static void printProbability(int number) {//number为掷出骰子的个数
        if (number<=0)
            return;
        int[][] probabilities=new int[2][number*maxValue+1];
        //[2]代表用两个数组交替保存，[number*maxValue+1]是指点数为所在下标时，该点数出现的总次数。
        //probabilities[*][0]是没用的，只是为了让下标对应点数
        for (int i=0;i<2;i++){
            for (int j=0;j<number*maxValue;j++){
                probabilities[i][j]=0;
            }
        }//初始化数组

        for(int i=1;i<=6;i++)
            probabilities[0][i]=1;  //第一个骰子出现的情况

        int flag=0;
        for(int curNumber=2;curNumber<=number;curNumber++) {   //当前是第几个骰子
            for(int i=0;i<curNumber;i++)
                probabilities[1-flag][i]=0;  //前面的数据清零

            for(int i=curNumber;i<=curNumber*maxValue;i++) {
                for(int j=1;j<=6 && j<=i ;j++) {
                    probabilities[1-flag][i]+=probabilities[flag][i-j];
                }
            }
            flag=1-flag;

        }

        int totalP= (int) Math.pow(maxValue,number);//6^n
        for (int i=number;i<=number*6;i++){
            double ratio=probabilities[flag][i]/totalP;//每个点数和s出现的概率
            NumberFormat format=NumberFormat.getPercentInstance();
            format.setMaximumFractionDigits(5);//设置保留小数
            System.out.println("点数和"+(i+number)+"概率："+format.format(ratio));
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i <= 3; i++) {
            System.out.println("-----骰子数为" + i + "时-----");
            printProbability(i);
        }
    }
}
