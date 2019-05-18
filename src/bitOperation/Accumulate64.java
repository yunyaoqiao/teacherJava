package bitOperation;
//求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
public class Accumulate64 {
    //逻辑运算符: 如果记得它们有短路特性的话，就可以当作if来使用了。
    //对于A && B，如果A为假，那么就不执行B了；而如果A为真，就会执行B。
    //　　　对于A || B，如果A为真，那么就会不执行B了；而如果A为假，就会执行B。

    //因此我们使用递归来代替循环，用逻辑运算符&&或者||来代替判断语句。
    //代码实现功能为：当n大于1时，和为f(n)=f(n-1)+n，n=1时，f(n)=1
    public static int getSum(int n) {
        int sum=n;
       /* if (n==1)
            return 1;
        else */
/*       if (n>1)
            sum=sum+getSum(n-1);*///正常的递归
        boolean flag=(n>1)&&((sum=sum+getSum(n-1))>0);
//        boolean flag1 = (n==1) || ((sum+=getSum(n-1))>0);
        return sum;
        //注意：
        //使用短路特性时，记得后面的判断语句要写完整
        //　　　　即：不能只写了(sum+=getSum(n-1))，要完整写出(sum+=getSum(n-1))>0
        //　　还有就是前面要赋值给flag才算完整的语句
    }
    public static void main(String[] args){
        System.out.println(getSum(5));
    }
}
