package T1k_201_NOW;

import java.util.Comparator;
import java.util.PriorityQueue;

public class T1584 {

	// 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
	// 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi -
	// yj| ，其中 |val| 表示 val 的绝对值。
	// 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。

	// 最小生成树
	public int minCostConnectPoints(int[][] points) {
		int len = points.length;
		PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.dis - o2.dis;
			}
		});

		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j < len; j++) {
				pq.add(new Pair(Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]), i, j));
			}
		}

		UnionFind uf = new UnionFind(len);
		int ans = 0;
		int cnt = 0;
		while (!pq.isEmpty() && cnt < len - 1) {
			Pair p = pq.poll();
			if (uf.union(p.p1, p.p2)) {
				cnt++;
				ans += p.dis;
			}
		}
		return ans;
	}

	class Pair {
		int dis;
		int p1, p2;

		public Pair(int dis, int p1, int p2) {
			super();
			this.dis = dis;
			this.p1 = p1;
			this.p2 = p2;
		}
	}

	class UnionFind {
		int[] root;
		int[] rank;

		public UnionFind(int len) {
			root = new int[len];
			rank = new int[len];
			for (int i = 0; i < len; i++) {
				root[i] = i;
				rank[i] = 1;
			}
		}

		public boolean union(int i, int j) {
			int rooti = find(i);
			int rootj = find(j);

			if (rooti == rootj)
				return false;

			if (rank[rooti] < rank[rootj]) {
				root[rooti] = rootj;
			} else if (rank[rooti] > rank[rootj]) {
				root[rootj] = rooti;
			} else {
				root[rooti] = rootj;
				rank[rootj]++;
			}
			return true;
		}

		public int find(int i) {
			if (root[i] != i)
				root[i] = find(root[i]);
			return root[i];
		}
	}
}
