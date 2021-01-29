package T1k_201_NOW;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class T1202 {
	// 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0
	// 开始）。
	// 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
	// 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
	//
	// 并查集 下边这种方式超时了。。。

	//@formatter:off
//	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
//
//		char[] schar = s.toCharArray();
//
//		Map<Integer, List<Integer>> map = new HashMap<>();
//		int[] root = new int[s.length()];
//		for (int i = 0; i < root.length; i++)
//			root[i] = i;
//		for (List<Integer> pair : pairs)
//			union(pair, map, root);
//
//		for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
//			List<Integer> tempList = e.getValue();
//			char[] tempChar = new char[tempList.size()];
//			int[] tempInt = new int[tempList.size()];
//			for (int i = 0; i < tempList.size(); i++) {
//				tempInt[i] = tempList.get(i);
//				tempChar[i] = schar[tempInt[i]];
//			}
//			Arrays.sort(tempChar);
//			Arrays.sort(tempInt);
//			for (int i = 0; i < tempInt.length; i++) {
//				schar[tempInt[i]] = tempChar[i];
//			}
//		}
//		return new String(schar);
//
//	}
//
//	private void union(List<Integer> pair, Map<Integer, List<Integer>> map, int[] root) {
//		int r1 = findroot(pair.get(0), root);
//		int r2 = findroot(pair.get(1), root);
//		if (r1 != r2) {
//			root[r2] = r1;
//			if (!map.containsKey(r1)) {
//				List<Integer> temp = new LinkedList<>();
//				temp.add(r1);
//				map.put(r1, temp);
//			}
//			if (map.containsKey(r2)) {
//				map.get(r1).addAll(map.get(r2));
//				map.remove(r2);
//			} else {
//				map.get(r1).add(pair.get(1));
//			}
//		}
//	}
//
//	private int findroot(int i, int[] root) {
//		while (root[i] != i) {
//			i = root[i];
//		}
//		return i;
//	}
	//@formatter:on

	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {

		UnionFind uf = new UnionFind(s.length());
		for (List<Integer> pair : pairs) {
			uf.union(pair.get(0), pair.get(1));
		}

		Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
		char[] ss = s.toCharArray();

		for (int i = 0; i < s.length(); i++) {
			int rt = uf.find(i);
			if (rt != -1) {
				if (!map.containsKey(rt)) {
					map.put(rt, new PriorityQueue<>());
				}
				map.get(rt).add(s.charAt(i));
			}
		}

		for (int i = 0; i < s.length(); i++) {
			int rt = uf.find(i);
			if (rt != -1) {
				ss[i] = map.get(rt).poll();
			}
		}
		return new String(ss);
	}

	class UnionFind {

		private int[] root;
		private int[] rank;// 记录树的高度

		public UnionFind(int n) {
			this.root = new int[n];
			this.rank = new int[n];
			for (int i = 0; i < n; i++) {
				root[i] = -1;
				rank[i] = 1;
			}
		}

		private void union(int a, int b) {
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
			if (root[x] == -1)
				root[x] = x;

			if (x != root[x]) {
				root[x] = find(root[x]);
			}
			return root[x];
		}
	}

}
