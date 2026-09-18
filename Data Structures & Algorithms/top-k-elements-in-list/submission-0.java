class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
            the idea with this problem is to use bucket sort.
            use a hashmap to get the frequencies of the integers in the array,
            go through this hashmap and apply bucket sort, placing them into appropriate frequency arrays, 
            where the index is the frequency and the value is an array of integers from the input array of that frequency.

            ex: frequency array might look something like this for the example input:
            input: [1,2,2,3,3,3]
            frequency array: [[], [1], [2], [3]]

            this is because 1 was seen once, 2 was seen twice, and 3 was seen 3 times.

            our upper bound for the frequency array will be the size of the input array.
            this is because it is not possible to have a higher frequency than the size of the array. an example would be like example 2, where all the numbers in the array are the same.
            ex2: input: nums = [7,7]
            
            time complexity: O(n + n)
            space complexity: O(n)
        */

        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1];
        for (int i=0; i<freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for (int i=freq.length-1; i>0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
        return res;
    }
}
