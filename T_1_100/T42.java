package T_1_100;

public class T42 {

    public static int trap(int[] height) {
    	
    	int len = height.length;
    	if(len==0)
    		return 0;
        int[] left = new int[len];
        int[] right = new int[len];
        
        left[0]=height[0];
        for(int i=1;i<len;i++){
        	left[i]=Math.max(left[i-1], height[i-1]);
        }
        
        right[len-1]=height[len-1];
        for(int i=len-2;i>=0;i--){
        	right[i]=Math.max(right[i+1], height[i+1]);
        }
        
        int ans=0;
        int step=0;
        for(int i=0;i<len;i++){
        	step = Math.min(right[i], left[i])-height[i];
        	ans+=Math.max(step, 0);
        }
        
        return ans;
    }
    
    public static void main(String[] args){
    	int[] candidates = {0,1,0,2,1,0,1,3,2,1,2,1};
    	
    	System.out.println(trap(candidates));
    }
    
    
}
