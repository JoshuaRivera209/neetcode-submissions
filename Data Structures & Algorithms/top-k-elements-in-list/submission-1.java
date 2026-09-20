class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
            the best way to approach this problem is using bucket sort

            we will do 2 main functions here. we want to sort the numbers based on frequency using a hashmap.
            we will then go through this hashmap, and build out a frequency array with bucket sort.
            this frequency list will be a list of arrays, where the index is the actual frequency, and the array at a certain index is the list of numbers
            that appeared with that frequency.

            for example: 
            Input: nums = [1,2,2,3,3,3]
            the hashmap would have
            keys: 1, 2, 3
            values: 1, 2, 3
            because 1 appeared once, 2 appeared twice, and 3 appeared 3 times.
            from here, we will use bucket sort to put the numbers in their respective arrays.
            the frequency list will look something like: [[], [1], [2], [3]]
            at index 1 we put 1 because it appeared once based on our hashmap.
            to get our result from here, we finally look at our k value.
            we iterate through the frequency list in REVERSE, because we want the top k most frequent elements.
            we simply iterate, in reverse, adding values from the arrays starting at the most frequently appeared array until our output array has k elements.
            we will also use a counter as we fill out our output array to keep track of how many k values we've inserted.

            note: our bound for the frequency map is capped to the size of the input array, assuming all numbers are the same in the array

            time complexity: O(n)
            space complexity: O(n)

            steps to complete problem:
            - create hashmap
            - create frequency list
            - loop through list and initialize all arrays
            - loop through input array and build out hashmap frequencies
            - iterate through hashmap, using key to access list index and value to insert into array
            - iterate through frequency map in reverse, building out result array
            - once result array reach k elements, return result
        */
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freq = new ArrayList[nums.length+1];
        for (int i=0; i<freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        int count=0;
        int[] res = new int[k];
        for (int i=freq.length-1; i>0 && count<k; i--) {
            for (int n : freq[i]) {
                res[count++] = n;
            }
        }
        return res;
    }
}
