package T_1_100;

import java.util.Deque;
import java.util.LinkedList;

public class T7 {

	
    public static int reverse(int x) {
    	try{
	    	if(x==0){
	    		return 0;
	    	}
	    	String number  = x+"";
	    	int pos = 0;
	    	int len = number.length();
	    	boolean fu = false;
	    	Deque<String> sta = new LinkedList<String>();
	        if(number.charAt(0)=='-'){
	        	fu = true;
	        	pos++;
	        }
	        while(pos<len){
	        	sta.addFirst(number.charAt(pos++)+"");
	        }
	        
	        StringBuilder lala = new StringBuilder() ;
	        if(fu){
	        	lala.append("-");
	        }
	        boolean zero = true;
	        while(!sta.isEmpty()){
	        	String temp = sta.poll();
	        	if (zero && !temp.equals("0")){
	        		zero = false;
	        	}
	        	if(!zero){
	        		lala.append(temp);
	        	}
	        }
	        return Integer.parseInt(lala.toString());
    	}catch (Exception e){
    		return 0;
    	}
    	
    	
    }
    
	public static void main(String []args){
		String s = "AB";
		System.out.println(reverse(1534236469));
	}
}
