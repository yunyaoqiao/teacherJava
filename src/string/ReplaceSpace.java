package string;

public class ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        //得到str的长度
        int length=str.length();
        //创建一个新串存放改为%20的字符
        StringBuilder stringBuilder=new StringBuilder();
        //遍历str,如果是‘ ’，就替换
        for (int i=0;i<length;i++){
            char a=str.charAt(i);//获取i处字符
            if (String.valueOf(a).equals(" "))//字符转换为string
            {
                stringBuilder.append("%20");
            }
            else
                stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args){
//        replaceSpace();
        String a="1125";
        System.out.println(a.length());
    }
}
