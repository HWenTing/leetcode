package T_801_900;

public class T852 {

//	找最大值下标 二分搜索
    public int peakIndexInMountainArray(int[] A) {
        
    	int left=0;
    	int right=A.length-1;
    	int mid;
    	while(true){
    		mid =left+(right-left)/2;
    		if(A[mid]>A[mid+1] && A[mid]>A[mid-1])
    			return mid;
    		else if(A[mid]<=A[mid+1]){
    			left=mid;
    		}else{
    			right=mid;
    		}
    	}
    }
    
}
