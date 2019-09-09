package T_901_1000;

public class T997 {
	
//	在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
//	如果小镇的法官真的存在，那么：
//	小镇的法官不相信任何人。
//	每个人（除了小镇法官外）都信任小镇的法官。
//	只有一个人同时满足属性 1 和属性 2 。
//	给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
//	如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
	
//	用入度出度的思想,入度为N-1，出度为0的点 只有一个的话就是法官
//	时间击败98%，空间击败10
//    public int findJudge(int N, int[][] trust) {
//        int[] indegree = new int[N+1];
//        int[] outdegree = new int[N+1];
//        for(int[] i:trust){
//        	outdegree[i[0]]++;
//        	indegree[i[1]]++;
//        }
//        
//        int ans=-1;
//        for(int i=1;i<=N;i++){
//        	if(indegree[i]==N-1 && outdegree[i]==0){
//        		if(ans>0) return -1;
//        		ans=i;
//        	}
//        }
//        return ans;
//    }
    
	
//	可以只用一个数组，入度加，出度减，判断有几个N-1
    public int findJudge(int N, int[][] trust) {
        int[] degree = new int[N+1];
        for(int[] i:trust){
        	degree[i[0]]--;
        	degree[i[1]]++;
        }
        
        int ans=-1;
        for(int i=1;i<=N;i++){
        	if(degree[i]==N-1){
        		if(ans>0) return -1;
        		ans=i;
        	}
        }
        return ans;
    }
    
}
