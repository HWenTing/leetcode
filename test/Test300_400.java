package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import T_301_400.T316;

public class Test300_400 {

	@Test
	public void t316() {
		T316 t = new T316();
		assertEquals("abc", t.removeDuplicateLetters("bcabc"));
		assertEquals("acdb", t.removeDuplicateLetters("cbacdcbc"));
		assertEquals("bac", t.removeDuplicateLetters("bbcaac"));
		assertEquals("basfgvdc", t.removeDuplicateLetters("baasfggvfdc"));
	}

}
