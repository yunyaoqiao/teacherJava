package string;

import java.util.Scanner;

//找出两个字符串中最大公共子字符串,如"abccade","dgcadde"的最大子串为"cad"
public class GetMaxSubString {
    public static String getMaxSubString(String str1,String str2){
        String min=str1.length()<=str2.length()?str1:str2;//确定短串
        String max=min.equals(str1)?str2:str1;//确定长串
        if (max.contains(min)){
            System.out.println(min);
            return min;
        }
        //遍历短一点的串，从后向前不断截取子串，判断长串里有没有这个子串
        for (int i=0;i<min.length();i++){
            for (int start=i,end=min.length();end>start+1;end--){
                String temp=min.substring(start,end);//短串里截取的一个子串
                if (max.contains(temp)){
                    System.out.println(temp);
                    return temp;
                }
            }
        }
        return null;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        String s1=scanner.nextLine();
        String s2=scanner.nextLine();
        getMaxSubString(s1,s2);
    }
}
