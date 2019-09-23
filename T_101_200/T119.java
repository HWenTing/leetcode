package T_101_200;

import java.util.LinkedList;
import java.util.List;

public class T119 {

//	返回第i行杨辉三角
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> ans = new LinkedList<>();
        for(int i=0;i<rowIndex+1;i++){
        	List<Integer> temp = new LinkedList<>();
        	for(int pos=0;pos<i+1;pos++){
        		if(pos==0||pos==i)
        			temp.add(1);
        		else
        			temp.add(ans.get(pos)+ans.get(pos-1));
        	}
        	ans=temp;
        }
        return ans;
    }
    
}
