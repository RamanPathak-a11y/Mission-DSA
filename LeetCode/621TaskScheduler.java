class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; ++i) {
            if (freq[i] > 0) {
                pq.add(freq[i]);
            }
        }

        int time = 0;
        while (!pq.isEmpty()) {
            ArrayList<Integer> ls = new ArrayList<>();
            int task = 0;
            int cycle = n + 1;

            while (cycle-- > 0 && !pq.isEmpty()) {
                int cur = pq.poll();
                if (cur > 1) {
                    ls.add(cur - 1);
                }
                task++;
            }

            for (int i : ls) {
                pq.add(i);
            }

            time += (pq.isEmpty()) ? task : n + 1;
        }

        return time;
    }
}
