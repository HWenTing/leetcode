package T_1_100;

public class T69 {
    public int mySqrt(int x) {
    	if(x<=1){
    		return x;
    	}
        int l = 1 ;
        int h = x;
        int sqrt=0;
        while(l<=h){
        	int mid = l+(h-l)/2;
        	sqrt = x/mid;
        	if(mid==sqrt){
        		return sqrt;
        	}else if(mid>sqrt){
        		h = mid-1;
        	}else{
        		l = mid+1;
        	}
        }
        return h;
    }
    public static void main(String[] args){
    	T69 t = new T69();
    	for(int i=0;i<20;i++){
    		System.out.println(t.mySqrt(i));
    	}
    	
    }
}
