//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2363 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        ListNode ans = new ListNode();
        ans.next = merge(lists, 0 , len-1);
        return ans.next;
    }

    public ListNode merge(ListNode[] lists, int l, int r){

        if(l==r){
            return lists[l];
        }
        if (l>r){
            return null;
        }
        int mid = (l+r)/2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid+1, r));

    }

    public ListNode mergeTwoLists(ListNode a, ListNode b){
        if(a==null || b==null)return a!=null ? a : b;

        ListNode head = new ListNode();
        ListNode tail = head, aptr = a, bptr = b;
        while(aptr!=null && bptr!=null){
            if(aptr.val<=bptr.val){
                tail.next = aptr;
                aptr = aptr.next;
            }
            else{
                tail.next = bptr;
                bptr = bptr.next;
            }
            tail = tail.next;
        }
        tail.next = (aptr!=null ? aptr : bptr);

        return head.next;

    }

}
//leetcode submit region end(Prohibit modification and deletion)
