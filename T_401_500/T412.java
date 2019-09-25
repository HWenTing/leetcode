package T_401_500;

import java.util.LinkedList;
import java.util.List;

public class T412 {

//	写一个程序，输出从 1 到 n 数字的字符串表示。
//	1. 如果 n 是3的倍数，输出“Fizz”；
//	2. 如果 n 是5的倍数，输出“Buzz”；
//	3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。
	
//	慢一点
    public List<String> fizzBuzz(int n) {
    	List<String> ans = new LinkedList<>();
    	for(int i=1;i<=n;i++){
    		ans.add(i+"");
    	}
    	
    	for(int i=3;i<=n;i+=3){
    		ans.set(i, "Fizz");
    	}
    	
    	for(int i=5;i<=n;i+=5){
    		if(ans.get(i).equals("Fizz"))
    			ans.set(i,  "FizzBuzz");
    		else
    			ans.set(i, "Buzz");
    	}
    	
    	return ans;
    }
    
}
