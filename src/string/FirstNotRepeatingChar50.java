package string;

import java.util.HashMap;

//在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
// 并返回它的位置, 如果没有则返回 -1.

//类似问题：1.输入两个字符串，在第一个串中删除所有在第二个串中出现的字符。
// 从“we are students”删除在“aeiou”中出现的字符，得到“w r stdnts”。
//思路：用哈希表存第二个字符串，从头到尾扫描第一个字符串，判断每个字符是不是在哈希表中。复杂度o(n)

//2.删除字符串中所有重复的字符。“google”-->“gole”。
//思路：遍历字符串，用哈希表存，key为字符"g",value为"false/true"。初始都是false,当遇到了一个g,下标为103（ascii），改为true.
//3.两个单词字母相同，每个字母出现数目也相同，就是变位词：slient=>listen.判断两个单词是不是变位词
//思路：哈希表key为第一个字符串的每个字符，value为每个字符出现的次数。 扫描第二个字符串时，当扫描到每个字符时，将对应字符的哈希值-1。如果扫描完第二个串，哈希表都为0，就是变位词。

//总结：判断多个字符是不是在某个字符串出现/统计多个字符在某个字符串出现的次数。---思路：基于数组创建哈希表。
public class FirstNotRepeatingChar50 {
    //先在hash表中统计各字母出现次数，第二次扫描直接访问hash表获得次数。也可以用数组代替hash表。时间：o(n)，空间o(1)
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
       //用数组来存每个数字出现的次数。
        int[] times=new int[256];//java中，char是unicode编码，2字节（16bit）
        for (int i=0;i<str.length();i++)
            times[str.charAt(i)]++;//遍历字符串，得到每个字符的数目
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
