package array;
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
// 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
// NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
public class MinNumberInRotatedArray11 {
    //基本原理：数组的第一个元素a[0]一定是>=a[a.length-1]的。
    //利用二分法，最后夹逼到第二个子数组的第一个值，就是最小元素
    //a[mid]>a[high],说明a[mid]在第一个子数组里，eg.3、4、5里。令low=mid+1
    //a[mid]<a[high]，说明a[mid]在第二个子数组里，eg.1、2.令high=mid
    //a[mid]=a[high]，这是特殊情况，如1,0,1,1,1,此时遍历查找high=high-1
    //二分查找停止条件，当low<high
    public static int minNumberInRotateArray(int [] array) {
        int length=array.length;
        int low=0,high=length-1;
       /* if (array[low]<array[high])
            return array[low];*///代表数组已经有序
        while (low<high){
            int mid=low+(high-low)/2;
            if (array[mid]>array[high])
                low=mid+1;
            else if (array[mid]<array[high])
                high=mid;
            else
                high=high-1;
        }
        return array[low];
    }
    public static void main(String[] args){
        int[] data1 = {3,4,5,1,2};
        int[] data2 = {1,0,1,1,1};
        int[] data={2,3,5,6};
        System.out.println(minNumberInRotateArray(data1));
        System.out.println(minNumberInRotateArray(data2));
        System.out.println(minNumberInRotateArray(data));
    }
}
