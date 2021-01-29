package T_501_600;

public class T547_2 {

	/**
	 * 有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c
	 * 间接相连。 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。 给你一个 n x n 的矩阵 isConnected ，其中
	 * isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0
	 * 表示二者不直接相连。 返回矩阵中 省份 的数量。
	 */

	/*
	 * 并查集
	 */
	public int findCircleNum(int[][] isConnected) {
		int[] roots = new int[isConnected.length];
		for (int i = 0; i < roots.length; i++)
			roots[i] = i;

		union(isConnected, roots);

		int ans = 0;
		for (int i = 0; i < roots.length; i++)
			if (roots[i] == i)
				ans++;
		return ans;
	}

	private void union(int[][] isConnected, int[] roots) {
		int n = roots.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (isConnected[i][j] == 1)
					add(roots, i, j);
			}
		}
	}

	private void add(int[] roots, int i, int j) {
		int iroot = findroot(roots, i);
		int jroot = findroot(roots, j);
		roots[jroot] = iroot;
	}

	private int findroot(int[] roots, int i) {
		while (i != roots[i])
			i = roots[i];
		return i;
	}

}
