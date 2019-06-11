package basics;
//（1）int类型转char类型，将数字加一个‘0’，并强制类型转换为char即可。
//（2）char类型装int类型，将字符减一个‘0’即可。
public class IntAndChar {
    public static void main(String[] args){
        //int to char
        int num=9;
        char aChar= (char) (num+'0');
        System.out.println("num:"+num+",to char:"+aChar);
        //char to int
        char bChar='3';
        int num2=bChar-'0';
        System.out.println("char:"+bChar+",num:"+num2);
    }

}
