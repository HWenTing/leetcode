package T_801_900;

import java.util.Arrays;
import java.util.Comparator;

class Pair1{
	int pos;
	int val;

	Pair1(int val,int pos){
		this.pos=pos;
		this.val=val;
	}
}
public class T870 {

//	给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
//	返回 A 的任意排列，使其相对于 B 的优势最大化。

//	田忌赛马
	
    public int[] advantageCount(int[] A, int[] B) {

    	Pair1[] Ap = new Pair1[A.length];
    	Pair1[] Bp = new Pair1[B.length];
    	for(int i=0;i<A.length;i++)
    		Ap[i] = new Pair1(A[i],i);
    	for(int i=0;i<B.length;i++)
    		Bp[i] = new Pair1(B[i],i);
    	
        Arrays.sort(Ap,new Comparator<Pair1>(){
			@Override
			public int compare(Pair1 o1, Pair1 o2) {
				return o1.val-o2.val;
			}
        });
        
        Arrays.sort(Bp,new Comparator<Pair1>(){
 			@Override
 			public int compare(Pair1 o1, Pair1 o2) {
 				return o1.val-o2.val;
 			}
         });
        
        int[] ans = new int[A.length];
        boolean[] marked=new boolean[A.length];
        int b=B.length-1;
        int a=A.length-1;
        for(;a>=0 && b>=0;a--){

        	while(b>=0){
        		if(Ap[a].val>Bp[b].val){

        			ans[Bp[b].pos]=Ap[a].val;
                    marked[Bp[b].pos]=true;
        			b--;
        			break;
        		}
        		b--;
        	}
        }
        
        for(int i=0;i<A.length && a>=0;i++){
        	if(!marked[i]){

        		ans[i]=Ap[a].val;
        		a--;
        	}
        }
        return ans;
    }
        
}
