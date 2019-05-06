package string;
//　请实现一个函数用来找出字符流中第一个只出现一次的字符。
// 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。
// 当从该字符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
public class FirstCharacterInStream502 {
//字符只能一个一个从字符流中读出来，因此要定义一个容器来保存字符以及其在字符流中的位置
// 从而可以完成每读到一个字符，就能动态更新到目前为止第一个出现一次的字符
// 使用了长度为256的int数组作为哈希表，用字符的ascii码值作为表的键值，
// 当字符仅出现了一次，就把字符的位置作为哈希表的值，如果没有出现则值为-1，
// 如果出现的次数大于1则哈希表对应的值为-2
    //所以：当想要知道到某一位置时第一个出现一次的字符，可以通过扫描该哈希表，
    // 找到大于等于0的值中的最小值，该值所对应的字符就是当前状态第一个出现一次的字符

    //注意：流和串的区别：
    //1）串：字符串已经保存下来了，能够读取遍历，因此在字符串中第一个只出现一次的字符中，
    // 只需要存下每个字符出现的个数，然后直接在字符串中遍历；
    //2）流：字符流没有存下来，无法进行遍历，因此在本题中，只能在数据容器哈希表中遍历，
    // 而且哈希表中存放的是对应字符的位置，而不是个数。
    private int index;
    private int[] occurence;
    public FirstCharacterInStream502(){
        index=0;
        occurence=new int[256];
        for (int i=0;i<256;i++){
            occurence[i]=-1;//初始哈希表所有的字母对应的位置值都是-1
        }
    }
    public void insert(char ch){//构建流式字符出现位置的
        // 哈希表
        if (occurence[ch]==-1)
            occurence[ch]=index;//如果加入的是一个新的字符，那么就把值value改位该字母char在字符串中出现的位置
        else if (occurence[ch]>=0)
            occurence[ch]=-2;//如果该字符已经出现过了，就把值value改为-2
        index++;//在字符串中出现的位置
    }
    public char getFirst(){
        int minIndex=Integer.MAX_VALUE;//2^31-1，是32位操作系统（4字节）中最大的符号型整型常量
        char ch='#';//返回第一个只出现一次的字符
        for (int i=0;i<256;i++){
            if (occurence[i]>=0&&occurence[i]<minIndex){
                ch= (char) i;
                minIndex=occurence[i];//出现该字符的位置
            }
        }
        return ch;
    }
    public static void main(String[] args){
        String str = "google";
        FirstCharacterInStream502 firstCharacterInStream502=new FirstCharacterInStream502();
        for(int i=0;i<str.length();i++){
            firstCharacterInStream502.insert(str.charAt(i));
            System.out.print(firstCharacterInStream502.getFirst());
        }
    }
}
