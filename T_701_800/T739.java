package T_701_800;

import java.util.Stack;

public class T739 {

//	给定一个数组，返回一个数组，对应位置为大于当前位置的数值的后边最近下标，没有的话返回0
//	用栈，每次push一个元素x，若stack.peek<x,stack.pop 并且将返回数组stack.pop对应元素位置标为x的序号与当前的差
	
//	速度还可以，就是有点耗内存
//	private class PAV{
//		int pos;
//		int val;
//		PAV(int _pos,int _val){
//			pos = _pos;
//			val = _val;
//		}
//	}
//	
//    public int[] dailyTemperatures(int[] T) {
//        int len = T.length;
//        int []ans = new int[len];
//        Stack<PAV> stack = new Stack<>();
//        int pos=0;
//        
//        stack.push(new PAV(0,T[0]));
//        for(int i=1;i<len;i++){
//        	while(!stack.empty() && stack.peek().val<T[i]){
//        		int temp = stack.pop().pos;
//        		ans[temp]=i-temp;
//        	}
//        	stack.push(new PAV(i,T[i]));
//        }
//        return ans;
//    }
    
    
//    对内存进行优化
//    其实stack并不需要存具体的值，存下标index即可
	
//	速度慢了一丢丢，内存提升了不少
    public int[] dailyTemperatures(int[] T) {
    	int len = T.length;
        int []ans = new int[len];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i=1;i<len;i++){
        	while(!stack.empty() && T[stack.peek()]<T[i]){
        		int temp = stack.pop();
        		ans[temp] = i-temp;
        	}
        	stack.push(i);
        }
        return ans;
    }
    
    
    
    
    
}
