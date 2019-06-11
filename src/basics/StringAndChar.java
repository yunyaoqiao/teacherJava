package basics;

public class StringAndChar {
    //（1）String类型转char[] 类型，使用String类型的toCharArray()方法；
    //（2）char[] 类型转String类型，使用String.valueOf()方法；
    public static void main(String[] args){
        //string to char
        String string="hello world";
        char[] a=string.toCharArray();//string to char
        for (char c:a)
            System.out.println("char:"+c);

        //char[] to string
        char[] b={'h','e','l','l','o','!'};
        String res=String.valueOf(b);
        System.out.println("string:"+res);
    }
}
