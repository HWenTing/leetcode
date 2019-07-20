package T_101_200;

public class T198 {
//D[N] = MAX(D[n-2]+a[n],D[n-1])
    public int rob(int[] nums) {
    	
    	int n = nums.length;
    	if(n==0)
    		return 0;
    	if(n==1)
    		return nums[0];
    	
    	int pre2 = nums[0];
    	int pre1 = Math.max(nums[0], nums[1]);
    	int cur = pre1;
    	for(int i=2;i<n;i++){
    		
    		cur = Math.max(pre1, pre2+nums[i]);
    		pre2 = pre1;
    		pre1 = cur;
    		
    	}
    	return cur;
        
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T198 t = new T198();
		
		System.out.println(t.rob(new int[]{1,2,3,1}));
	}

}
