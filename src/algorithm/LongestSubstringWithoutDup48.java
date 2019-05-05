package algorithm;
//输入一个字符串（只包含a~z的字符），求其最长不含重复字符的子字符串的长度。
// 例如对于arabcacfr，最长不含重复字符的子字符串为acfr，长度为4
public class LongestSubstringWithoutDup48 {
    //动态规划,f(i)代表以第i个字符“结束”的不包含重复字符的子字符串的最长长度
    //1.f(i)=f(i-1)+1,第i个字符之前没有出现过，所以最长子串长度+1
    //2.f(i)=d, f(i-1)>=d：d表示第i个字符上次出现的距离，f(i-1)比较大，意味着截取的子串里字符重复了
    //3.f(i)=f(i-1)+1, f(i-1)<d：表示截取的子串里没有重复

    //我们从第一个字符开始遍历，定义两个int变量preLength和curLength来分别代表f(i-1)和f(i)，
    //关键：再创建一个长度为26的pos数组来存放26个字母上次出现的位置，即可根据上述说明进行求解。
    //注意：每次最大长度和字母出现位置要记得更新。
    public static int longestSubstringWithoutDup(String str){
        if (str==null||str.length()<=0)
            return 0;
        int preLength=0;//f(i-1)
        int curLength=0;//f(i)
        int maxLength=0;//最大不重复子串的长度
        int[] pos=new int[26];//存放字母上次出现的位置。 初始为-1，而后如果字母b出现在了第一个位置: "pos[1]=0"、字母b出现在了第二个位置：“pos[1]=1”
        for (int i=0;i<str.length();i++)
            pos[i]=-1;//初始化为-1，负数表示没出现过
        for (int i=0;i<str.length();i++){
            int curChar=str.charAt(i)-'a';
            int prePosition=pos[curChar];//表示该字母之前出现的位置。
            int distance=i-prePosition; //当前字符与它上次出现位置之间的距离
            if (prePosition<0||distance>preLength)//当前字符第一次出现，或者前一个非重复子字符串中没有包含当前字符
                curLength=preLength+1;
            else {
                curLength=distance;
            }
            pos[curChar]=i;//更新该字符出现的最新的位置。eg:"bbb"中，最后此处等于2
            if (curLength>maxLength)
                maxLength=curLength;
            preLength=curLength;
        }
        return maxLength;
    }
    public static void main(String[] args)
    {
        System.out.println(longestSubstringWithoutDup("arabcacfr"));
        System.out.println(longestSubstringWithoutDup("bbb"));
    }
}
