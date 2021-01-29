package test;

import org.junit.Assert;
import org.junit.Test;

import T_801_900.T803;

public class Test801_900 {

	@Test
	public void testT803() {
		T803 t = new T803();
		int[][] grid = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 1, 0 } };

		int[][] hits = new int[][] { { 1, 0 } };
		int[] ans = new int[] { 2 };
		Assert.assertArrayEquals(ans, t.hitBricks(grid, hits));

		grid = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 0 } };
		hits = new int[][] { { 1, 1 }, { 1, 0 } };
		ans = new int[] { 0, 0 };
		Assert.assertArrayEquals(ans, t.hitBricks(grid, hits));

		grid = new int[][] { { 0, 1, 0, 0 }, { 0, 1, 0, 1 }, { 0, 1, 1, 1 } };
		hits = new int[][] { { 2, 2 }, { 1, 1 } };
		ans = new int[] { 2, 1 };
		Assert.assertArrayEquals(ans, t.hitBricks(grid, hits));

		grid = new int[][] { { 0, 1, 0, 0 }, { 0, 1, 0, 1 }, { 0, 1, 1, 1 } };
		hits = new int[][] { { 1, 1 } };
		ans = new int[] { 4 };
		Assert.assertArrayEquals(ans, t.hitBricks(grid, hits));

		grid = new int[][] { { 1 }, { 1 }, { 1 }, { 1 }, { 1 } };
		hits = new int[][] { { 3, 0 }, { 4, 0 }, { 1, 0 }, { 2, 0 }, { 0, 0 } };
		ans = new int[] { 1, 0, 1, 0, 0 };
		Assert.assertArrayEquals(ans, t.hitBricks(grid, hits));

		grid = new int[][] { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 0, 0 } };
		hits = new int[][] { { 0, 2 }, { 2, 0 }, { 0, 1 }, { 1, 2 } };
		ans = new int[] { 0, 0, 1, 0 };
		Assert.assertArrayEquals(ans, t.hitBricks(grid, hits));

	}
}
