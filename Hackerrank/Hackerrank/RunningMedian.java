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
     * Complete the 'runningMedian' function below.
     *
     * The function is expected to return a DOUBLE_ARRAY.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static List<Double> runningMedian(List<Integer> a) {
        ArrayList<Double> list = new ArrayList<Double>();
        ArrayList<Double> result = new ArrayList<Double>();
        for (int i = 0; i < a.size(); i++) {
            double x = a.get(i) * 1.0;
            if (i == 0) {
                list.add(x);
                result.add(x);
            } else {
                int low = 0, high = list.size() - 1, index = 0;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (list.get(mid) > x) {
                        index = mid;
                        high = mid - 1;
                    } else {
                        index = mid + 1;
                        low = mid + 1;
                    }
                }
                list.add(index, x);
                if (list.size() % 2 == 0) {
                    int m = list.size() / 2;
                    result.add((list.get(m) + list.get(m - 1)) / 2);
                } else {
                    int m = list.size() / 2;
                    result.add(list.get(m));
                }
            }
        }

        return result;
    }
}

public class RunningMedian {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = IntStream.range(0, aCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Double> result = Result.runningMedian(a);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
