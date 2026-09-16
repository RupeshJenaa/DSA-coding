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
    public ListNode removeNodes(ListNode head) {
        ListNode ans = null;
        Stack<Integer> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        st.push(head.val);
        ListNode curr = head.next;
        while(curr != null) {
            while(!st.isEmpty() && curr.val > st.peek()) st.pop();
            st.push(curr.val);
            curr = curr.next;
        }

        while(!st.isEmpty()) {
            list.add(st.pop());
        }
        Collections.reverse(list);
        ans = new ListNode(list.get(0));
        ListNode temp = ans;
        for(int i=1; i<list.size(); i++) {
            temp.next = new ListNode(list.get(i));
            temp = temp.next;
        }
        //temp.next = null;
        return ans;
    }
}