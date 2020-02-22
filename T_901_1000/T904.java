package T_901_1000;

public class T904 {
//	在一排树中，第 i 棵树产生 tree[i] 型的水果。
//	你可以从你选择的任何树开始，然后重复执行以下步骤：
//
//	把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
//	移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
//	请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
//
//	你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
//	用这个程序你能收集的水果总量是多少？

//	题意求至多包含两种数组的最长的连续子序列 
//	双指针即可 并记录当前两个数字最后出现的位置
    public int totalFruit(int[] tree) {
        
    	if(tree.length<=2)
    		return tree.length;

    	int last1p = 0;//第一种元素的最后出现的位置
    	int last2p = last1p;//第二种元素的最后出现的位置
    	while(last2p<tree.length && tree[last2p]==tree[last1p])//找到第二种元素的最后出现的位置
    		last2p++;
    	if(last2p>=tree.length-1) return tree.length;
    	last1p = last2p-1;

    	int ans = 0;
    	int left = 0;//左端点指针
    	int right = last2p+1;//右端点指针
    	
    	
    	while(right<tree.length){
            ans = Math.max(ans, right-left);
    		if(tree[right]==tree[last1p]){//修改指针
    			last1p = right;

    		}else if(tree[right]==tree[last2p]){//修改指针
    			last2p = right;

    		}else{
    			if(last1p<last2p){
    				left = last1p+1;
    				last1p = right;
    			}else{
    				left = last2p+1;
    				last2p = right;
    			}
    		}
			right++;
    	}
    	ans = Math.max(ans, right-left);
    	return ans;
    	
    }

    
}
