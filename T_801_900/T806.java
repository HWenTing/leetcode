package T_801_900;

public class T806 {

    public int[] numberOfLines(int[] widths, String S) {
        
    	int row=0;
    	int cur=0;
    	for(char c:S.toCharArray()){
    		
    		if(cur+widths[c-'a']>100){
    			row++;
    			cur=widths[c-'a'];
    		}else{
    			cur+=widths[c-'a'];
    		}
    	}
    	return new int[]{row+1,cur};
    }
    
}
