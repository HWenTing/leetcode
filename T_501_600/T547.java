package T_501_600;

public class T547 {

	/**
	 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c
	 * 间接相连。 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 给你一个 n x n 的矩阵 isConnected ，其中
	 * isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0
	 * 表示二者不直接相连。 返回矩阵中 省份 的数量。
	 */
	// 这个题和之前的岛屿问题不大一样，这个有传递性

	public int findCircleNum(int[][] M) {
		int N = M.length;
		boolean[] marked = new boolean[N];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			if (!marked[i]) {
				ans++;
				dfs(M, marked, i);
			}
		}
		return ans;
	}

	private void dfs(int[][] M, boolean[] marked, int pos) {

		marked[pos] = true;
		for (int j = 0; j < marked.length; j++) {
			if (M[pos][j] == 1 && !marked[j]) {
				dfs(M, marked, j);
			}
		}
	}

	public static void main(String[] args) {
		T547 t = new T547();
		int[][] grid = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1 }, { 1, 0, 1, 1 } };

		System.out.println(t.findCircleNum(grid));
	}
}
