package Other;

public class UnionFind {

	private int[] root;
	private int[] rank;// 记录树的高度

	public UnionFind(int n) {
		this.root = new int[n];
		this.rank = new int[n];
		for (int i = 0; i < n; i++) {
			root[i] = i;
			rank[i] = 1;
		}
	}

	public void union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);
		if (roota == rootb)
			return;

		if (rank[roota] == rank[rootb]) {// 如果roota、rootb的子树一样高，那么将rootb挂在roota上，rootb的高度+1
			root[rootb] = roota;
			rank[roota]++;
		} else if (rank[roota] < rank[rootb]) {// 如果roota的子树高度小于rootb的子树，那么将rootb挂在roota上，且rootb的高度不变
			root[roota] = rootb;
		} else {
			root[rootb] = roota;
		}

	}

	public int find(int x) {// 可以引入路径压缩,每次搜索，该搜索路径上的元素都直接挂在了根元素底下
		if (x != root[x]) {
			root[x] = find(root[x]);
		}
		return root[x];
	}

}
