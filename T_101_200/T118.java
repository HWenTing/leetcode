package T_101_200;

import java.util.LinkedList;
import java.util.List;

public class T118 {

//	给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> ans = new LinkedList<>();
    	ans.add(new LinkedList<>());//为了后边统一处理，加入假节点
        for(int i=0;i<numRows;i++){
        	List<Integer> temp = new LinkedList<>();
        	List<Integer> last = ans.get(ans.size()-1); 
        	for(int pos=0;pos<i+1;pos++){
        		if(pos==0||pos==i)
        			temp.add(1);
        		else
        			temp.add(last.get(pos)+last.get(pos-1));
        	}
        	ans.add(temp);
        }
        ans.remove(0);
        return ans;
    }
    
}
