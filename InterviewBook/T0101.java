package InterviewBook;

public class T0101 {

	/**
	 * 确定一个字符串 s 的所有字符是否全都不同。 不使用额外的数据结构
	 * 
	 * 使用位运算 能节省很多空间 long 有64位，long[16]可以标记64*16位。可以根据需要来
	 */
	public boolean isUnique(String astr) {
		long[] bits = new long[8 * 256];

		for (char c : astr.toCharArray()) {
			int box = c / 64;
			int bias = c % 64;
			if ((bits[box] & (1L << bias)) > 0)
				return false;
			else
				bits[box] |= (1L << bias);
		}
		return true;
	}

}
