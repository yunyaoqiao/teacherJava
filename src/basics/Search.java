package basics;

public class Search {
    //顺序查找1：遍历。从第一个到最后一个记录依次与给定值比较，若相等则查找成功
    public int seqSearch1(int[] arr,int key){
        int n=arr.length;
        for (int i=0;i<n;i++){
            if (arr[i]==key)
                return i;
        }
        return 0;
    }
    //顺序查找2：带哨兵。设置哨兵，可以避免每次循环都判断是否越界。在数据量很多时能提高效率。
    public int seqSearch2(int[] arr,int key){
        int i=arr.length-1;//数组的最后一位
        arr[0]=key;//将arr[0]设置为哨兵
        while (arr[i]!=key)
            i--;//遍历，跳过所有arr[i]!=key的情况，让索引位i从最后一位开始向前移动
        return i;
    }

    //二分查找：要求顺序查找，并且关键码已经排好序。时间复杂度：O(logn)
    public int binarySearch(int[] arr,int key){
        int lo=0;
        int hi=arr.length-1;
        while (lo<=hi){
            int mid=lo+(hi-lo)/2;//在这个循环里，每次都要重计算mid

            ////插值查找：基于二分查找。应用于表长较大，关键字分布均匀的查找
//            int mid=lo+(hi-lo)*(key-arr[lo])/(arr[hi]-arr[lo]);
            if (key<arr[mid])
                hi=mid-1;
            else if (key>arr[mid])
                lo=mid+1;
            else
                return mid;
        }
        return 0;
    }
    //斐波拉契查找：改变中间节点mid的位置--不再是中间值或插值，而是mid=low+F(k-1)-1
    public static int fib(int n){
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        return fib(n-1)+fib(n-2);
    }

    //二叉排序树/二叉搜索树 BST
    //左子<根<右子，




        public static void main(String[] args) {
        int[] arr = {0,45,68,32,15};
        Search aSearch = new Search();
        BSTree bsTree=new BSTree();
        System.out.println(aSearch.seqSearch1(arr, 15));
        System.out.println(aSearch.seqSearch2(arr, 45));
        System.out.println(aSearch.binarySearch(arr,68));
    }
}
