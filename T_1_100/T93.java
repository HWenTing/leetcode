package T_1_100;

import java.util.ArrayList;
import java.util.List;

public class T93 {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        StringBuffer temp = new StringBuffer();
        doRestore(0,temp,res,s);
        return res;
    }
    private void doRestore(int k,StringBuffer temp,List<String> res,String s){
    	if(k==4 || s.length()==0){
    		if(k==4 && s.length()==0)
    			res.add(temp.toString());
    		return;
    	}
    	for(int i=0;i<s.length()&&i<3;i++){
    		if(i!=0 && s.charAt(0)=='0')
    			break;
    		String part = s.substring(0, i+1);
    		if(Integer.valueOf(part)<=255){
    			if(k!=0)
    				part = '.'+part;
    			temp.append(part);
	    		doRestore(k+1,temp,res,s.substring(i+1));
	    		temp.delete(temp.length()-part.length(), temp.length());   
    		}
    	}
    }
    
	public static void main(String[] args) {
		T93 t = new T93();
		List<String> ans = t.restoreIpAddresses("010010");
		for (String s:ans){
			System.out.println(s);
		}
	}

}
