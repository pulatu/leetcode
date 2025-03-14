//给定一个包含红色、白色和蓝色、共 n 个元素的数组
// nums ，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。 
//
// 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。 
//
// 
// 
//
// 必须在不使用库内置的 sort 函数的情况下解决这个问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,0,1]
//输出：[0,1,2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// nums[i] 为 0、1 或 2 
// 
//
// 
//
// 进阶： 
//
// 
// 你能想出一个仅使用常数空间的一趟扫描算法吗？ 
// 
//
// Related Topics 数组 双指针 排序 👍 1552 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 双指针（荷兰国旗问题）
    public void sortColors(int[] nums) {
        int n = nums.length;
        int l = 0, r = n-1;// 左右指针
        int p = 0;
        int temp = 0;
        while(p<=r){
            if(nums[p]>1){
                temp = nums[p];
                nums[p] = nums[r];
                nums[r] = temp;
                r--;
            }
            else if(nums[p]<1){
                temp = nums[p];
                nums[p] = nums[l];
                nums[l] = temp;
                l++;
                p++;
            }
            else p++;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
