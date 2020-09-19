package T_1_100;

import java.util.ArrayList;
import java.util.List;

public class T93 {

	
//	给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
//	有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔

//	回溯
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
    
     
//    将传递字串改成传递下标 可能快一点
//	private String s;
//    public List<String> restoreIpAddresses(String s) {
//    	this.s = s;
//        List<String> res = new ArrayList<>();
//        StringBuffer temp = new StringBuffer();
//        doRestore(0,temp,res,0);
//        return res;
//    }
//    private void doRestore(int k,StringBuffer temp,List<String> res,int start){
//    	if(k==4 || s.length()==start){
//    		if(k==4 &&  s.length()==start)
//    			res.add(temp.toString());
//    		return;
//    	}
//    	for(int i=0;i+start<s.length()&&i<3;i++){
//    		if(i!=0 && s.charAt(start)=='0')
//    			break;
//    		String part = s.substring(start, start+i+1);
//    		if(Integer.valueOf(part)<=255){
//    			if(k!=0)
//    				part = '.'+part;
//    			temp.append(part);
//	    		doRestore(k+1,temp,res,start+i+1);
//	    		temp.delete(temp.length()-part.length(), temp.length());
//    		}
//    	}
//    }
//    
//    
//	public static void main(String[] args) {
//		T93 t = new T93();
//		List<String> ans = t.restoreIpAddresses("010010");
//		for (String s:ans){
//			System.out.println(s);
//		}
//	}

}
