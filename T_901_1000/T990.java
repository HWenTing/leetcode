package T_901_1000;

import java.util.LinkedList;

public class T990 {

//	给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，
//	并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
//
//	只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 

//	不能偷懒 并查集 先处理等式
    public boolean equationsPossible(String[] equations) {

    	int[] mark = new int[26];
    	for(int i=0;i<26;i++)
    		mark[i] = i;
    	
    	LinkedList<String> unequal = new LinkedList<>();
    	
    	for(String equation:equations){
    		int p1 = equation.charAt(0)-'a';
    		int p2 = equation.charAt(3)-'a';
    		
    		if(equation.charAt(1)=='='){
    			if(p1==p2) continue;
    			int r1 = findroot(mark,p1);
    			int r2 = findroot(mark,p2);
    			mark[r2] = r1;
    			
    		}else{
    			unequal.add(equation);
    		}
    	}
    	
    	for(String equation:unequal){
    		int p1 = equation.charAt(0)-'a';
    		int p2 = equation.charAt(3)-'a';
    		if( p1==p2 ) return false;
    		
    		int r1 = findroot(mark,p1);
			int r2 = findroot(mark,p2);
			
			if(r1==r2) return false;
    	}
    	return true;
    	
    }
    
    private int findroot(int[] mark,int i){
    	while(mark[i]!=i){
    		i = mark[i];
    	}
    	return i;
    }
}
