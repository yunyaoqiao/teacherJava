package algorithm;
//数字以01234567891011121314...的格式排列。
// 在这个序列中，第5位（从0开始计）是5，第13位是1，第19位是4。求任意第n为对应的数字。
public class DigitsInSequence44 {
    //遍历。每枚举一个数，就求出其位数。该数位数+前面数字的位数<=n，则继续枚举；若>n，则第n位数在这个数里

    //方法二：以第15位数字2为例（2隶属与12，两位数，位于12从左侧以0号开始下标为1的位置）
    //步骤1：首先确定该数字是属于几位数的;
    //      如果是一位数，n<9;如果是两位数，n<9+90*2=189;//如果是三位数，n<189+900*3=2889
    //      说明是两位数。
    //步骤2：确定该数字属于哪个数。10+(15-10)/2= 12。//100+(1001-190)/3= 370。
    //步骤3：确定是该数中哪一位。15-10-(12-10)*2 = 1, 所以位于“12”的下标为1的位置，即数字2。//1001-190-(370-100)*3 = 1
    public static int digitAtIndex(int index){
        if (index<0)
            return -1;
        if (index<10)
            return index;
        int cur=10,length=2;//当前给出的数字,初始为10，长度2位
        int boundNum=10;
        while (cur+lengthSum(length)<index){
            cur=cur+lengthSum(length);
            boundNum=boundNum*10;
            length++;
        }
        int addNum=(index-cur)/length;
        int curNum=boundNum+addNum;
        return Integer.toString(curNum).charAt(index-cur-addNum*length)-'0';
    }

    private static int lengthSum(int length) {
        int count=9;
        for (int i=1;i<length;i++)
            count=count*10;
        return count*length;//假如给定一个两位数，那么两位数上的数的总位数为（9*10）*2
    }
    public static void main(String[] args){
        System.out.println(digitAtIndex(19));//该序列的第19位数为4
    }
}
