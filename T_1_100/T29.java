package T_1_100;

public class T29 {
	
    public static int divide(int dividend, int divisor) {
    	int ans=0;
    	int temp = dividend;

    	if(dividend>0&&divisor>0){
        	while(temp>=0){
        		ans++;
        		temp-=divisor;
        	}
        	return ans-1;
        }else if(dividend>0&&divisor<0){
        	while(temp>=0){
        		ans++;
        		temp+=divisor;
        	}
        	return -(ans-1);
        }
	    else if(dividend<0&&divisor>0){
	    	while(temp<=0){
	    		ans++;
	    		temp+=divisor;
	    	}
	    	return -(ans-1);
	    }
	    else if(dividend<0&&divisor<0){
	    	
	    	if(dividend+1==-2147483647&&divisor==-1){
	    		return Integer.MAX_VALUE;
	    	}
	    	
	    	if(dividend+1==-2147483647){
	    		dividend=dividend+1;
	    	}
        	while(temp<=0){
        		ans++;
        		temp-=divisor;
        	}
        	return ans-1;
	    }
        
        return 0;
    }
    
    public static void main(String[] args){
    	System.out.println(divide(-2147483648,-2));
    }
}
