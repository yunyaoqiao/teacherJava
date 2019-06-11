package array;
//在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
// 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
public class FindInTwoDimension4 {
    public static boolean Find(int target, int [][] array) {
        //从右上角开始查起，被查数字<右上角就左移；
        // 被查数字>右上角就下移动；直到被查数字与右上角等或越界
        if (array.length==0||array[0].length==0)
            return false;
        int m=0;//行
        int n=array[0].length-1;//列
        int v=array[m][n];
        while (target!=v){
            if (m<array.length-1&&n>0){//注意m、n的取值范围，这是停止判断的重要条件
                if (target<v)
                    n--;
                else if (target>v)
                    m++;
                v=array[m][n];//新的右上角数据
                }
             else
                 return false;
        }
        return true;
    }
    public static void main(String[] args){
        int[][] data = {{1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}};
        System.out.println(Find(50, data));
    }
}
