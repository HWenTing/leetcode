package T_101_200;

import java.util.LinkedList;
import java.util.List;

public class T165 {
//	比较两个版本号 version1 和 version2。
//	如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1， 除此之外返回 0。
//	你可以假设版本字符串非空，并且只包含数字和 . 字符。

//	字符串处理
    public int compareVersion(String version1, String version2) {
    	List<Integer> v1 = pre(version1);
    	List<Integer> v2 = pre(version2);
    	for(int i=0;i<Math.max(v1.size(),v2.size());i++){
    		int n1 = i<v1.size()?v1.get(i):0;
    		int n2 = i<v2.size()?v2.get(i):0;
    		if(n1>n2)
    			return 1;
    		else if(n1<n2)
    			return -1;
    	}
    	return 0;
    }
    
    private List<Integer> pre(String version1){
    	List<Integer> v1 = new LinkedList<>();
    	int temp=0;
        for(char c:version1.toCharArray()){
        	if(c=='.'){
        		v1.add(temp);
        		temp=0;
        	}else{
        		temp = temp*10+c-'0';
        	}
        }
        v1.add(temp);
        return v1;
    }
}
