package array;
//在一个长度为n的数组中，所有数字的取值范围都在[0,n-1]，
// 但不知道有几个数字重复或重复几次，找出其中任意一个重复的数字。
public class Duplicate3 {
    public boolean duplicate(int numbers[],int length,int[] duplication){
        if ((numbers==null)||(numbers.length<2)){
            return false;
        }
        quickSort(numbers,0,numbers.length-1);
        for (int i=0;i<numbers.length;i++){
            System.out.println(numbers[i]);
        }
        int pre=numbers[0];
        for (int i=1;i<numbers.length;i++){
            if (numbers[i]==pre)
            {
                duplication[0]=numbers[i];
                return true;}
            else
                pre=numbers[i];
        }
        return false;
    }
    public static void quickSort(int[] a,int lo,int hi){
        if (lo>=hi) return;//注意等号
        int j=partion(a,lo,hi);
        quickSort(a,lo,j-1);
        quickSort(a,j+1,hi);
    }
    public static int partion(int[] a,int lo,int hi){
        int i=lo,j=hi+1;
        int v=a[lo];
        while (true){
            while (a[++i]<v) if (i==hi) break;
            while (a[--j]>v) if (j==lo) break;
            if (i>=j) break;//注意等号
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j;
    }
    public static void exch(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    //因为数字i,在位置i上
    //所以遍历数组，跳过其中i==a[i]的情况。专门处理i!=a[i]的情况：把i处的数据a[i]定位m,
    // 1.若m=a[m]，那么就说明重复了；
    // 2.若不等，就交换m=a[i]与a[m]=a[a[i]]
    public boolean duplicate2(int numbers[],int length,int[] duplication){
        if ((numbers==null)||(length<2)){
            return false;
        }
       for (int i=0;i<length;i++){
            while (i!=numbers[i]){//跳过数字i在a[i]上的情况
                if (numbers[i]==numbers[numbers[i]]){//相等则说明重复
                    duplication[0]=numbers[i];
                    return true;
                }
                else{//不等则交换
                    int temp=numbers[numbers[i]];
                    numbers[numbers[i]]=numbers[i];
                    numbers[i]=temp;
                }

            }
       }
       return false;
    }
    public static void main(String[] args){
        int[] data = {2,3,1,0,2,5,3};
        int[] duplication={1,2,3};
        Duplicate3 duplicate=new Duplicate3();
        System.out.println((duplicate.duplicate(data,7,duplication)));
    }
}
