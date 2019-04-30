package Tree;
//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
// 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
//类似：判断是不是前序输出数组，根在第一个位置。
//解决二叉树“遍历”的总体思路：1.先找到根 2.基于根分为左右子树 3.递归处理左右子树
public class VerifySquenceOfBST33 {
    //bst树是啥？无相同数字时，左子<根，右子>根。普通：左子<根<=右子
    // 其中序遍历刚好就是一个排序好的数组
    //所以：对于后序遍历来说，序列数组的最后一个元素一定是根节点, 根据这个元素，将前面的数组分为左、右两个部分，
    // 左侧部分都比该元素小，右侧部分都比该元素大，如果右侧部分有比该根节点小的元素，那么就不是后序遍历，如此递归进行。
    //有点像快排切分元素？？
    public static boolean verifySquenceOfBST(int [] sequence) {
        //注意输入数组为空/仅1个值的情况
        if (sequence==null)
            return false;
        if (sequence.length==1)
            return true;
        return judge(sequence,0,sequence.length-1);
    }

    private static boolean judge(int[] sequence, int start, int root) {
        if (root-start<=1)
            return true;//注意！！千万写上。表明数组中要判断的只有一个值
        int i=start;
        //1.遍历找到第一个比根大的点的位置 2.从这个位置开始，继续遍历，当再发现比根小的，就说明不是后序啦
        while (sequence[++i]<sequence[root]);//跳过所有比根小的数，找到第一个比根大的数的位置为i
        for (int j = i;j<root;j++){
            if (sequence[j]<sequence[root])
                return false;
        }
        return judge(sequence,start,i-1)&&judge(sequence,i,root);
    }
    /*private int partition(int[] a,int lo,int hi){
        int i=lo,j=hi+1;//索引位在数组的头部和尾部
        int v=a[lo];//切分元素
        while (true){
            while (a[++i]<v) if (i==hi) break;//与切分元素比较，有比切分元素小的，就给索引+1
            //直到到达数组的右端，跳出。此时的i的位置，代表第一个比切分元素大的数字的位置。
            while (v<a[--j]) if (j==lo) break;//j代表从右侧起，第一个比切分小的数字的位置
            if (i>=j) break;//结束的条件
            exch(a,i,j);//将i(左侧起第一个大于v的数字)、j(右侧起第一个小于v的数字)交换
        }
        exch(a,lo,j);//将切分元素从lo,放入到正确位置j.
        return j;
    }*/
    public static void main(String[] args){
        //            8
        //          /   \
        //         6     10
        //       /  \   / \
        //      5    7 9   11
        int[] data = {5,7,6,9,4,10,8};
        int[] data1 = {5,7,6,9,11,10,8};
        System.out.println(verifySquenceOfBST(data));//false
        System.out.println(verifySquenceOfBST(data1));
    }
}
