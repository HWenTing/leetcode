package T_201_300;

import java.util.ArrayList;
import java.util.List;

public class T241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ways = new ArrayList<>();
        for (int i =0;i<input.length();i++){
        	char cur = input.charAt(i);
        	if(cur=='+' || cur=='-'||cur=='*'){
        		List<Integer> left = diffWaysToCompute(input.substring(0, i));
        		List<Integer> right = diffWaysToCompute(input.substring(i+1));
        		for(int l:left){
        			for(int r:right){
        				switch(cur){
        				case '+':
        					ways.add(l+r);
        					break;
        				case '-':
        					ways.add(l-r);
        					break;
        				case '*':
        					ways.add(l*r);
        					break;
        				}
        			}
        		}
        	}
        }
        if(ways.isEmpty()){
        	ways.add(Integer.parseInt(input));
        }
        return ways;
    }
    
    public static void main(String[] args){
    	T241 t = new T241();
    	System.out.println(t.diffWaysToCompute("2*3-4*5"));
    }
    
}
