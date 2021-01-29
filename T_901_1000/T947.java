package T_901_1000;

import java.util.HashMap;

public class T947 {

	// n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。
	// 如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。
	// 给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子
	// 的最大数量。

	// 并查集
	public int removeStones(int[][] stones) {
		int len = stones.length;

		UnionFind uf = new UnionFind(len);
		HashMap<Integer, Integer> mapx = new HashMap<>();
		HashMap<Integer, Integer> mapy = new HashMap<>();

		for (int i = 0; i < len; i++) {
			if (mapx.containsKey(stones[i][0])) {
				uf.union(mapx.get(stones[i][0]), i);
			}
			if (mapy.containsKey(stones[i][1])) {
				uf.union(mapy.get(stones[i][1]), i);
			}
			mapx.put(stones[i][0], i);
			mapy.put(stones[i][1], i);
		}
		return len - uf.getDistinctCnt();
	}

	class UnionFind {

		private int[] root;
		private int[] rank;// 记录树的高度
		private int distinctCnt;

		public UnionFind(int n) {
			this.root = new int[n];
			this.rank = new int[n];
			for (int i = 0; i < n; i++) {
				root[i] = i;
				rank[i] = 1;
			}
			this.distinctCnt = n;
		}

		public void union(int a, int b) {
			int roota = find(a);
			int rootb = find(b);
			if (roota == rootb)
				return;

			if (rank[roota] == rank[rootb]) {
				root[rootb] = roota;
				rank[roota]++;
			} else if (rank[roota] < rank[rootb]) {
				root[roota] = rootb;
			} else {
				root[rootb] = roota;
			}
			distinctCnt--;
		}

		public int find(int x) {
			if (x != root[x]) {
				root[x] = find(root[x]);
			}
			return root[x];
		}

		public int getDistinctCnt() {
			return distinctCnt;
		}
	}

}
