Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.

A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:

- 0 <= i, j < nums.length
- i != j
- |nums[i] - nums[j]| == k
  
Notice: that |val| denotes the absolute value of val.

Constraints:

- 1 <= nums.length <= 104
- -107 <= nums[i] <= 107
- 0 <= k <= 107