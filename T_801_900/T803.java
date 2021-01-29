package T_801_900;

public class T803 {

	// 有一个 m x n 的二元网格，其中 1 表示砖块，0 表示空白。砖块 稳定（不会掉落）的前提是：
	// 一块砖直接连接到网格的顶部，或者
	// 至少有一块相邻（4 个方向之一）砖块 稳定 不会掉落时
	// 给你一个数组 hits ，这是需要依次消除砖块的位置。每当消除 hits[i] = (rowi, coli)
	// 位置上的砖块时，对应位置的砖块（若存在）会消失，然后其他的砖块可能因为这一消除操作而掉落。一旦砖块掉落，它会立即从网格中消失（即，它不会落在其他稳定的砖块上）。
	// 返回一个数组 result ，其中 result[i] 表示第 i 次消除操作对应掉落的砖块数目。
	// 注意，消除可能指向是没有砖块的空白位置，如果发生这种情况，则没有砖块掉落。

	// 并查集
	private int row, col;

	public int[] hitBricks(int[][] grid, int[][] hits) {
		int[] ans = new int[hits.length];

		for (int[] hit : hits) {
			if (grid[hit[0]][hit[1]] == 1)
				grid[hit[0]][hit[1]] = 0;
			else
				grid[hit[0]][hit[1]] = 2;
		}

		row = grid.length;
		col = grid[0].length;
		int size = row * col;
		UnionFind uf = new UnionFind(size + 1);

		for (int i = 0; i < col; i++) {
			if (grid[0][i] == 1)
				uf.union(size, getIndex(0, i));
		}

		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 1) {
					if (grid[i - 1][j] == 1)
						uf.union(getIndex(i - 1, j), getIndex(i, j));
					if (j > 0 && grid[i][j - 1] == 1)
						uf.union(getIndex(i, j - 1), getIndex(i, j));
				}
			}
		}

		for (int i = hits.length - 1; i >= 0; i--) {
			int before = uf.getSize(size);
			int[] cur = hits[i];
			if (grid[cur[0]][cur[1]] == 2)
				continue;

			if (cur[0] == 0)
				uf.union(size, getIndex(cur[0], cur[1]));
			else if (grid[cur[0] - 1][cur[1]] == 1)
				uf.union(getIndex(cur[0] - 1, cur[1]), getIndex(cur[0], cur[1]));
			if (cur[1] > 0 && grid[cur[0]][cur[1] - 1] == 1)
				uf.union(getIndex(cur[0], cur[1] - 1), getIndex(cur[0], cur[1]));
			if (cur[1] < col - 1 && grid[cur[0]][cur[1] + 1] == 1)
				uf.union(getIndex(cur[0], cur[1]), getIndex(cur[0], cur[1] + 1));
			if (cur[0] < row - 1 && grid[cur[0] + 1][cur[1]] == 1)
				uf.union(getIndex(cur[0], cur[1]), getIndex(cur[0] + 1, cur[1]));

			ans[i] = Math.max(uf.getSize(size) - before - 1, 0);
			grid[cur[0]][cur[1]] = 1;
		}

		return ans;
	}

	private int getIndex(int i, int i2) {
		return i * col + i2;
	}

	class UnionFind {

		private int[] root;
		private int[] rank;// 记录树的高度
		private int[] size;

		public UnionFind(int n) {
			this.root = new int[n];
			this.rank = new int[n];
			this.size = new int[n];
			for (int i = 0; i < n; i++) {
				root[i] = i;
				rank[i] = 1;
				size[i] = 0;
			}
		}

		public void union(int a, int b) {
			int roota = find(a);
			int rootb = find(b);
			if (roota == rootb)
				return;

			if (rank[roota] == rank[rootb]) {
				root[rootb] = roota;
				rank[roota]++;
				size[roota] += (size[rootb] + 1);
			} else if (rank[roota] < rank[rootb]) {
				root[roota] = rootb;
				size[rootb] += (size[roota] + 1);
			} else {
				root[rootb] = roota;
				size[roota] += (size[rootb] + 1);
			}
		}

		public int find(int x) {
			if (x != root[x]) {
				root[x] = find(root[x]);
			}
			return root[x];
		}

		public int getSize(int i) {
			return size[find(i)];
		}
	}

}
