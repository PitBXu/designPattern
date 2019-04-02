package test;


import java.util.Stack;
class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> ls = new Stack<>();
        ListNode tar = head;
        ListNode res = null;
        ListNode target = null;
        ListNode target2 = null;
        boolean isFirst = true;
        while (true){
            if (ls.size() < k && tar != null){
            	//System.out.println("push "+tar.val);
                ls.push(tar);
                tar = tar.next;
       
            }else if(ls.size() == k){
                if (isFirst){
                    isFirst = false;
                    res = ls.pop();
                    target = res;
                }
                target2 = tar;
                while(ls.size() != 0){
                    target.next = ls.pop();
                    //System.out.println("haha : "+target.val);
                    target = target.next;
                }
            }else{
            	if (target == null) {
            		return head;
            	}
                target.next = target2;
                return res;
            }
        }
    }
    public static void main(String[] args) {
    	int [] sz = {1};
		print(reverseKGroup(build(sz),2));
	}
    public static void print(ListNode node) {
    	System.out.print("[");
    	while (node != null) {
    		System.out.print(node.val + ",");
    		node = node.next;
    	}
    	System.out.println("]");
    }
    public static ListNode build(int[] node) {
    	ListNode head = new ListNode(node[0]);
    	ListNode tar = head;
    	for (int i=1;i<node.length;i++) {
    		ListNode ls = new ListNode(node[i]);
    		tar.next = ls;
    		tar = tar.next;
    	}
    	return head;
    }
}