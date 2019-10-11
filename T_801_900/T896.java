package T_801_900;

public class T896 {

//	判断是否为单调的
	
//	根据头和尾确定大小，然后依次判断
    public boolean isMonotonic(int[] A) {
        if(A.length<=2)
        	return true;
        if(A[0]-A[A.length-1]==0){//全等
        	for(int i=1;i<A.length;i++){
        		if(A[i-1]!=A[i])
        			return false;
        	}
        }else if(A[0]-A[A.length-1]>0){//单减
        	for(int i=1;i<A.length;i++){
        		if(A[i-1]-A[i]<0)
        			return false;
        	}
        }else{//单增
        	for(int i=1;i<A.length;i++){
        		if(A[i-1]-A[i]>0)
        			return false;
        	}
        }
    	return true;
    }

//    想法很巧妙
//    def isMonotonic(self, A):
//        increase, decrease = False, False
//        for i in range(len(A)-1):
//            if A[i] < A[i+1]:
//                increase = True
//            elif A[i] > A[i+1]:
//                decrease = True
//        return not (increase and decrease)
	
}
