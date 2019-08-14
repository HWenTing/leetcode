package T_401_500;

public class T461 {

//	两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
//	给出两个整数 x 和 y，计算它们之间的汉明距离。
	
//	异或一下，找1的个数
//	击败99.3%
    public int hammingDistance(int x, int y) {
        int temp = x^y;
        return Integer.bitCount(temp);
    }
    
}
