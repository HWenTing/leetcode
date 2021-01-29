package T_501_600;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class T587 {

	/*
	 * 在一个二维的花园中，有一些用 (x, y)
	 * 坐标表示的树。由于安装费用十分昂贵，你的任务是先用最短的绳子围起所有的树。只有当所有的树都被绳子包围时，花园才能围好栅栏。
	 * 你需要找到正好位于栅栏边界上的树的坐标。
	 * 
	 * 凸包问题 Graham扫描法
	 */
	public int[][] outerTrees(int[][] points) {
		if (points.length <= 2)
			return points;

		int[] first = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };// y坐标最低的点
		for (int i = 0; i < points.length; i++) {
			if (points[i][1] < first[1]) {
				first[0] = points[i][0];
				first[1] = points[i][1];
			} else if (points[i][1] == first[1])
				first[0] = Math.min(points[i][0], first[0]);
		}

		Arrays.sort(points, new Comparator<int[]>() {// 计算各个点相对于 P0 的幅角 α
			// ，按从小到大的顺序对各个点排序
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == first[1] && o2[1] == first[1])// 与基准点水平
					return o1[0] > o2[0] ? 1 : -1;
				if (o1[1] == first[1] || o2[1] == first[1])
					return o1[1] == first[1] ? -1 : 1;

				if ((o1[0] - first[0]) * (o2[0] - first[0]) < 0)// 在基准点两侧
					return o1[0] > o2[0] ? -1 : 1;

				double a1 = o1[0] == first[0] ? 0 : (o1[1] - first[1]) / (double) (o1[0] - first[0]);
				double a2 = o2[0] == first[0] ? 0 : (o2[1] - first[1]) / (double) (o2[0] - first[0]);

				if (a1 == 0 && a2 == 0)// 从上向下
					return o1[1] > o2[1] ? -1 : 1;
				else if (a1 == 0 || a2 == 0)
					return o1[0] > o2[0] ? -1 : 1;
				if (new Double(a1).compareTo(new Double(a2)) == 0) {
					return o1[0] - o2[0];// 从左到右
				}
				return new Double(a1).compareTo(new Double(a2));
			}
		});

		if (points[0][0] == points[1][0]) {// 解决特殊情况
											// 如果若干个点与基准点x坐标相同，那么有可能需要从上到下遍历，也可能从下到上，默认时从上到下，这里处理特殊情况
			int i = 1;
			while (i < points.length && points[0][0] == points[i][0])
				i++;
			i--;

			int l = 1;
			while (l < i) {
				int[] temp = points[l];
				points[l] = points[i];
				points[i] = temp;
				i--;
				l++;
			}
		}

		Stack<int[]> st = new Stack<>();
		st.push(points[0]);
		st.push(points[1]);
		for (int i = 2; i <= points.length; i++) {
			int pos = i % points.length;
			if (onTheRight(points[pos], st.elementAt(st.size() - 2), st.elementAt(st.size() - 1))) {
				st.pop();
				i--;
			} else {
				st.add(points[pos]);
			}
		}
		st.pop();

		List<int[]> ans = new ArrayList<>(st.size());
		for (int[] i : st)
			ans.add(i);
		Collections.sort(ans, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (new Double(o1[0]).compareTo(new Double(o2[0])) == 0) {
					return new Double(o1[1]).compareTo(new Double(o2[1]));
				}
				return new Double(o1[0]).compareTo(new Double(o2[0]));
			}
		});

		return ans.toArray(new int[0][0]);
	}

	private static boolean onTheRight(int[] ds, int[] o1, int[] o2) {
		int x1 = o1[0], y1 = o1[1];
		int x2 = o2[0], y2 = o2[1];
		int x3 = ds[0], y3 = ds[1];

		return x1 * y2 + x3 * y1 + x2 * y3 - x3 * y2 - x2 * y1 - x1 * y3 < 0;
	}

}
