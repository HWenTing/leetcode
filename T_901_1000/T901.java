package T_901_1000;

import java.util.Stack;

public class T901 {

	
//	编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
//	今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
//	例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。

//	栈 存储该位置的price和该位置对应的len 
	
	Stack<int[]> st;
    public T901() {
    	st = new Stack<>();
	}
    
    public int next(int price) {
    	int ret = 1;
		while(!st.isEmpty() && st.peek()[0]<=price){//如果当前价格大于等于栈顶价格，那么弹出栈顶价格并将长度相加
			ret+=st.pop()[1];
		}
    	st.push(new int[]{price,ret});
    	return ret;
    }
    
}
