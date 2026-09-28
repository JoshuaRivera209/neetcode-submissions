class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
            return the k most frequent elements in a given array

            we need to know the frequency of the elements in order to do this, so we can build a frequency map
            
            we can start by using a hashmap to get the numbers and their frequencies
            iterate through the input array, mapping out a hashmap where the key pair is (nums[i], freq)

            once we build out the hashmap and get the frequencies of the numbers we can then use a bucket sort to organize the data into specific "buckets"

            we will use a List of ArrayLists, where the index is the frequency number, and the value at the position is an array list containing all numbers that appeared
            at that frequency.

            once all the data is sorted here, we can iterate BACKWARDS, from the right to the left, building our output.
            we iterate backwards because we want the k most frequent elements.
            
            for the frequency array, we can safely assume the size of it will be at most the size of nums,
            because the maximum frequency is bounded to nums.length, where nums contains just 1 integer for the whole array.

            so steps to completion might look like:
            - use hashmap to build frequency map of nums
            - create frequency list:
                ArrayList<Integer> freq = new ArrayList[nums.length+1];
            - run bucket sort, placing numbers into frequency list
            - create output array
            - create count var to keep track of k values
            - loop through freq in reverse, adding the first k numbers to output array

            time complexity: O(n)
            space complexity: O(n)
        */

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1];
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for (int i=0; i<freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        int count = 0;
        int[] res = new int[k];
        for (int i=freq.length-1; i>0 && count < k; i--) {
            for (int n : freq[i]) {
                res[count++] = n;
            }
            
        }
        return res;
    }
}
