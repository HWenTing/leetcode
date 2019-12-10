package T_201_300;

import java.util.LinkedList;
import java.util.List;

public class T216 {

//	找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
//
//	所有数字都是正整数。
//	解集不能包含重复的组合。 
	
//	典型的回溯算法  要记得还原现场
	List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
    	ans = new LinkedList<>();
    	if(k>9 || k<1)
    		return ans;
    	item(k,n,new LinkedList<>(),0);
    	return ans;
    }
    
    private void item(int k, int n,List<Integer> temp,int begin){
    	if(k==1 || n<=0){
    		if(n>begin && n<=9){
    			temp.add(n);
    			ans.add(new LinkedList<>(temp));
    			temp.remove(temp.size()-1);
    		}
    		return ;
    	}
    	
    	begin++;
    	for(;begin<=9;begin++){//要记得还原现场
    		temp.add(begin);
    		item(k-1,n-begin,temp,begin);
    		temp.remove(temp.size()-1);
    	}
    	
    	
    }
}
