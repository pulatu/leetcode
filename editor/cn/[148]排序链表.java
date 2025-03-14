//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。 
//
// 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
// 
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
//
// Related Topics 链表 双指针 分治 排序 归并排序 👍 1952 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
    // 双指针
    public ListNode sortList(ListNode head) {
        if(head==null){
            return null;
        }
        ArrayList<ListNode> nodes = new ArrayList<>();
        
        while(head!=null){
            nodes.add(head);
            head = head.next;
        }
        Collections.sort(nodes, (o1,o2)->o1.val - o2.val);

        for(int i=1;i<nodes.size();i++){
            ListNode cur = nodes.get(i);
            ListNode pre = nodes.get(i-1);
            pre.next = cur;
        }
        nodes.get(nodes.size()-1).next = null;
        return nodes.get(0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
