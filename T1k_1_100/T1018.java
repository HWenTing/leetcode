package T1k_1_100;

import java.util.ArrayList;
import java.util.List;

public class T1018 {

//	给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
//	返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。

//	要注意溢出问题，
    public List<Boolean> prefixesDivBy5(int[] A) {
    	
    	ArrayList<Boolean> ans = new ArrayList<>();
    	int temp=0;
    	int shang=5;
        for(int a:A){
        	if(a==1)
        		temp++;
        	if(temp%shang==0)
        		ans.add(true);
        	else
        		ans.add(false);
        	temp<<=1;
        	temp%=shang;//求模防止溢出
        }
        return ans;
    }
    
}
