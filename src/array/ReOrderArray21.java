package array;

//实现一个函数来调整数组中的数字，使得所有奇数位于数组的前半部分，偶数位于后半部分。
public class ReOrderArray21 {
    //双指针法！！，分别指向数字头和尾；
    // 头部跳过所有奇数，指向偶数；尾部指向奇数
    public static void reOrderArray(int [] array) {
        if (array==null||array.length<2)
            return;
        int left=0,right=array.length-1;
        while (left<right){
            while (left<right&&!isEven(array[left]))
                left++;//跳过奇数
            while (left<right&&isEven(array[right]))
                right--;//停在奇数上
            if (left<right){
                int temp=array[left];
                array[left]=array[right];
                array[right]=temp;//调换奇偶数
            }
        }
    }

    private static boolean isEven(int i) {
            return (i&1)==0;
    }//通用性解法--解决将数组分为正负两组、分为能被三整除的两组等等
    public static void main(String[] args){
        int[] data = {1,2,3,4,5,7,7};
        reOrderArray(data);
        for(int i=0;i<data.length;i++) {
            System.out.print(data[i]);
            System.out.print('\t');
        }
        System.out.println();
    }
}
