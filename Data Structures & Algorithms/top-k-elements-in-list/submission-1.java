

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // LeetCode range: -10000 to 10000 -> size 20001
        int[] arr = new int[20001];

        int max = 0;
        for (int num : nums) {
            int frequency = ++arr[num + 10000];
            max = Math.max(max, frequency);
        }

        // Create buckets up to max frequency
        List<Integer>[] bucket = new ArrayList[max];
        for (int i = 0; i < max; ++i) {
            bucket[i] = new ArrayList<>();
        }

        // Group numbers into buckets based on frequency
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 0) {
                continue;
            }
            bucket[arr[i] - 1].add(i - 10000);
        }

        // Gather top k frequent elements
        int[] ans = new int[k];
        int index = 0;
        for (int i = max - 1; i >= 0; --i) {
            for (int num : bucket[i]) {
                ans[index++] = num;
                if (index == k) {
                    return ans;
                }
            }
        }

        return ans;
    }
}
