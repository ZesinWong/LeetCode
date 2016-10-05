/**
 * @version 1.0
 * @date    2016年10月5日
 * @author  ZesinWong@gmail.com
 * 思路：遍历二维数组，判断每个细胞的下一代的存活情况，
 *       用新的二维数组记录下一代细胞的状态，注意边界
 *       溢出。
 */

public class Solution {
	public void gameOfLife(int[][] board) {
		int m = board.length;
		int n = board[0].length;
		int[][] next = new int[m][n];
		for (int i = 0; i != m; ++i)
			for (int j = 0; j != n; ++j) {
				int count = 0;
				// 记录周围细胞存活情况
				if (i > 0 && j > 0 && 1 == board[i - 1][j - 1])
					count += 1;
				if (i > 0 && 1 == board[i - 1][j])
					count += 1;
				if (i > 0 && j < n - 1 && 1 == board[i - 1][j + 1])
					count += 1;
				if (j > 0 && 1 == board[i][j - 1])
					count += 1;
				if (j < n - 1 && 1 == board[i][j + 1])
					count += 1;
				if (i < m - 1 && j > 0 && 1 == board[i + 1][j - 1])
					count += 1;
				if (i < m - 1 && 1 == board[i + 1][j])
					count += 1;
				if (i < m - 1 && j < n - 1 && 1 == board[i + 1][j + 1])
					count += 1;
				// 判断下一代细胞状态
				if (count == 3 || (count == 2 && board[i][j] == 1))
					next[i][j] = 1;
				else
					next[i][j] = 0;
			}
		for (int i = 0; i != m; ++i)
			for (int j = 0; j != n; ++j)
				board[i][j] = next[i][j];
	}
}
