package array;
//请实现一个函数，将一个字符串中的每个空格替换成“%20”。
// 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class ReplaceSpace5 {

    //方法一：若从前往后依次替换，在每次遇到空格字符时，
    // 都需要移动后面O(n)个字符，对于含有O(n)个空格字符的字符串而言，总的时间效率为O(n2)。
    public static String replaceSpace(StringBuffer str) {
        //新建一个字符串数组
        //遍历，遇到空格就替换(String.charAt(i),String.valueOf(b).equals())//char[] 类型转String类型，不是就添加到新字符串
        StringBuffer res=new StringBuffer();
        for (int i=0;i<str.length();i++){
            char b=str.charAt(i);//charAt(int index)：返回指定索引处的 char 值。
            System.out.println("test:"+str.charAt(i)+" ");
            if ((str.charAt(i))==' ')//返回 char 参数的字符串表示形式。
                res.append("%20");
            else
                res.append(b);
        }
        return res.toString();
    }

    //方法二：从后往前遍历
    public static String replaceSpace2(StringBuffer str) {
        StringBuffer res = new StringBuffer();
        int len = str.length() - 1;
        for(int i = len; i >= 0; i--){
            if(str.charAt(i) == ' ')
                res.append("02%");
            else
                res.append(str.charAt(i));
        }
        return res.reverse().toString();
    }

    //方法三：先计算出需要的总长度，然后从后往前进行复制和替换，则每个字符只需要复制一次即可。时间效率为O(n)。
    //双指针法,p1表原来字符串的末尾，p2表新字符串末尾。
    // 替换后的总长度为=原长度+2*空格数，即p2的位置=替换后长度-1。
    //从p1开始遍历，直到p2>p1为止。如果p1遍历没遇到‘ ’就跳过；遇到就替换0，2，%
    public static String replaceSpace3(StringBuffer str) {
        if (str==null)
            return null;
        int length = str.length();
        int p1=length-1;//旧字符串的末尾处
        for (int i=0;i<str.length();i++){//注意：此处的遍历上限一定是str.length(),不能是len
            if (str.charAt(i)==' ')
                length+=2;
        }
        str.setLength(length);//设置新的字符串长度
        int p2=length-1;//新字符串的末尾处
        while (p2>p1){
            if (str.charAt(p1)!=' ')
                str.setCharAt(p2--,str.charAt(p1));//新串的
            else {
                str.setCharAt(p2--,'0');//替换为‘0’.setCharAt的参数为：index(索引位),ch(修改为的字符)
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }
            p1--;
        }
        return str.toString();//原地替换的，没有新建字符串
    }

    public static void main(String[] args){
        StringBuffer sb = new StringBuffer("We are happy.");
//        System.out.println(replaceSpace(sb));
//        System.out.println(replaceSpace2(sb));
        System.out.println(replaceSpace3(sb));
    }
}
