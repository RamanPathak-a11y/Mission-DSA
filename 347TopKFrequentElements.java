public class 347TopKFrequentElements {
    class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> fMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(!fMap.containsKey(nums[i])) {
                fMap.put(nums[i], 0);
            }
            fMap.put(nums[i], fMap.get(nums[i]) + 1);
        }

        ArrayList<Integer>[] frequency = new ArrayList[nums.length + 1];
        for( Map.Entry<Integer, Integer> entry : fMap.entrySet()) {
            if(frequency[entry.getValue()] == null) {
                frequency[entry.getValue()] = new ArrayList<>();
            }
            frequency[entry.getValue()].add(entry.getKey());
        }

        int j = 0;
        for(int i=frequency.length - 1; i>= 0; i--) {
            if(frequency[i] != null) {
                for(int l=0; l < frequency[i].size(); l++) {
                    if(j < result.length) {
                        result[j] = frequency[i].get(l);
                        j++;
                    } else break;
                }
                if(j > result.length - 1) break;
            }
        }
        return result;
    }
}
}
