package InterviewBook;

public class T1001 {

	/**
	 * 
	 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 初始化 A 和 B
	 * 的元素数量分别为 m 和 n。
	 * 
	 * 双指针
	 */
	public void merge(int[] A, int m, int[] B, int n) {

		int pos = m + n - 1;
		int ptrB = n - 1;
		int ptrA = m - 1;
		while (ptrA >= 0 && ptrB >= 0) {
			if (A[ptrA] >= B[ptrB]) {
				A[pos--] = A[ptrA--];
			} else
				A[pos--] = B[ptrB--];
		}

		while (ptrB >= 0) {// 说明A已经落位完成，只需要将B填入A开端
			A[pos--] = B[ptrB--];
		}

	}

}
