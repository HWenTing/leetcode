package T_1_100;

public class T38 {

    public static String countAndSay(int n) {
    	if(n==1){
    		return 1+"";
    	}
    	String ans="11";
        for (int loop=1;loop<n-1;loop++){
        	int count=1;
        	String temp="";
        	for(int i=0;i<ans.length()-1;i++){
        		
        		if (ans.charAt(i+1)==ans.charAt(i)){
        			
        			count++;
        		}else{
        			temp = temp+count+""+ans.charAt(i);
        			count=1;
        		}
        	}
        	
        	temp = temp+count+""+ans.charAt(ans.length()-1);			
        	ans=temp;
        }
        return ans;
    }
    
    public static void main(String[] args){
    	System.out.println(countAndSay(2));
    }
}
