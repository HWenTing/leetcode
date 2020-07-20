package SwordToOffer;

public class T43 {

//	输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//	例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
//	同T233
	
    public int countDigitOne(int n) {
    	int ans = 0;
    	int pos = 1;
    	int cur = n;
    	while(cur>0){
    		if(cur%10==0){
    			ans+=(cur/10)*pos;
    		}else if(cur%10==1){
    			ans+=(cur/10)*pos+n%pos+1;
    		}else{
    			ans+=(cur/10+1)*pos;
    		}
    		pos*=10;
    		cur/=10;
    	}
    	return ans;
    }
    
     
    
}
