package string;
//输入一个英文句子，翻转单词顺序，
// 单词内字符不翻转，标点符号和普通字母一样处理。
// 例如输入输入“I am a student.”，则输出“student. a am I”。
public class ReverseWordsInSentence581 {
    //首先字符串整体翻转，得到“.tneduts a ma I”；
    // 然后以空格作为分隔符进行切分，对于切分下来的每一部分再进行翻转，得到“student. a am I”。
    public static String reverseSentence(String str) {
        if (str.trim().length()==0)
            return str;//字符串没内容
        String[] temp=str.split(" ");
        String res="";
        /*String reverse = "";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            reverse = str.charAt(i) + reverse;
        }
        return reverse;*///翻转字符串
        for (int i=0;i<temp.length;i++){
            res=temp[i]+' '+res;
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(reverseSentence("I am a student."));
    }
}

