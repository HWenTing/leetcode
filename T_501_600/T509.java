package T_501_600;

public class T509 {

//	斐波那契数列
    public int fib(int N) {
    	if(N<2) return N;
        int a=0;
        int b=1;
        while(N>1){
        	int temp = b;
        	b=a+b;
        	a=temp;
        	N--;
        }
        return b;
    }
}
