package T_801_900;

import java.util.LinkedList;
import java.util.List;

public class T830 {

//	在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
//	例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
//	我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
//	最终结果按照字典顺序输出。
	
	
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new LinkedList<>();
        int start = 0;
        int end = 1;
        LinkedList<Integer> cur = new LinkedList<>();
        while(end<S.length()){
        	if(S.charAt(end)==S.charAt(start)){
        		end++;
        	}else{
        		if(end-start>=3){
        			cur.add(start);
        			cur.add(end-1);
        			ans.add(new LinkedList<>(cur));
        			cur.clear();
        		}
        		start=end;
        		end++;
        	}
        }
		if(end-start>=3){
			cur.add(start);
			cur.add(end-1);
			ans.add(cur);
		}
		return ans;
    }
    
}
