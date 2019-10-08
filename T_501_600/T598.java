package T_501_600;

public class T598 {

//	给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
//	操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。
//	在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
	
	
	
//	找最小a 最小b 乘起来
    public int maxCount(int m, int n, int[][] ops) {
    	int mina = m;
    	int minb = n;
    	
        for(int[] pair:ops){
        	mina=Math.min(pair[0], mina);
        	minb=Math.min(pair[1], minb);
        }
        return mina*minb;
    }
	
}
