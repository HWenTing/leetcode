package T_1_100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T6 {
	
    public static String convert(String s, int numRows) {
    	if(numRows <=1){
    		return s;
    	}
    	String ans = "";
    	LinkedList[] a = new LinkedList[numRows];
        for (int i =0;i<numRows;i++){
        	a[i] = new LinkedList();
        }
        
        int totalLen = s.length();
        int pos = 0;
        int listpos = 0;
        boolean baidong = false;
        while(pos<totalLen){
        	a[listpos].add(s.charAt(pos));
        	pos++;
        	
        	if(listpos == 0 ||listpos == numRows-1){
        		baidong = !baidong ;
        	}
        	if(baidong){
        		listpos++;
        	}else{
        		listpos--;
        	}
        }
        
        StringBuilder lala = new StringBuilder() ;
        

        
        for (int j =0;j<numRows;j++){
            for(int i =0; i < a[j].size(); i++){
                lala.append(a[j].get(i));
            }
        }

        return lala.toString();
    }
    
    
	public static void main(String []args){
		String s = "AB";
		System.out.println(convert(s,1));
	}
}
