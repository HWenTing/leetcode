package T_1_100;

import java.util.ArrayList;
import java.util.List;

public class T17 {

//    public static List<String> letterCombinations(String digits) {
//    	if(digits.length() == 0) return new ArrayList<String>();
//		  char[][] numChar = new char[][]{
//			  {'a','b','c'},  
//			  {'d','e','f'},    
//			  {'g','h','i'},    
//			  {'j','k','l'},    
//			  {'m','n','o'},    
//			  {'p','q','r','s'},
//			  {'t','u','v'},    
//			  {'w','x','y','z'}			  
//		  };
//		  List<String> result = new ArrayList<>();
//		  char[] tem  = new char[digits.length()];
//		  char[][] temp = new char[digits.length()][];
//		  for(int i = 0; i < digits.length(); i ++){
//			  temp[i] = numChar[digits.charAt(i) - '2'];
//		  }
//		  build(result, temp, tem, 0);
//		  return result;
// 
//    }
//    
//	  private static void build(List<String> result, char[][] temp, char[] tem, int idx){
//		  for(char tt : temp[idx]){
//			  tem[idx] = tt;
//			  if(idx == temp.length - 1){
//				  result.add(new String(tem));
//			  }else{
//				  build(result, temp, tem, idx + 1);
//			  }
//		  }
//	  }
	  
	private static final String[] KEYS = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits==null ||digits.length()==0)
        	return res;
        doCombination(new StringBuffer(),res,digits);
        return res;
    }
	  
    private void doCombination(StringBuffer prefix,List<String> res,final String digits){
    	if(prefix.length() == digits.length()){
    		res.add(prefix.toString());
    		return;
    	}
    	int curnum = digits.charAt(prefix.length())-'0';
    	String letters = KEYS[curnum];
    	for(char c : letters.toCharArray()){
    		prefix.append(c);
    		doCombination(prefix,res,digits);
    		prefix.deleteCharAt(prefix.length()-1);
    	}
    		
    	
    }
    
    public static void main(String []args){
    	T17 t = new T17();
		String aa = "22";
		System.out.println(t.letterCombinations(aa));
	}
    
}
