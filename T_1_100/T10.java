package T_1_100;

public class T10 {
	
	
    public static boolean isMatch(String s, String p) {
    	return s.matches(p);
        
        
    }
    
    
	public static void main(String []args){
		
		String s = "aab";
		String p = "c*a*b";
		System.out.println(isMatch(s,p));
	}
}
