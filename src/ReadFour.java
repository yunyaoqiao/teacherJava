import java.util.Iterator;
import java.util.Scanner;

public class ReadFour {
    public static final int N = 3;
    public static void main(String[] args) {
        int[][] m = new int[N][N];
        Calc(m, N);
        Print(m);
    }

    public static void Calc(int[][] m, int num) {
        int k = N;
        for (int i = 0; i <= num / 2; i++) {
            for (int j = i; j < num - i; j++)
                m[i][j] = k++;
            for (int j = i + 1; j < num - i; j++)
                m[j][num - i - 1] = k++;
            for (int j = num - i - 2; j >= i; j--)
                m[num - i - 1][j] = k++;
            for (int j = num - i - 2; j > i; j--)
                m[j][i] = k++;
        }
    }
    public static void Print(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++)
                System.out.print(m[i][j] + "\t");
            System.out.println();
        }
    }
}
