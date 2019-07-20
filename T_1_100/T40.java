package T_1_100;

import java.util.*;

public class T40 {

	
	 public static  List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        List<List<Integer>> listAll=new ArrayList<List<Integer>>();
	        List<Integer> list=new ArrayList<Integer>();
	        //排序
	        Arrays.sort(candidates);
	        find(listAll,list,candidates,target,0);
	        
	         
            HashSet<List<Integer>> h = new HashSet<List<Integer>>(listAll);   
            listAll.clear();   
            listAll.addAll(h); 
            
	        return listAll;
	    }
    public static void find(List<List<Integer>> listAll,List<Integer> tmp,int[] candidates, int target,int num){
        try{
	    	//递归的终点
	        if(target==0){
	            listAll.add(tmp);
	            return;
	        } 
	        if(target<candidates[num]) return;
	        for(int i=num;i<candidates.length&&candidates[i]<=target;i++){
	            //深拷贝
	            List<Integer> list=new ArrayList<>(tmp);
	            list.add(candidates[i]);
	            //递归运算，将i传递至下一次运算是为了避免结果重复。
	            find(listAll,list,candidates,target-candidates[i],i+1);
	        }
        }catch(Exception e){
        	return;
        }
    } 
    
//    public static List<List<Integer>> removeDuplicate(List<List<Integer>> list) {   
//        HashSet<List<Integer>> h = new HashSet<List<Integer>>(list);   
//        list.clear();   
//        list.addAll(h);   
//        return list;   
//    }  
    
    public static void main(String[] args){
    	int[] candidates = {2};
    	int target = 2;
    	System.out.println(combinationSum2(candidates,target));
    }
}
