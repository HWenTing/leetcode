package T_601_700;
import java.util.*;
import java.util.Map.Entry;


public class T621 {

	
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        int mintime = len;
        int[] charCount = new int[26];
        
        for(int i=0;i<len;i++){
        	charCount[tasks[i]-'A']++;
        }
        
        int maxCount=0;
        int counts = 1;
        for(int i=0;i<26;i++){
        	if(charCount[i]>maxCount){
        		counts=1;
        		maxCount = charCount[i];
        	}else if(charCount[i]==maxCount){
        		counts++;
        	}
        }
        mintime = Math.max(mintime, (maxCount-1)*(n+1)+counts);
        return mintime;
    }
    
    
	public static void main(String[] args) {
		char[] tasks =  new char[]{
			'A','A','A','B','B','B'	
		};
		T621 t = new T621();
		System.out.println(t.leastInterval(tasks, 4));
				
    }
}
