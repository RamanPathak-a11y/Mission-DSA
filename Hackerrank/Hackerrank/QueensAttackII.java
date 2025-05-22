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
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER k
     * 3. INTEGER r_q
     * 4. INTEGER c_q
     * 5. 2D_INTEGER_ARRAY obstacles
     */

    static Map<Integer, Set<Integer>> obstacleMap = new HashMap<>();

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Clear the map in case the method is called multiple times
        obstacleMap.clear();

        // Populate the map
        for (List<Integer> obstacle : obstacles) {
            int r = obstacle.get(0), c = obstacle.get(1);
            obstacleMap.computeIfAbsent(r, x -> new HashSet<>()).add(c);
        }

        // Count all directions
        int total = 0;
        total += countDirection(n, r_q, c_q, -1, 0); // up
        total += countDirection(n, r_q, c_q, 1, 0); // down
        total += countDirection(n, r_q, c_q, 0, -1); // left
        total += countDirection(n, r_q, c_q, 0, 1); // right
        total += countDirection(n, r_q, c_q, -1, -1); // up-left
        total += countDirection(n, r_q, c_q, -1, 1); // up-right
        total += countDirection(n, r_q, c_q, 1, -1); // down-left
        total += countDirection(n, r_q, c_q, 1, 1); // down-right

        return total;
    }

    // Generic method to count squares in one direction
    public static int countDirection(int n, int r, int c, int dr, int dc) {
        int count = 0;
        r += dr;
        c += dc;

        while (r >= 1 && r <= n && c >= 1 && c <= n) {
            if (obstacleMap.containsKey(r) && obstacleMap.get(r).contains(c))
                break;
            count++;
            r += dr;
            c += dc;
        }
        return count;
    }
}

public class QueensAttackII {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
