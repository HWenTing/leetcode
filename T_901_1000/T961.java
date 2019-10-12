package T_901_1000;

public class T961 {

//	在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
//	返回重复了 N 次的那个元素。
	
//	和摩尔投票法很像，但这里是N次，选举是超过半数
    
//	要不有相等的元素靠着，要不然在前四个元素中肯定有相等的元素
    public int repeatedNTimes(int[] A) {
        for(int i = 0 ;i<A.length-1;++i){
            if(A[i] == A[i+1]){
                return A[i];
            }
        }
        return A[0] == A[2] || A[0] == A[3]?A[0]:A[1];
    }
    
    
//    考虑所有长度为 4 的子序列，在子序列中一定至少含有两个主要元素。
//    public int repeatedNTimes(int[] A) {
//        for (int k = 1; k <= 3; ++k)
//            for (int i = 0; i < A.length - k; ++i)
//                if (A[i] == A[i+k])
//                    return A[i];
//
//        throw null;
//    }
}
