package string;

import java.util.HashMap;

//在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
// 并返回它的位置, 如果没有则返回 -1.
public class FirstNotRepeatingChar50 {
    //先在hash表中统计各字母出现次数，第二次扫描直接访问hash表获得次数。也可以用数组代替hash表。
    public static int firstNotRepeatingChar(String str) {
        if (str.length()==0)
            return -1;
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for (int i=0;i<str.length();i++){
            if (hashMap.containsKey(str.charAt(i))){//注意：是判断是否存在某一个键值！！
                int value=hashMap.get(str.charAt(i));
                hashMap.put(str.charAt(i),value+1);//key为某个字母，value为该字母出现次数
            }
            else
                hashMap.put(str.charAt(i),1);//该字母第一次出现
        }
        for (int i=0;i<str.length();i++){
            if (hashMap.get(str.charAt(i))==1)
                return i;
        }
        return -1;
    }
    public static int firstNotRepeatingChar2(String str) {
       //用数组来存每个数字出现的次数
        int[] times=new int[256];//java中，char是unicode编码，2字节（16bit）
        for (int i=0;i<str.length();i++)
            times[str.charAt(i)]++;
        for (int i=0;i<str.length();i++){
            if (times[str.charAt(i)]==1)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(firstNotRepeatingChar("abaccdeff"));
        System.out.println(firstNotRepeatingChar2("abaccdeff"));
    }
}
