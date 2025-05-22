import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    /*
     * Complete the 'luckBalance' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER k
     * 2. 2D_INTEGER_ARRAY contests
     */

    public static int luckBalance(int k, List<List<Integer>> contests) {

        int luckBalance = 0;
        List<Integer> importantContests = new ArrayList<>();

        for (int i = 0; i < contests.size(); i++) {
            int luckVal = contests.get(i).get(0);
            int important = contests.get(i).get(1);
            if (important == 1) {
                importantContests.add(luckVal);
            } else {
                luckBalance += luckVal;
            }
        }

        Collections.sort(importantContests, Collections.reverseOrder());

        for (int j = 0; j < importantContests.size(); j++) {
            if (j < k) {
                luckBalance += importantContests.get(j);
            } else {
                luckBalance -= importantContests.get(j);
            }
        }

        return luckBalance;
    }
}

public class LuckBalance {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]); // Number of contests
        int k = Integer.parseInt(firstMultipleInput[1]); // Max important contests Lena can lose

        List<List<Integer>> contests = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] line = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> contest = Arrays.asList(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
            contests.add(contest);
        }

        int result = Result.luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
