package algorithm;
//给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，
// 其中B中的元素B[i] =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
public class ConstuctArray66 {
    //无法使用除法（用所有的数的积/a[i]），正常连乘的话时间复杂度为O(n^2)，效率非常低。
    //把b[i]分解。B[0]=1*A[1]...A[n-1]
    //           B[1]=A[0]*1...A[n-1]
    //           B[2]=A[0]*A[1]*1...A[n-1]
    //根据对角线把这个矩阵分为上三角和下三角。
    //下三角和B[i-1]有关= c[i]=c[i-1]*a[i-1]
    //上三角和B[i+1]有关= d[i]=d[i+1]*a[i+1]

    //因此我们先从0到n-1遍历，计算C数组；
    // 然后定义一个变量temp代表右半部分的乘积，依次求得D[0],D[1]...D[n-1]
    // 从n-1到0遍历，令B[i]*=temp，而每次的temp与上次的temp关系即为temp*=A[i+1]。
    public static int[] multiply(int[] a) {
        if (a==null||a.length<2)
            return null;
        int[] b=new int[a.length];
        b[0]=1;
        for (int i=1;i<a.length;i++)
            b[i]=b[i-1]*a[i-1];
        int temp=1;
        for (int i=a.length-2;i>=0;i--){
            temp=temp*a[i+1];
            b[i]=b[i]*temp;
        }
        return b;
    }
    public static void main(String[] args){
        int[] data = new int[]{1,2,3,4,5};
        int[] result = multiply(data);
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]);
            System.out.print("  ");
        }
    }
}
