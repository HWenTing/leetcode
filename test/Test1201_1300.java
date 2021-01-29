package test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import T1k_201_NOW.T1202;

public class Test1201_1300 {

	@Test
	public void test() {
		T1202 t = new T1202();
		String s = "udyyek";
		List<List<Integer>> pairs = new LinkedList<List<Integer>>() {
			{
				add(Arrays.asList(3, 3));
				add(Arrays.asList(3, 0));
				add(Arrays.asList(5, 1));
				add(Arrays.asList(3, 1));
				add(Arrays.asList(3, 4));
				add(Arrays.asList(3, 5));
			}
		};
		Assert.assertEquals(t.smallestStringWithSwaps(s, pairs), "deykuy");

		s = "dcab";
		pairs = new LinkedList<List<Integer>>() {
			{
				add(Arrays.asList(0, 3));
				add(Arrays.asList(1, 2));
			}
		};
		Assert.assertEquals(t.smallestStringWithSwaps(s, pairs), "bacd");

		s = "dcab";
		pairs = new LinkedList<List<Integer>>() {
			{
				add(Arrays.asList(0, 3));
				add(Arrays.asList(1, 2));
				add(Arrays.asList(0, 2));
			}
		};
		Assert.assertEquals(t.smallestStringWithSwaps(s, pairs), "abcd");

	}

}
