mport java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NonDivisibleSubset {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[k];
        for(int i=0; i < n; i++){
            int ai = in.nextInt();
            a[ai % k]++;
        }
        int count = 0;
        for (int i = 1; i < (k + 1) / 2; ++i) {
            count += Math.max(a[i], a[k - i]);
        }
        if (k % 2 == 0) {
            count += a[k / 2] > 0 ? 1 : 0;
        }
        count += a[0] > 0 ? 1 : 0;
        
        System.out.println(count);
    }
}
