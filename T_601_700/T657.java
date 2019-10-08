package T_601_700;

public class T657 {

//	过于简单
    public boolean judgeCircle(String moves) {
        int x=0;
        int y=0;
    	for(char c:moves.toCharArray()){
    		switch(c){
    		case 'U':
    			y++;
    			break;
    		case 'D':
    			y--;
    			break;
    		case 'L':
    			x--;
    			break;
    		case 'R':
    			x++;
    			break;
    		}
    	}
    	return x==0&&y==0;
    }
    
}
