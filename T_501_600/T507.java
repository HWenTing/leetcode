package T_501_600;

public class T507 {
	
//	感觉时间复杂度很高，便利1到num/2
//	果然超时了
//    public boolean checkPerfectNumber(int num) {
//    	int temp=0;
//        for(int i=1;i<=num/2;i++){
//        	if(num%i==0){
//        		temp+=i;
//        	}
//        }
//        if(temp==num)
//        	return true;
//        return false;
//    }
    
    
//	借鉴上边的想法，在循环时不断缩小上界
//	好像这个想法很蠢。。。上界直接取num的平方根就好了。。。
    public boolean checkPerfectNumber(int num) {
    	if(num<3)
    		return false;
    	int temp=1;
    	int max = num/2;
	    for(int i=2;i<max;i++){
	      	if(num%i==0){
	      		temp+=i;
	      		temp+=num/i;
	      		max=num/i;
	      	}
	    }
	    if(temp==num)
	      	return true;
	    return false;
    }
    
    
    public static void main(String[] args){
    	T507 t =new T507();
    	System.out.println(t.checkPerfectNumber(28));
    }
}
