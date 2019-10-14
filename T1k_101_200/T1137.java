package T1k_101_200;

public class T1137 {

//	泰波那契序列 Tn 定义如下： 
//	T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
//	给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
	
    public int tribonacci(int n) {
    	if(n<2)
    		return n;
    	else{
    		int T0 = 0;
    		int T1 = 1;
    		int T2 = 1;
    		
    		for(int i=n-3;i>=0;i--){
    			int temp = T2;
    			T2 = T2+T1+T0;
    			T0 = T1;
    			T1 = temp;
    		}
    		return T2;
    	}
    }
    
}
