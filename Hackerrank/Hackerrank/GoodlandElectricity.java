import java.io.*;
import java.util.*;

public class GoodlandElectricity {

    public static void main(String[] args) throws IOException {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int k = Integer.parseInt(line[1]);
        line = br.readLine().split(" ");
        boolean[] light = new boolean[n];
        for (int i = 0; i < n; i++) {
            light[i] = line[i].equals("1");
        }

        k = k - 1;

        int result = 0;
        int last = -1;
        int index = k;
        while (index < n) {
            while (index > -1 && !light[index]) {
                index--;
            }
            if (index == -1 || index <= last) {
                System.out.println(-1);
                return;
            }
            result++;
            last = index;

            index += k * 2 + 1;
        }

        if (last + k + 1 < n) {
            result++;
            boolean l = false;
            for (int i = light.length - 1; i >= light.length - k - 1; i--) {
                if (light[i]) {
                    l = true;
                    break;
                }
            }
            if (!l) {
                System.out.print(-1);
                return;
            }
        }

        System.out.println(result);

    }
}
