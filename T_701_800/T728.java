package T_701_800;

import java.util.LinkedList;
import java.util.List;

public class T728 {

//	自除数 是指可以被它包含的每一位数除尽的数。
//	例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。
//	还有，自除数不允许包含 0 。
//	给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。

	
    public List<Integer> selfDividingNumbers(int left, int right) {
        
    	List<Integer> ans = new LinkedList<>();
    	while(left<=right){
    		if(valid(left))
    			ans.add(left);
    		left++;
    	}
    	return ans;
    }

	private boolean valid(int left) {
		int temp=left;
		while(temp>0){
			int b = temp%10;
			if(b==0 || left%b!=0)
				return false;
			temp/=10;
		}
		return true;
	}
}
