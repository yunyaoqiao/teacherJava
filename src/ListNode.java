import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ListNode {
   /* public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = Integer.valueOf(in.nextLine());
        int a[][] = new int[1000][1002];
        int counter = 0;
        int i = 0;
        String line = in.nextLine();
        while(!line.equals("")) {
            String[] numbers = line.split(",");
            for (int j = 0; j<numbers.length; j++) {
                a[i][j] = Integer.valueOf(numbers[j]);
                counter++;
            }
            a[i][1000] = numbers.length;
            a[i][1001] = numbers.length;
            i++;
            line = in.nextLine();
        }
        int index = 0;
        while(counter>0) {
            if(a[index][1000]>=3) {
                System.out.print(a[index][a[index][1001]-a[index][1000]]);
                a[index][1000]--;
                if(counter>1)
                    System.out.print(',');
                System.out.print(a[index][a[index][1001]-a[index][1000]]);
                a[index][1000]--;
                if(counter>1)
                    System.out.print(',');
                System.out.print(a[index][a[index][1001]-a[index][1000]]);
                a[index][1000]--;
                if(counter>1)
                    System.out.print(',');
                counter-=3;
            }else while(a[index][1000]>0)  {
                System.out.print(a[index][a[index][1001]-a[index][1000]]);
                a[index][1000]--;
                if(counter>1)
                    System.out.print(',');
                counter--;
            }
            index = (index+1) % i;
        }

    }*/
    /*public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        int readLen = input.nextInt();
        input.nextLine();
        ArrayList<String> ns = new ArrayList<>();
        ArrayList<Integer> nsLen = new ArrayList<>();
        int maxLen = 0;
        do {
            String string = input.nextLine();
            if (string.equals("")) {
                break;
            }
            ns.add(string);
            int len = ((string.length()-1)>>>1)+1;
            maxLen = maxLen<len ? len : maxLen;
            nsLen.add(string.length()-1);
        } while (true);

        String res = "";
        for(int i=0; i<= maxLen/readLen; i++){
            int start = i*readLen*2,end = start +(readLen-1)*2+1;

            for(int j=0;j<ns.size();j++){
                int nowlen = nsLen.get(j);
                if(end <= nowlen){
                    res = res.concat(ns.get(j).substring(start,end+1));
                }else if(start<=nowlen && nowlen < end){
                    res = res.concat(ns.get(j).substring(start,nowlen+1)).concat(",");
                }
            }
        }
        res = res.substring(0,res.length()-1);
        System.out.println(res);
    }
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
    static boolean ishefa(String s){
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
        while (sc.hasNext()) {
            String s = sc.next();
//                String s = i.next();
            if (ishefa(s)) hefa.add(s);
            else feifa.add(s);
        }
        // 输出（1）
        Iterator<String> itea = hefa.iterator();
        while (itea.hasNext()) {
            String s = itea.next();
            System.out.print(s + " ");
            zuoyi.add(getzuoyi(s));
        }
        System.out.println();
        // 输出（2）
        itea = feifa.iterator();
        while (itea.hasNext()) {
            System.out.print(itea.next() + " ");
        }
        System.out.println();
        // 输出（3）
        itea = zuoyi.iterator();
        while (itea.hasNext()) {
            System.out.print(itea.next() + " ");
        }
        System.out.println();
        //输出（4）
        Collections.sort(zuoyi);
        itea = zuoyi.iterator();
        while (itea.hasNext()) {
            System.out.print(itea.next() + " ");
        }
    }*/



        public int data;
        public ListNode next;
        public ListNode(int newData, ListNode linkValue) {
            data = newData;
            next = linkValue;
        }

    }


