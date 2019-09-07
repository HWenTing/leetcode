package T_1001;

import java.util.LinkedList;
import java.util.List;

public class T1104 {
	
	
//	一路除下来，然后再隔层修改
    public List<Integer> pathInZigZagTree(int label) {
    	List<Integer> ans = new LinkedList<>();
    	
        while(label>0){
        	ans.add(0,label);
        	label/=2;
        }
        
        for(int i=ans.size()-2;i>=0;i=i-2){//从倒数第二层开始，隔一层修改一次，newnum = 2^(layer) + 2^(layer+1)-1-oldnum
        	int former = ans.get(i);
        	int now = (int) (Math.pow(2, i)+Math.pow(2, i+1)-1-former);
        	ans.set(i, now);
        }
        return ans;
    }
}
