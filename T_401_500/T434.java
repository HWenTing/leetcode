package T_401_500;

public class T434 {

//	看有多少单词
    public int countSegments(String s) {
    	int cnt=0;
    	char before= ' ';
    	for(char i:s.toCharArray()){
    		if((before==' ') && (i!=' ')){
    			cnt++;
    		}
    		before =i;
    	}
    	return cnt;
    }
    
}
