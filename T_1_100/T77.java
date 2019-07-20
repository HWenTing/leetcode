package T_1_100;
import java.util.ArrayList;
import java.util.List;
public class T77 {
	
    public List<List<Integer>> combine(int n, int k) {
        int[]  nums = new int[n];
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visit = new boolean[n];
        for(int i=0;i<n;i++)
        	nums[i] = i+1;
        getItem(0,k,nums,visit,res,new ArrayList<>());
        return res;
    }
    
    private void getItem(int cur,int k, int[] nums,boolean[] visit,List<List<Integer>> res,List<Integer> temp){
    	if(temp.size()==k){
    		res.add(new ArrayList<>(temp));
    		return;
    	}
    	for(int i=cur;i<nums.length;i++){
    		if(!visit[i]){
    			visit[i] = true;
    			temp.add(nums[i]);
    			getItem(i,k,nums,visit,res,temp);
    			temp.remove(temp.size()-1);
    			visit[i] = false;
    		}
    	}
    }
    
	public static void main(String[] args) {
		T77 t =new T77();
		System.out.println(t.combine(4, 2));

	}

}
