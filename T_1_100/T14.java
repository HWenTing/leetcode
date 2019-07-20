package T_1_100;

public class T14 {
	
    public static String longestCommonPrefix(String[] strs) {
    	String temp = "";
    	int len = strs.length;
    	int pos =0;
    	try{
        	while(true){
        		
        		char aaa = strs[0].charAt(pos);
        		boolean isright = true;
            	for (int i =1;i<len;i++){
            		if(strs[i].charAt(pos) != aaa){
            			isright = false;
            			
            		}
            	}
            	pos++;
            	if (isright) temp+=aaa+"";
            	else break;
        	}
    	}catch(Exception e){
    		
    	}


    	return temp;

    }
    
	public static void main(String []args){
		String[] s = {"flower","flow","flight"};
//		System.out.println(longestCommonPrefix(s));
		System.out.println("flower".indexOf("flsow") );
	}
	
	
}
