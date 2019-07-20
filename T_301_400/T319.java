package T_301_400;

public class T319 {
////	暴力模拟，超出时间限制 复杂度n^2
//    public int bulbSwitch(int n) {
//    	int ans=0;
//        for(int i=1;i<=n;i++){
//        	int temp=0;
//        	for(int j=1;j<=i;j++){
//        		if(i%j==0)
//        			temp++;
//        	}
//        	if(temp%2==1)
//        		ans++;
//        }
//        return ans;
//    }
    

//	从1到n，如果i有奇数个因子，则true，偶数个则false.超出时间限制. 复杂度n的3/2次方
//    public int bulbSwitch(int n) {
//    	int ans=0;
//        for(int i=1;i<=n;i++){
//        	if(check(i))
//        		ans++;
//        }
//        return ans;
//    }
//    public  boolean check(int n){
//    	int count=0;
//    	for(int i=1;i<=Math.sqrt(n);i++){
//    		if(n%i==0){
//    			if(Math.pow(n/i, 2)==n)
//    				count+=1;
//    			else
//    				count+=2;
//    		}
//    	}
//    	if(count%2==1)
//    		return true;
//    	else
//    		return false;
//    }
 
//	...这就是个数学题吧。。。。  因为任何数都能分解成连个数的乘积，只有是平方数的时候才是奇数个因子
    public int bulbSwitch(int n) {
        return (int) Math.floor(Math.sqrt(n));
    }
	
	
    public static void main(String[] args){
    	T319 t =new T319();
    	System.out.println(t.bulbSwitch(4));
    }
}
