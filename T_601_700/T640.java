package T_601_700;

public class T640 {

//	求解一个给定的方程，将x以字符串"x=#value"的形式返回。该方程仅包含'+'，' - '操作，变量 x 和其对应系数。
//	如果方程没有解，请返回“No solution”。
//	如果方程有无限解，则返回“Infinite solutions”。
//	如果方程中只有一个解，要保证返回值 x 是一个整数。

//	字符串处理 
    public String solveEquation(String equation) {
    	
    	equation = "#"+equation+"#";
    	int leftnum = 0;//记录等号左边的数字
    	int leftx = 0;//记录等号左边的系数

    	int left = 1;//标记左还是右
    	int add = 1;//标记正还是负
    	int cur = 0;//标记当前数字
    	//left*add*cur综合考虑了符号和移相后的结果
    	
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
    			if(cur==0 && equation.charAt(i-1)!='0') cur=1;//处理0x=0的情况
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

