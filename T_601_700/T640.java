package T_601_700;

public class T640 {

	
    public String solveEquation(String equation) {
    	
    	equation = equation+"#";
    	int leftnum = 0;
    	int leftx = 0;

    	int left = 1;
    	int add = 1;
    	int cur = 0;
    	
    	for(int i=0;i<equation.length();i++){
    		char c = equation.charAt(i);
    		
    		switch(c){

    		case '=':
    			leftnum+=left*add*cur;
    			cur = 0;
    			left=-1;
    			add=1;
    			break;
    		case 'x':
    			if(cur==0 ) cur=1;
    			leftx+=left*add*cur;
    			cur=0;
    			break;
    		case '-':
    			leftnum+=left*add*cur;
    			cur=0;
    			add=-1;
    			break;
    		case '+':
    			leftnum+=left*add*cur;
    			cur=0;
    			add=1;
    			break;
    		case '#':
    			leftnum+=left*add*cur;
    			break;
    			
    		default:
    			cur = cur*10+c-'0';
    		}
    	}
    	
    	System.out.println("num: "+leftnum);
    	System.out.println("x: "+leftx);
    	
    	int rightnum = -leftnum;
    	String ans = "x=";
    	if(leftx==0 && rightnum!=0)
    		ans = "No solution";
    	else if(leftx==0 && rightnum==0)
    		ans = "Infinite solutions";
    	else{
    		ans = ans+(rightnum/leftx);
    	}
    	return ans;
    	
    }
    
}

