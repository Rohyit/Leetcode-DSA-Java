// Problem: Find the Duplicate Number
// Link: https://leetcode.com/problems/find-the-duplicate-number/description/
// Approach: Tortoise and Hare Algo

// T.C. : O(n)
// S.C. : O(1)

package Hashing;
class Solution {
    public int findDuplicate(int[] nums) {

        // BRUTE FORCE : T.C. : O(n) & S.C. : O(n) 
        /*Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            if(set.contains(num)){
                return num;
            }
            set.add(num);
        }
        return -1;
        */

        // OPTIMIZED : T.C. : O(n) & S.C. : O(1)
        int n = nums.length - 1;
        int slow = 0;
        int fast = 0;
        
        do{
            slow = nums[slow];
            fast = nums[fast];
            fast = nums[fast];
        } while(slow != fast);

        slow = 0;

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}