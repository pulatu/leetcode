//给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 19 
// 
//
// Related Topics 树 二叉搜索树 数学 动态规划 二叉树 👍 2162 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 动态规划
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        // 边界条件，长度为0和1的二叉搜索树都只有1种
        dp[0] = 1;
        dp[1] = 1;

        // 状态转移方程为G(n)=
        //i=1
        //∑
        //n
        //​
        // G(i−1)⋅G(n−i)
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] += dp[j-1]*dp[i-j];
            }
        }

        return dp[n];
    }


}
//leetcode submit region end(Prohibit modification and deletion)
