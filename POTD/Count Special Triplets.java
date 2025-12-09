// Problem: Count Special Triplets
// Link: https://leetcode.com/problems/count-special-triplets/description/
// Date : 09-Dec-2025

package POTD;

class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int mod = 1_000_000_007;

        Map<Integer, Integer> rf = new HashMap<>();
        Map<Integer, Integer> lf = new HashMap<>();

        for(int num : nums){
            rf.put(num, rf.getOrDefault(num, 0)+1);
        }

        long cnt = 0;
        for(int j = 0; j<n; j++){
            int mid = nums[j];
            rf.put(mid, rf.get(mid) - 1);

            int lc = lf.getOrDefault(mid*2, 0);
            int rc = rf.getOrDefault(mid*2, 0);

            cnt = (cnt + (long)lc*rc) % mod;

            lf.put(mid, lf.getOrDefault(mid, 0)+1);
        }

        return (int)cnt;
    }
}