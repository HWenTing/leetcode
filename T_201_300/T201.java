package T_201_300;

public class T201 {

//	给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
//	直接遍历就没啥意思
//	可以求最长共同前缀
    public int rangeBitwiseAnd(int m, int n) {
    	int shift = 0;
    	while(m<n){
    		m >>= 1;
    		n >>= 1;
    		shift++;
    	}
    	return m<<shift;
    }
    
   
}
