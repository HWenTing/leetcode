package T_701_800;

import java.util.LinkedList;
import java.util.List;

public class T763 {

//	字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。

// 先统计每个字母出现的最后位置，划分区间
    
    public List<Integer> partitionLabels(String S) {
    	int[]pos = new int[26];
        for(int i=0;i<S.length();i++){
        	char c = S.charAt(i);
        	pos[c-'a']=i;
        }
        
        int axis=0;
        LinkedList<Integer> ans = new LinkedList<>();
    	while(axis<S.length()){
    		int before=axis;
    		int temp = pos[S.charAt(axis)-'a'];
    		while(++axis<=temp){//如果在区间里边存在右界更大的，更新
    			if(pos[S.charAt(axis)-'a']>temp)
    				temp = pos[S.charAt(axis)-'a'];
    		}
    		temp++;
    		ans.add(temp-before);//一个区间划分完毕
    		axis = temp;

    	}
    	return ans;
    }
    
}
