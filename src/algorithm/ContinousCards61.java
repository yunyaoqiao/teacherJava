package algorithm;

import java.util.Arrays;

//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
// 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
public class ContinousCards61 {
//输入为大小等于5的数组（大小王记为0），输出为布尔值。具体步骤如下：
//　　1）进行对5张牌进行排序；
//　　2）找出0的个数；（可以充当任何数）
//　　3）算出相邻数字的空缺总数；
//　　4）如果0的个数大于等于空缺总数，说明连续，反之不连续；
//　　5）记得判断相邻数字是否相等（重复出现的数字），如果有出现相等，说明不是顺子
    public static boolean isContinuous(int [] numbers) {//输入5张牌
        if (numbers==null||numbers.length<=0)
            return false;
        Arrays.sort(numbers);
        int numberOf0=0;
        int numberOfGap=0;
        for (int i=0;i<numbers.length;i++){
            if (numbers[i]==0)
                numberOf0++;
        }//numberOf0+1就是第一个非0的数字
        int small=numberOf0;//索引位
        int big=numberOf0+1;
        while (big<numbers.length){
            if (numbers[small]==numbers[big])
                return false;//拿起的牌里有重复的数字
            numberOfGap=numberOfGap+numbers[big++]-numbers[small++]-1;
        }
        if (numberOf0>=numberOfGap)
            return true;//有足够的0来填补空位，让扑克有序
        return false;
    }
    public static void main(String[] args) {
        int[] data1 = new int[]{0,5,6,9,8}; //false
        System.out.println(isContinuous(data1));
    }
}
