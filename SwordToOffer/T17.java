package SwordToOffer;

public class T17 {

	
//	输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
	
	//其实应该考察大数相加 以及溢出的问题
	public int[] printNumbers(int n) {
        int num = (int)Math.pow(10, n) - 1;
        int[] res = new int[num];
        for(int i = 0; i < num; i++) res[i] = i + 1;
        return res;
	}
    
    
}
