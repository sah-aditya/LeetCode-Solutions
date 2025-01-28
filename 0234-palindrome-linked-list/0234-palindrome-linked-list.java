/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        // Step 1: Find the length of the linked list
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            n++;
        }
        
        // Step 2: Store the values in an array
        int[] arr = new int[n];
        curr = head;
        for (int i = 0; i < n; i++) {
            arr[i] = curr.val;
            curr = curr.next;
        }
        
        // Step 3: Check if the array is a palindrome
        int left = 0;
        int right = n - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}