package test;

import java.util.Arrays;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import T_901_1000.T912;

public class Test901_1000 {

	@Test
	public void testT912() {
		T912 t = new T912();
		Random r = new Random();

		long begintime = System.currentTimeMillis();
		int total = 10;
		for (int j = 0; j < total; j++) {
			// int len = r.nextInt(10000);
			int len = 10000;
			System.out.println(len);
			int[] nums = new int[len];
			for (int i = 0; i < len; i++)
				nums[i] = r.nextInt(1000000) - 500000;
			int[] sort = Arrays.copyOf(nums, nums.length);
			Arrays.sort(sort);
			Assert.assertArrayEquals(sort, t.sortArray(nums));
		}
		long endtime = System.currentTimeMillis();
		System.out.println((endtime - begintime) / (double) total + " ms");

	}

}
