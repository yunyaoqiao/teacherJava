package array;

import java.util.Arrays;
import java.util.Comparator;

//输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
// 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
// 则打印出这三个数字能排成的最小数字为321323。
public class PrintMinNumber45 {
    //先将数组转换成字符串数组，然后对字符串数组按照规则排序，最后将排好序的字符串数组拼接出来。
    //关键就是制定排序规则：
    //若ab > ba 则 a > b
    //若ab < ba 则 a < b
    //若ab = ba 则 a = b
    //原因：a = 21
    //      b = 2
    //因为 212 < 221, 即 ab < ba ，所以 a < b
    //所以我们通过对ab和ba比较大小，来判断a在前或者b在前的。）
    public static String printMinNumber(int [] numbers) {
        if (numbers.length==0)
            return "";
        if (numbers.length==1)
            return String.valueOf(numbers[0]);
        StringBuffer res=new StringBuffer();
        String[] strings=new String[numbers.length];//把数组的数字，加入到字符串数组
        for (int i=0;i<numbers.length;i++)
            strings[i]= String.valueOf(numbers[i]);//赋值
        Arrays.sort(strings, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String c1=o1+o2;
                    String c2=o2+o1;
                    return c1.compareTo(c2);//比较ab,ba的大小
                }
            });
        for (int i=0;i<numbers.length;i++)
            res.append(strings[i]);//将排好序的strings数组加入到结果中
        return res.toString();//返回结果要是字符串
    }
    public static void main(String[] args){
        System.out.println(printMinNumber(new int[]{3,32,321}));
    }
}
