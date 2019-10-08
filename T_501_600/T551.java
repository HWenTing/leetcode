package T_501_600;

public class T551 {

//	判断是否不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到)
    public boolean checkRecord(String s) {
    	int cntA = 0;
    	int cntL = 0;
        for(char c:s.toCharArray()){
        	switch(c){
        		case 'A':
        			if(cntA>0)
        				return false;
        			cntA++;
                    cntL=0;
        			break;
        		case 'L':
        			if(cntL>1)
        				return false;
        			cntL++;
        			break;
        		default:
        			cntL=0;
        	}	
        }
        return true;
    }
    
}
