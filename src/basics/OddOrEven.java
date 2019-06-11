package basics;

public class OddOrEven {
    //正确判断方法：
    //(1) 通过a%2！=0来判断。
    //(2) 通过(a&1)==1来判断。（推荐使用，位操作，性能更优）
    public static String oddOrEven(int a){
        if (a%2!=0)
            return "odd";
        else
            return "even";
    }
    public static String oddOrEven2(int a){
        if ((a&1)==1)
            return "odd";
        else
            return "even";
    }
    public static void main(String[] args) {
        int[] a = { 0, 11, -11, 20, -20 };
        System.out.println("————利用“a%2!=0”判断————");
        for (int i : a) {
            System.out.println(i + "为" + oddOrEven(i));
        }

        System.out.println("————利用“(a&1)==1”判断————");
        for (int i : a) {
            System.out.println(i + "为" + oddOrEven2(i));
        }
    }
}
