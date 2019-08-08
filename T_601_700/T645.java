package T_601_700;

public class T645 {

//	集合 S 包含从1到 n 的整数,寻找丢失的整数以及重复的数
	
//	空间换时间，打表
//	其实在原数组上改也可以，不需要额外的空间
    public int[] findErrorNums(int[] nums) {
    	
        boolean[] exist = new boolean[nums.length+1];
        int[] ans = new int[2];
        for(int num:nums){
        	if(exist[num]){
        		ans[0]=num;
        	}
        	exist[num]=true;
        }
        
        for(int i=1;i<=nums.length;i++){
        	if(!exist[i])
        		ans[1]=i;
        }
        return ans;
    }
    
}
