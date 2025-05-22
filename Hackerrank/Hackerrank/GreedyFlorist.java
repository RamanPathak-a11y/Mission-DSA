mport java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class GreedyFlorist
 {

    // Complete the getMinimumCost function below.
     public static int getMinimumCost(int k, int[] c) {
        Integer[] flowerCosts = Arrays.stream(c).boxed().toArray(Integer[]::new);
        Arrays.sort(flowerCosts, Collections.reverseOrder());

        int minimumCost = 0;
        int numberOfFlowers = 0;
        int i = 0;

        while (i < flowerCosts.length) {
            for (int j = 0; j < k && i < flowerCosts.length; j++) {
                minimumCost += (1 + numberOfFlowers) * flowerCosts[i];
                i++;
            }
            numberOfFlowers++;
        }

        return minimumCost;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
