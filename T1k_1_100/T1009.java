package T1k_1_100;

public class T1009 {

//	十进制整数的反码
	
//	相加等于2^n-1
    public int bitwiseComplement(int N) {
    	if(N==0) return 1;
        int temp = N;
        int two=1;
        while(temp>0){
        	temp=temp>>>1;
        	two=two<<1;
        }
        return two-N-1;
    }
    
}
