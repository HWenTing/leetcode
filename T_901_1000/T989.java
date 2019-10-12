package T_901_1000;

import java.util.LinkedList;
import java.util.List;

public class T989 {

	
//	对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
	
//	有一种大数相加的感觉 
//	下边是比较标准的写法，如果K也是一个数组，改起来也很方便。
//    public List<Integer> addToArrayForm(int[] A, int K) {
//    	
//    	int carry=0;
//    	int posA = A.length-1;
//    	LinkedList<Integer> ans = new LinkedList<>();
//    	while(posA>=0 && K>0){
//    		int temp = A[posA]+K%10+carry;
//    		carry = temp/10;
//    		ans.addFirst(temp%10);
//    		posA--;
//    		K/=10;
//    	}
//    	
//    	while(posA>=0){//A没结束
//    		int temp = A[posA]+carry;
//    		carry = temp/10;
//    		ans.addFirst(temp%10);
//    		posA--;
//    	}
//    	
//       	while(K>0){//K没结束
//    		int temp = K%10+carry;
//    		carry = temp/10;
//    		ans.addFirst(temp%10);
//    		K/=10;
//    	}
//       	
//		if(carry!=0)//carry没结束
//			ans.addFirst(carry);
//       	
//    	return ans;
//    }
	
	
//	鉴于K是个int，自动进位，因此可以省略掉carry
    public List<Integer> addToArrayForm(int[] A, int K) {
        int len = A.length;
        int lastNum =K;
        LinkedList<Integer> ret= new LinkedList<>();

        int i = len-1;
        while(i >=0 || lastNum > 0){
            if(i >= 0){
                lastNum+=A[i];
            }
            ret.addFirst(lastNum%10);
            lastNum/=10;
            i--;
        }

        return ret;
    }
}















