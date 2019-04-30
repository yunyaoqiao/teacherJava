package string;
//请实现一个函数用来匹配包括’.’和’*’的正则表达式。
// 模式中的字符’.’表示任意一个字符，而’*’表示它前面的字符可以出现任意次（包含0次）。
// 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串”aaa”与模式”a.a”和”ab*ac*a”匹配，但是与”aa.a”和”ab*a”均不匹配
public class Match19 {
    //双指针法，分别指向str、pattern串
    //当模式中的第二个字符不是“*”时：
    //1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
    //2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

    //而当模式中的第二个字符是“*”时：
    //如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
    // 如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
    //1、模式后移2字符，相当于x*被忽略；
    //2、字符串后移1字符，模式后移2字符；
    //3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位
    public static boolean match(char[] str, char[] pattern){
        int sIndex=0,pIndex=0;//遍历的标签位置
        return match(str,sIndex,pattern,pIndex);
    }

    private static boolean match(char[] str, int sIndex, char[] pattern, int pIndex) {
        if (sIndex>=str.length&&pIndex==pattern.length)//串结束，模式还有
            return true;
        if (sIndex<str.length&&pIndex>=pattern.length)//串没有结束，但是模式已经结束
            return false;
        if (pIndex+1<pattern.length&&pattern[pIndex+1]=='*'){//模式串的后一个字符是*
//        if (pattern[pIndex+1]=='*'&&pIndex+1<pattern.length){//错误,会数组越界
            if((str[sIndex]==pattern[pIndex]||pattern[pIndex]=='.')&& sIndex<str.length)//字符串跟模式的第一个字符匹配
                return match(str,sIndex+1,pattern,pIndex)||
                        match(str,sIndex+1,pattern,pIndex+2)||
                        match(str,sIndex,pattern,pIndex+2);
            else
                return match(str,sIndex,pattern,pIndex+2);
        }
        if ((str[sIndex]==pattern[pIndex]||pattern[pIndex]=='.')&& sIndex<str.length)
            return match(str,sIndex+1,pattern,pIndex+1);
        return false;
    }

    public static void main(String[] args){
        String st="aaa";
        String s1="a.a";
        char[] s=st.toCharArray();
        char[] s2=s1.toCharArray();

        System.out.println(match(s,s2));//true

    }
}
