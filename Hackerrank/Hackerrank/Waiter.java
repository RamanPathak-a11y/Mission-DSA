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
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY number
     * 2. INTEGER q
     */

    public static List<Integer> waiter(List<Integer> number, int q) {
        Stack<Integer> supportStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        int max = getMax(number);
        List<Integer> primes = getPrimes(max, number.size());

        for (int i = 0; i < q; i++) {
            int prime = primes.get(i);
            for (Integer n : number) {
                if (n % prime == 0) {
                    result.add(n);
                } else {
                    supportStack.push(n);
                }
            }
            number.clear();
            while (!supportStack.isEmpty()) {
                number.add(supportStack.pop());
            }
        }
        for (int i = number.size() - 1; i >= 0; i--) {
            result.add(number.get(i));
        }
        return result;
    }

    private static int getMax(List<Integer> number) {
        int max = 0;
        for (Integer i : number) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static List<Integer> getPrimes(int n, int cap) {
        List<Integer> primes = new ArrayList<Integer>();
        boolean[] prime = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i] && primes.size() < cap)
                primes.add(i);
        }
        return primes;
    }

}

public class Waiter {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
