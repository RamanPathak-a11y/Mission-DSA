public

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'substrings' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING n as parameter.
     * 
     */

    public static int substrings(String n) {
        int mod = 1_000_000_007;
        long total = 0;
        long f = 1;
        long prev = 0;

        for (int i = n.length() - 1; i >= 0; i--) {
            int digit = n.charAt(i) - '0';
            prev = (digit * f + prev) % mod;
            total = (total + prev) % mod;
            f = (f * 10 + 1) % mod;
        }

        return (int) total;
    }
}

public class SamandSubstrings {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String n = bufferedReader.readLine();

        int result = Result.substrings(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}{

}
