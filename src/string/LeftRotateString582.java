package string;

import java.util.Scanner;

//对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
// 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”
public class LeftRotateString582 {
    public static String leftRotateString(String str,int n) {
        //在第 n 个字符后面将切一刀，将字符串分为两部分，再重新并接起来即可。
        // 注意字符串长度为 0 的情况。
        if (str.length()==0)
            return "";
        n=n%str.length();//n在字符串中的位置。mod值
        String s1=str.substring(n,str.length());//返回一个新的字符序列，start=n,end=str.length()。
        String s2=str.substring(0,n);
        return s1+s2;
    }
    public static void main(String[] args){
        String str;
        Scanner scanner=new Scanner(System.in);
        str=scanner.next();
        System.out.println(leftRotateString(str,2));
    }
}
