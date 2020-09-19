package T_601_700;

import java.util.LinkedList;
import java.util.List;

public class T679 {

//	你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。
//	除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。
	
//	类似枚举模拟，四个里选两个进行加减乘除操作，然后作为一个数替代选出来的两个，然后再从三个数里选两个，继续操作，最后只剩一个数的时候判断是不是24
//	要注意浮点精度的问题
	
	private boolean win;
	static final double EPSILON = 1e-6;
	static final int TARGET = 24;
	
    public boolean judgePoint24(int[] nums) {
    	
    	List<Double> list = new LinkedList<>();
    	for(int i:nums)
    		list.add((double)i);
    	solve(list);
    	return win;
    }
    
    private void solve(List<Double> list){
    	if(win) return;
    	int n = list.size();
    	if(n==1){
    		win = win | Math.abs(list.get(0) - TARGET) < EPSILON;
    		return;
    	}
    	
    	for(int i=0;i<n-1;i++){
    		for(int j=i+1;j<n;j++){
    			double num1 = list.get(i);
    			double num2 = list.get(j);
    			List<Double> listnew = new LinkedList<>();
    			for(int k=0;k<n;k++)
    				if(k!=i && k!=j)
    					listnew.add(list.get(k));
    			//+
    			listnew.add(num1+num2);
    			solve(listnew);
    			listnew.remove(listnew.size()-1);
    			//num1-num2
    			listnew.add(num1-num2);
    			solve(listnew);
    			listnew.remove(listnew.size()-1);
    			//num2-num1
    			listnew.add(num2-num1);
    			solve(listnew);
    			listnew.remove(listnew.size()-1);
    			//*
    			listnew.add(num1*num2);
    			solve(listnew);
    			listnew.remove(listnew.size()-1);
    			//num2/num1
    			if(num1!=0){
        			listnew.add(num2/num1);
        			solve(listnew);
        			listnew.remove(listnew.size()-1);
    			}
    			//num1/num2
    			if(num2!=0){
        			listnew.add(num1/num2);
        			solve(listnew);
        			listnew.remove(listnew.size()-1);
    			}
    		}
    	}
    }

}
