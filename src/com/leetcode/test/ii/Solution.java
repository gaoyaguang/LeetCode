package com.leetcode.test.ii;

public class Solution {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode c1 = l1;
		ListNode c2 = l2;
		ListNode sentinel = new ListNode(0);
		ListNode d = sentinel;
		int sum = 0;
		while (c1 != null || c2 != null) {
			sum /= 10;
			if (c1 != null) {
				sum += c1.val;
				c1 = c1.next;
			}
			if (c2 != null) {
				sum += c2.val;
				c2 = c2.next;
			}
			
			d.next = new ListNode(sum % 10);
			d = d.next;
		}
		if (sum / 10 == 1) 
			d.next = new ListNode(1);
        return sentinel.next;
    }
	
	public static void main(String[] args) {
		Solution s = new Solution();
		
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode result = s.addTwoNumbers3(l1, l2);
		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}
		
//		ListNode sentinel = new ListNode(0);
//		ListNode d = sentinel;
//		
//		System.out.println("内存地址：" + d);
//		System.out.println("内存地址：" + sentinel);
//		System.out.println(d == sentinel);
//		
//		d.next = new ListNode(1);
//		System.out.println("内存地址：" + d.next);
//		System.out.println("内存地址：" + sentinel.next);
//		
//		System.out.println(d.next.val);
//		System.out.println(sentinel.next.val);
	}
	
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		StringBuffer c1 = new StringBuffer();
		StringBuffer c2 = new StringBuffer();
		
		if (l1 == null) {
			c1.append(0);
		}
		if (l2 == null) {
			c2.append(0);
		}
		
		while (l1 != null) {
			c1.append(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			c2.append(l2.val);
			l2 = l2.next;
		}
		
		ListNode sentinel = new ListNode(0);
		ListNode d = sentinel;
		
		Integer sum = Integer.parseInt(c1.toString()) + Integer.parseInt(c2.toString());
		
		char[] c = sum.toString().toCharArray();
		
		for (int i = c.length - 1; i >= 0; i--) {
			int x = Integer.parseInt(c[i] + "");
			d.next = new ListNode(x);
			d = d.next;
		}
		
        return sentinel.next;
    }
	
	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode sentinel = new ListNode(0);
		ListNode result = sentinel;
		int sum;
		while (l1 != null || l2 != null) {
			sum = 0;
			
			if (result != null) {
				sum += result.val;
			}
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			if (sum / 10 == 1) {
				result.val = sum % 10;
				result.next = new ListNode(1); 
			} else {
				result.val = sum;
				if (l1 != null || l2 != null) {
					result.next = new ListNode(0); 
				}
			}
			result = result.next;
		}
		return sentinel;
    }
	
	public ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
		ListNode sentinel = new ListNode(0);
		ListNode result = sentinel;
		for(int sum = 0; l1 != null || l2 != null || sum != 0; sum /= 10) {
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			result.val = sum % 10;
			if (l1 != null || l2 != null || sum /10 == 1) {
				result.next = new ListNode(0);
			}
			result = result.next;
		}
		return sentinel;
    }
}
