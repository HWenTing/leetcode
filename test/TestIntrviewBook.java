package test;

import org.junit.Assert;
import org.junit.Test;

import InterviewBook.T0101;
import InterviewBook.T0107;
import InterviewBook.T1001;

public class TestIntrviewBook {

	// @Test
	public void testT0101() {
		T0101 t = new T0101();
		Assert.assertFalse(t.isUnique("leetcode"));
		Assert.assertTrue(t.isUnique("abc"));
		Assert.assertTrue(t.isUnique(""));
		Assert.assertTrue(t.isUnique("!@#$%^&*("));
		Assert.assertTrue(t.isUnique("你好吗？"));
	}

	@Test
	public void testT0107() {
		T0107 t = new T0107();

		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] ans = new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } };
		t.rotate(matrix);
		Assert.assertArrayEquals(matrix, ans);

		matrix = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		ans = new int[][] { { 15, 13, 2, 5 }, { 14, 3, 4, 1 }, { 12, 6, 8, 9 }, { 16, 7, 10, 11 } };
		t.rotate(matrix);
		Assert.assertArrayEquals(matrix, ans);

		matrix = new int[][] { { 5, 1 }, { 2, 3 } };
		ans = new int[][] { { 2, 5 }, { 3, 1 } };
		t.rotate(matrix);
		Assert.assertArrayEquals(matrix, ans);

	}

	// @Test
	public void testT1001() {
		T1001 t = new T1001();
		int[] A = new int[] { 1, 2, 3, 0, 0, 0 };
		int[] B = new int[] { 2, 5, 6 };
		int[] C = new int[] { 1, 2, 2, 3, 5, 6 };
		int m = 3;
		int n = 3;
		t.merge(A, m, B, n);
		Assert.assertArrayEquals(C, A);
	}

}
