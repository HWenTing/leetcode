package T_901_1000;

public class T941 {

//	判断是否为山脉
	
//	设置上山下山标志
    public boolean validMountainArray(int[] A) {
    	if(A.length<3 || A[0]>=A[1]) return false;
    	boolean up=true;
    	for(int i=1;i<A.length;i++){
    		if(up){
    			if(A[i]-A[i-1]<0){
    				up=false;
    			}else if(A[i]-A[i-1]==0)
    				return false;
    		}else{
    			if(A[i]-A[i-1]>=0)
    				return false;
    		}
    	}
    	return !up;
    }
    
}





