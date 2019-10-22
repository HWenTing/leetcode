package T_801_900;

import java.util.Arrays;
import java.util.Comparator;

class Pair{
	int pos;
	int val;

	Pair(int val,int pos){
		this.pos=pos;
		this.val=val;
	}
}
public class T870 {

//	给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。
//	返回 A 的任意排列，使其相对于 B 的优势最大化。

//	田忌赛马
	
    public int[] advantageCount(int[] A, int[] B) {

    	Pair[] Ap = new Pair[A.length];
    	Pair[] Bp = new Pair[B.length];
    	for(int i=0;i<A.length;i++)
    		Ap[i] = new Pair(A[i],i);
    	for(int i=0;i<B.length;i++)
    		Bp[i] = new Pair(B[i],i);
    	
        Arrays.sort(Ap,new Comparator<Pair>(){
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.val-o2.val;
			}
        });
        
        Arrays.sort(Bp,new Comparator<Pair>(){
 			@Override
 			public int compare(Pair o1, Pair o2) {
 				return o1.val-o2.val;
 			}
         });
        
        int b=B.length-1;
        for(int a=A.length-1;a>=0;a--){
        	while(b>=0){
        		if(Ap[a].val>Bp[b].val){
        			int shouldpos = Bp[b].pos;
        			int brforepos = Ap[a].pos;
        			
        			A[brforepos]=A[shouldpos];
        			A[shouldpos]=Ap[a].val;
                    Ap[Bp[b].pos].pos = Bp[b].pos;
                    
        			b--;
        			break;
        		}
        		b--;
        	}
        	if(b<0)
        		break;
        }
        return A;
    }
        
}
