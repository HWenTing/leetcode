package T_1_100;

import java.util.*;
public class T54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> ans = new ArrayList<Integer>();
    	
    	int i=0,j=0,di=0,dj=1;
    	int leny=matrix.length;
    	if(leny==0){
    		return ans;
    	}
    	int lenx=matrix[0].length;
    	
    	for(int count =0;count<lenx*leny;count++){
    		ans.add(matrix[i][j]);
//    		System.out.println(matrix[i][j]);
    		matrix[i][j]=Integer.MAX_VALUE;
    		
//    		System.out.println((i+di)%leny+" "+(j+dj)%lenx);
    		

    		
    		
    		if(matrix[(i+di)%leny][(Math.abs(j+dj))%lenx]==Integer.MAX_VALUE){
    			int temp=di;
    			di = dj;
    			dj = -temp;
    		}
    		i+=di;
    		j+=dj;
    	}
 
    	return ans;
    	
    }
    
    public static void main(String[] args){
    	int[][] t={
    	           { 1, 2, 3, 4 },
    	           {5, 6, 7, 8},
    	           { 9,10,11,12 }
    				};
    	int[][] t2={
    			{2,3,4},
    			{5,6,7},
    			{8,9,10},
    			{11,12,13},
    			{14,15,16}
 				};
    	System.out.println(spiralOrder(t2));
    }
}

