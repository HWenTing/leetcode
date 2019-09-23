package T_1_100;

public class T88 {

//	给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
	
//	从后往前赋值
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        
    	for(int i=nums1.length-1;i>=0;i--){
    		if(n<0)
    			break;
    		else if(m<0){
    			nums1[i]=nums2[n];
    			n--;
    		}else{
        		if(nums1[m]<=nums2[n]){
        			nums1[i]=nums2[n];
        			n--;
        		}else{
        			nums1[i]=nums1[m];
        			m--;
        		}
    		}

    	}
    }
    
    
}
