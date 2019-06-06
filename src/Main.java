import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Welcome to vivo !
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arrA = parseInts(br.readLine().split(" "));
        int[] arrB = parseInts(br.readLine().split(" "));
        int m = arrA[0];
        int n = arrA[1];
        ListNode head = null;
        ListNode pre = null;
        for (int v : arrB) {
            ListNode listNode = new ListNode(v);
            if (head == null) {
                head = listNode;
            }
            if (pre != null) {
                pre.next = listNode;
            }
            pre = listNode;
        }
        solution(head, m, n);

    }

    private static void solution(ListNode head, int m, int n) {
        if (head == null || m > n) {
            return;
        }
        ListNode curNode = head;
        int listLen = 0;
        while (curNode != null) {
            listLen++;
            curNode = curNode.next;
        }
        if (n > listLen) {
            return;
        }
        ListNode headListLastNode = head, newList1 = head;
        for (int i = 0; i < m-1; i++) {
            headListLastNode = newList1;
            newList1 = newList1.next;
        }
        ListNode newList1LastNode = head, newList2 = head;
        for (int i = 0; i < n; i++) {
            newList1LastNode = newList2;
            newList2 = newList2.next;
        }
        headListLastNode.next = null;
        newList1LastNode.next = null;

        ListNode reverseList = inverseListNodeByThreePointer(newList1);
        headListLastNode.next = reverseList;
        newList1.next = newList2;

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode inverseListNodeByThreePointer(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode preNode = null, curNode = head, nextNode;
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int v) {
            val = v;
            next = null;
        }

        public String toString() {
            String str = val + " ";
            ListNode node = next;
            while (node != null) {
                str += node.val + " ";
                node = node.next;
            }
            return str;
        }
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

}
