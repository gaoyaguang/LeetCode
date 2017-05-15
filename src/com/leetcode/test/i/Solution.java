package com.leetcode.test.i;

public class Solution {

	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (target - nums[i] == nums[j]) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int nums[] = { 3, 2, 4 };
		int target = 6;
		int result[] = twoSum(nums, target);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
