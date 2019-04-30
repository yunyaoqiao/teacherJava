package array;
//请实现一个函数，将一个字符串中的每个空格替换成“%20”。
// 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class ReplaceSpace5 {
    private static String StringBuffer = "We are happy.";

    public static String replaceSpace(String str) {
        //新建一个字符串数组
        //遍历，遇到空格就替换(String.charAt(i),String.valueOf(b).equals())，不是就添加到新字符串
        StringBuffer stringBuffer=new StringBuffer();
        for (int i=0;i<str.length();i++){
            char b=str.charAt(i);
            if (str.valueOf(b).equals(" "))
                stringBuffer.append("20%");
            else
                stringBuffer.append(b);
        }
        return stringBuffer.toString();
    }
    public static void main(String[] args){
        System.out.println(replaceSpace(StringBuffer));
    }
}
