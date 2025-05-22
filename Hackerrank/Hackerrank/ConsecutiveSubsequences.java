import java.io.*;
import java.util.*;

import java.util.Scanner;

public class ConsecutiveSubsequences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        while (m-- > 0) {
            int[] count = new int[100];
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            count[0] = 1;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                sum = (sum + num) % k;
                count[sum]++;
            }
            long rem = 0;
            for (int i = 0; i < k; i++) {
                rem += (long) count[i] * (count[i] - 1) / 2;
            }
            System.out.println(rem);
        }
    }
}
