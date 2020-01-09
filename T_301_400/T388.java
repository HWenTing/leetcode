package T_301_400;

public class T388 {

	
    public int lengthLongestPath(String input) {
    
    	int curlen=0;
    	int[] levellen = new int[30];
    	int max=0;
    	int curlevel=0;
    	boolean hasfile=false;
    	
    	for(char c : input.toCharArray()){
    		
    		if(c=='\n'){
    			levellen[curlevel]=(curlevel>=1?levellen[curlevel-1]:0)+curlen+1;
    			if(hasfile)
    				max = Math.max(max, levellen[curlevel]);
    			
    			curlevel=0;
    			curlen=0;
    			hasfile=false;
    		}else if(c=='\t'){
    			curlevel++;
    		}else{
    			if(c=='.') hasfile=true;
    			curlen++;
    		}
    	}
		if(hasfile)
			max = Math.max(max, (curlevel>=1?levellen[curlevel-1]:0)+curlen);
    	
		for(int i:levellen){
			System.out.print(i+" ");
		}
    	return max;
    	
    }
    
}
