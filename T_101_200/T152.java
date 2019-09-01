package T_101_200;

public class T152 {

//	给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
//	存最大值和最小值
	
//	速度击败99%
//    public int maxProduct(int[] nums) {
//        int len =nums.length;
//        
//        int[] dpmax = new int[len];
//        int[] dpmin = new int[len];
//        dpmax[0] = dpmin[0]=nums[0];
//        
//        for(int i=1;i<len;i++){
//        	int tempmax = nums[i]*dpmax[i-1];
//        	int tempmin = nums[i]*dpmin[i-1];
//        	
//        	dpmax[i] = Math.max(tempmax, tempmin);
//       		dpmax[i] = Math.max(nums[i], dpmax[i]);
//        	
//       		dpmin[i] = Math.min(tempmax, tempmin);
//       		dpmin[i] = Math.min(nums[i], dpmin[i]);
//       		
//        }
//        
//        int ans=nums[0];
//        for(int i:dpmax)
//        	ans = Math.max(ans, i);
//        
//        return ans;
//    }
    
//	优化空间
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){ //小于0交换
              int tmp = imax;
              imax = imin;
              imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            
            max = Math.max(max, imax);
        }
        return max;
    }


    
}
