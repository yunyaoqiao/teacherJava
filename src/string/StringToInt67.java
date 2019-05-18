package string;
//请你写一个函数StrToInt，实现把字符串转换成整数这个功能。
// 当然，不能使用atoi或者其他类似的库函数。
public class StringToInt67 {
    //主要就是实现对每个字符转化为数字，并进行累加即可。但是有很多特殊情况都需要考虑进去，
    // 例如null、空字符串、带有正负号、字符不是数字、溢出等等。
    //　　对于非法的特殊输入，返回值为0，还要用一个全局变量进行标记。
    //　　写代码时一定要考虑清楚各种测试用例。
    static boolean isValid = false;
    public static int strToInt(String str) {
        if (str==null||str.length()<=0)
            return 0;
        char[] chars=str.toCharArray();//转为字符类型
        long num=0;//转化结果，用long防止越界
        boolean minus=false;
        for (int i=0;i<chars.length;i++){
            if (i==0 && chars[i]=='-')
                minus=true;//字符串开头是“-”
            else if (i==0 && chars[i]=='+')
                minus=false;//字符串开头是“+”
            else {
                int a=chars[i]-'0';
                if (a<0||a>9){
                    isValid=false;
                    return 0;
                }//字符位上的数字不对

                num=(minus==false)?num*10+a:num*10-a;//最终转换结果！！

                isValid=true;//不放在最后面是为了防止str=‘+’的情况被判断为true
                if ((!minus&&num>Integer.MAX_VALUE)||(minus&&num<Integer.MIN_VALUE)){
                    isValid=false;
                    return 0;
                }//防止越界：记住int类型最大正整数为0x7FFFFFFF，最小负整数为0x80000000。
            }
        }
        return (int) num;
    }
    public static void main(String[] args) {
        System.out.println(strToInt("1948243")==1948243);
        System.out.println(isValid==true);
        System.out.println(strToInt("+1948243")==1948243);
        System.out.println(isValid==true);
        System.out.println(strToInt("-1948243")==-1948243);
        System.out.println(isValid==true);
        System.out.println(strToInt("-0")==0);
        System.out.println(isValid==true);
        System.out.println(strToInt("-194+8243")==0);
        System.out.println(isValid==false);
        System.out.println(strToInt("")==0);
        System.out.println(isValid==false);
        System.out.println(strToInt(null)==0);
        System.out.println(isValid==false);
        System.out.println(strToInt("999999999999999")==0);
        System.out.println(isValid==false);
        System.out.println(strToInt("+")==0);
        System.out.println(isValid==false);

        System.out.println(strToInt("2147483647")==2147483647); //0x7FFFFFFF
        System.out.println(isValid==true);
        System.out.println(strToInt("2147483648")==0);
        System.out.println(isValid==false);

        System.out.println(strToInt("-2147483648")==-2147483648); //0x80000000
        System.out.println(isValid==true);
        System.out.println(strToInt("-2147483649")==0);
        System.out.println(isValid==false);
    }
}
