//在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。 
//
// 
//
// 示例 1： 
// 
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：4
// 
//
// 示例 2： 
// 
// 
//输入：matrix = [["0","1"],["1","0"]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 300 
// matrix[i][j] 为 '0' 或 '1' 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 1411 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 动态规划
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int maxSide = 0;// 最大边长

        // 状态转移方程为dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(matrix[i][j]=='1'){
                   if(i==0||j==0) {
                        dp[i][j] = 1;
                   }
                   else {
                       dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                   }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
