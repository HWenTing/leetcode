package T_1_100;

import java.util.ArrayList;
import java.util.List;

public class T89 {

//	格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
//	给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。

	/*
	 * 通过观察可以发现，前四项与后四项，除了第一位以外，是镜像关系
	 * 0 0 0
	 * 0 0 1
	 * 0 1 1
	 * 0 1 0
	 * 1 1 0
	 * 1 1 1
	 * 1 0 1
	 * 1 0 0
	 */
    public List<Integer> grayCode(int n) {
    	List<Integer> ans = new ArrayList<>((int)Math.pow(2, n));
    	ans.add(0);
    	
    	int len=1;
    	int pos;
    	for(int i=0;i<n;i++){
    		
			pos=len-1;
    		for(int j=0;j<len;j++){//每一层都倒着加
    			ans.add(ans.get(pos)+len);
    			pos-=1;
    		}
    	
    		len*=2;
    	}
    	return ans;
    }
}
