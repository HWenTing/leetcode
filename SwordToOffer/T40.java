package SwordToOffer;

import java.util.Arrays;

public class T40 {
	
//	输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

	 
	
    public int[] getLeastNumbers(int[] arr, int k) {
    	
    	int[] ret = new int[k];
    	if(k==0) return ret;
    	int i=0;
    	for(;i<k;i++)
    		ret[i]=arr[i];
    	
    	Arrays.sort(ret);
    	for(;i<arr.length;i++){
    		if(arr[i]<ret[k-1]){
    			ret[k-1] = arr[i];
    			bulu(ret);
    		}
    	}
    	return ret;
    }

	private void bulu(int[] ret) {
		
		int temp = ret[ret.length-1];
		int i=ret.length-2;
		for(;i>=0;i--){
			if(temp>=ret[i])
				break;
			ret[i+1] = ret[i];
		}
		ret[i+1]=temp;
	}
    
}
