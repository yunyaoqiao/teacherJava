package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Reverse {
    public static void main(String args[]) {
       /* List<String> list = Arrays.asList("abcde");
//        list.add(8);
        Collections.reverse(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + ",");
        }*/

          System.out.println(reverse3("qsxye"));
    }
    public static String reverse3(String str) {
        String reverse = "";
        int length = str.length();
        for (int i = 0; i < length; i++) {
            reverse = str.charAt(i) + reverse;
        }
        return reverse;
    }
}
