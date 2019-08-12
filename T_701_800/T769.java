package T_701_800;

public class T769 {

	
//	从右向左，最小值决定了该区间的前端点，如果这个区间内右更小的值，则更新前端点，到达前端点则ans++
//	！！！ 击败了100%！！！
    public int maxChunksToSorted(int[] arr) {
        
    	int len = arr.length;
    	int pos = len-1;
    	int ans = 0; 
    	for(int i=len-1;i>=0;i--){
    		pos=Math.min(pos, arr[i]);
    		if(i<=pos)
    			ans++;
    	}
    	return ans;
    }
    
}
