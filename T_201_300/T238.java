package T_201_300;

public class T238 {

//	第一反应是求出总的积，然后分别除以每个元素
//	但要求不要使用除法，且在 O(n) 时间复杂度内完成此题
//	可以分两部分，before 和 after  n的时间复杂度，n的空间复杂度
//    public int[] productExceptSelf(int[] nums) {
//    	int len =nums.length;
//    	int []before = new int[len];
//    	int []after = new int[len];
//    	before[0]=1;
//        for(int i=1;i<len;i++){//before
//        	before[i]=before[i-1]*nums[i-1];
//        }
//        
//        after[len-1]=1;
//        for(int i=len-2;i>=0;i--){//after
//        	after[i]=after[i+1]*nums[i+1];
//        }
//        
//        for(int i=0;i<len;i++){//before*after
//        	nums[i] = before[i]*after[i];
//        }
//        return nums;
//    }
    
   
//	1的空间复杂度。。。。竟然没怎么变
//    public int[] productExceptSelf(int[] nums) {
//    	int len =nums.length;
//    	int []ans = new int[len];
//    	ans[0]=1;
//        
//        int temp=1;//使用临时变量来代替数组
//        for(int i=1;i<len;i++){//before
//        	ans[i] = 1;
//        	temp*=nums[i-1];
//        	ans[i]*=temp;
//        }
//        
//        temp=1;
//        for(int i=len-2;i>=0;i--){//after
//        	temp*=nums[i+1];
//        	ans[i]*=temp;
//        }
//        
//        return ans;
//    }
    
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= nums[i], i++)       /* 从左往右累乘 */
            B[i] = product;
        for (int i = n - 1, product = 1; i >= 0; product *= nums[i], i--)  /* 从右往左累乘 */
            B[i] *= product;
        return B;
    }
    
	public static void main(String[] args) {
		T238 t =new T238();
		int []nums=new int[]{1,2,3,4};
		nums = t.productExceptSelf(nums);
		for(int i:nums){
			System.out.print(i+" ");
		}
	}

}
