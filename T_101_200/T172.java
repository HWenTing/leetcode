package T_101_200;

public class T172 {

//错误 n=30, 应该是7
//    int trailingZeroes(int n) {
//    	return n/5;
//    }
   
//	正确  在举出几个例子以后进行观察比较好
//	一个5就对应了一个0
	
	int trailingZeroes(int n) {
		int ans=0;
		while(n>=5){
			ans +=n/5;
			n=n/5;
		}
		return ans;
	}
	
    public static void main(String [] args){
    	T172 t = new T172();
    	System.out.println(t.trailingZeroes(124));
    }
}
