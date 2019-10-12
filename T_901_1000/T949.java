package T_901_1000;

import java.util.LinkedList;
import java.util.List;

public class T949 {

	
//	给定一个由 4 位数字组成的数组，返回可以设置的符合 24 小时制的最大时间。
//最小的 24 小时制时间是 00:00，而最大的是 23:59。从 00:00 （午夜）开始算起，过得越久，时间越大。
//以长度为 5 的字符串返回答案。如果不能确定有效时间，则返回空字符串。

    String ans = "";
    int anstime = 0;
    boolean[] marked ;
    
    public String largestTimeFromDigits(int[] A) {
        marked = new boolean[4];
        flashback(new LinkedList<>(),A);
        return ans;

    }

  //回溯得到所有时间排列
    private void flashback(List<Integer> ls,int[] A){
    	if(ls.size()==4){
    		int[] temp = check(ls);
    		if(temp[0]==0){
    			anstime = temp[1];
    			ans = ""+ls.get(0)+ls.get(1)+":"+ls.get(2)+ls.get(3);
    		}
    		return;
    	}
    	for(int i=0;i<4;i++){
    		if(!marked[i]){
    			marked[i]=true;
    			ls.add(A[i]);
    			flashback(ls,A);
    			ls.remove(ls.size()-1);
    			marked[i]=false;
    		}
    	}
    }
    
//    判断是否符合时间格式且时间最晚
    private int[] check(List<Integer> ls){
    	int hour = ls.get(0)*10+ls.get(1);
    	int minute = ls.get(2)*10+ls.get(3);
    	if(hour>23 ||minute>59 || hour*60+minute<anstime) 
    		return new int[]{1,-1};
    	return new int[]{0,hour*60+minute};
    }
    
    
    
}
