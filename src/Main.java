
import java.util.*;
import java.util.Scanner;
//public class Main {
public class Main {
    static String getzuoyi(String s){
        int n =10%s.length();
//        System.out.print(n);
        int index=0;
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<s.length();i++){
            index = (i+n)%s.length();
            builder.append(s.charAt(index));
        }
        return builder.toString();
    }
    static boolean isLegal(String s){
        char ch;
        for(int i =0;i<s.length();i++){
            if( !((s.charAt(i)>='0'&&s.charAt(i)<='9') ||
                    (s.charAt(i)>='a'&&s.charAt(i)<='z') ||
                    (s.charAt(i)>='A'&&s.charAt(i)<='Z')))
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
//            List<String> input = Arrays.asList("abc","def","==","acd123","44234tjg",
//                    "aga'-=","ad--s","abd","123","abcdef","123456789012345678901234567890123456789012345678901234567890123"
//                    ,"ccccc","ccccc","87&&^"
//            );
        Set hefa = new LinkedHashSet<String>();
        List<String> feifa = new ArrayList<String>();
        List<String> zuoyi = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
//            Iterator<String> i=input.iterator();
        while(sc.hasNext()) {
            String s=sc.next();
//                String s = i.next();
            if (isLegal(s)) hefa.add(s);
            else feifa.add(s);
        }
        // 输出（1）
        Iterator<String> itea =hefa.iterator();
        while(itea.hasNext()) {
            String s= itea.next();
            System.out.print(s+" ");
            zuoyi.add(getzuoyi(s));
        }
        System.out.println();
        // 输出（2）
        itea =feifa.iterator();
        while(itea.hasNext()) {
            System.out.print(itea.next()+" ");
        }
        System.out.println();
        // 输出（3）
        itea = zuoyi.iterator();
        while(itea.hasNext()) {
            System.out.print(itea.next()+" ");
        }
        System.out.println();
        //输出（4）
        zuoyi.sort((o1,o2)->{
            return o1.compareTo(o2);
        });
        itea = zuoyi.iterator();
        while(itea.hasNext()) {
            System.out.print(itea.next()+" ");
        }
    }
//    }
}


