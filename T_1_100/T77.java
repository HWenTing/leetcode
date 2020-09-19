package T_1_100;
import java.util.LinkedList;
import java.util.List;
public class T77 {
	
//	给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

	private List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
    	ans = new LinkedList<>();
    	item(n,k,0,new LinkedList<Integer>());
    	return ans;
    }
    
    private void item(int n, int k,int start, List<Integer> cur){
    	if(k==0){
    		ans.add(new LinkedList<>(cur));
    		return;
    	}
    	
    	for(int i=start+1;i+k-1<=n;i++){
    		cur.add(i);
    		item(n,k-1,i,cur);
    		cur.remove(cur.size()-1);
    	}
    }
}
