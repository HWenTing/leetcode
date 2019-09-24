package T_201_300;

public class T263 {

//	编写一个程序判断给定的数是否为丑数。
//	丑数就是只包含质因数 2, 3, 5 的正整数。
	
    public boolean isUgly(int num) {
        if(num==0) return false;
        while(num%2==0){
        	num/=2;
        	if(num==1) return true;
        }
        
        while(num%3==0){
        	num/=3;
        	if(num==1) return true;
        }
        
        while(num%5==0){
        	num/=5;
        	if(num==1) return true;
        }
        return false;
    }
    
}
