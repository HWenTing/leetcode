package T_301_400;

public class T376 {

	//可以考虑有几个尖
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n<=1)
        	return n;
        
        int lowtohigh = 1;
        int hightolow = 1;
        
        for(int i=1;i<n;i++){
        	if(nums[i]<nums[i-1])//如果连续两个降低，hightolow的值并不会变
        		hightolow = lowtohigh+1;
        	else if(nums[i]>nums[i-1])
        		lowtohigh = hightolow+1;
        }
        
        return Math.max(lowtohigh, hightolow);
    }
    
    
	public static void main(String[] args) {
		T376 t = new T376();
		System.out.println(t.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
		
	}

}
