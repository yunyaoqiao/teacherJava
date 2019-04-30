package string;

import java.util.ArrayList;
import java.util.Iterator;

//输入一个字符串,按字典序打印出该字符串中字符的所有排列。
// 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
//输入描述:输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。

//类似题：1.求字符的所有组合。就是会有a,b,c,ab,bc,ac等等出现。仍然类似，n个字符的m长的组合，分解为求n-1中长度为m-1（组合中含第一个数）的组合；求n-1中长为m的组合。
//2.把8个数放到正方的8个顶点，要求三组相对面上4个点和相对。解法：得到有8个数组的所有排列，然后得到其中符合要求的排列
//3.国际象棋8*8盘上有8个皇后，任意两个皇后不在同一行、列、对角线等等。解法：1.任意两个皇后不在同一行，先对行数组全排列；2.不在同一对角线上，则i-j==columindx[i]-columindex[j].
//总结：按一定要求摆放若干数字/字符，先求出全排列，然后按要求去掉不满足的
public class PermutationHelper38 {
    //把复杂的问题分解成小问题。我们求整个字符串的排列，其实可以看成两步：
    //
    //1.求所有可能出现在第一个位置的字符（即把第一个字符和后面的所有字符交换[相同字符不交换]）；
    //2.固定第一个字符，求后面所有字符的排列。这时候又可以把后面的所有字符拆成两部分（第一个字符以及剩下的所有字符），
    // 依此类推。这样，我们就可以用递归的方法来解决。

    //举例：1.对于a,b,c（下标为0,1,2）
    //0与0交换,得a,b,c => 1与1交换,得a,b,c =>2与2交换,得a,b,c(存入一个数组容器里)
    //                => 1与2交换，得a,c,b =>2与2交换,得a,c.b(存入)
    //0与1交换,得b,a,c => 1与1交换,得b,a,c =>2与2交换,得b,a,c(存入)
    //                => 1与2交换，得b,c,a =>2与2交换,得b,c,a(存入)
    //0与2交换,得c,b,a => 1与1交换,得c,b,a =>2与2交换,得c,b,a(存入)
    //                => 1与2交换，得c,a,b =>2与2交换,得c,a.b(存入)

    //2.有相等的字符：对于a,a,b（下标为0,1,2）
    //0与0交换,得a,a,b => 1与1交换,得a,a,b =>2与2交换,得a,a,b(存入)
    //                => 1与2交换，得a,b,a =>2与2交换,得a,b,a(存入)
    //0与1相同,跳过
    //0与2交换,得b,a,a =>1与1交换,得b,a,a =>2与2交换,得b,a,a(存入)
    //                =>1与2相同，跳过
    static ArrayList<String> res=new ArrayList<>();
    public static ArrayList<String> Permutation(String str) {
        if (str==null)
            return res;
        PermutationHelper(str.toCharArray(),0);
        return res;
    }
    //递归函数
    public static void PermutationHelper(char[] str, int i){
        //当i到达数组最后一位时，完成了一个字符串的排列
        //否则就继续循环：1.先把第一个字符（i处的字符）与所有位置交换，注意跳过相等的情况 2.继续递归
        if (i==str.length-1){
            res.add(String.valueOf(str));//把字符数组变为字符串，加入到结果集
        }
        else {
            for (int j=i;j<str.length;j++){
                if (str[j]==str[i]&&j!=i)//要求j是不同于i的位置。见第二个举例
                    continue;
                swap(str,i,j);//交换i处字符 与所有剩下的位置
                PermutationHelper(str,i+1);
                swap(str,i,j);//注意！！！一定要写。还原成上面语句执行前的字符样子。
                // 例如abc--->经过一次外层交换为bac(当输出bac、bca)后----->然后将bca经过排序为bac----->还原后 进行下一次外层循环交换cab,继续递归完成。
            }
        }
    }

    private static void swap(char[] str, int i, int j) {
        char temp=str[i];
        str[i]=str[j];
        str[j]=temp;
    }
    public static void main(String[] args) {
        String strs="aac";
        ArrayList<String> ret = Permutation(strs);
        Iterator iterator=ret.iterator();
        while (iterator.hasNext()){
            String i= (String) iterator.next();
            System.out.println(i);
            iterator.remove();
        }
    }

}
