package T_801_900;

import java.util.List;
import java.util.Stack;

public class T841 {
//	有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
//	在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
//	最初，除 0 号房间外的其余所有房间都被锁住。
//	你可以自由地在房间之间来回走动。
//	如果能进入每个房间返回 true，否则返回 false。
	
//	一遍ac 速度击败60%。。
//	将遍历到的节点加入栈，依次
//    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//        
//    	boolean[] visit = new boolean[rooms.size()];
//    	int total=rooms.size();
//    	Stack<Integer> st = new Stack<>();
//    	visit[0]=true;
//    	total--;
//    	for(int i:rooms.get(0)){
//    		st.add(i);
//    	}
//    	while(!st.isEmpty()){
//    		int roomnum = st.pop();
//    		if(!visit[roomnum]){
//    			visit[roomnum]=true;//只有在遍历到该节点时才置为true；
//    			total--;
//    			for(int i:rooms.get(roomnum)){
//    				if(!visit[i])
//    					st.add(i);
//    			}
//    		}
//    	}
//    	
//    	return total==0;
//    }
    
//	dfs， 拿着钥匙去房间，去房间拿别的钥匙，再去别的房间。房间被访问过了，说明该房间的钥匙已经拿过了，那就没必要再访问接下来的房间了。
//	速度击败97%
	private int total;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        total = rooms.size();
        visitRooms(rooms,visited,0);       
        return total==0;
    }
    
    public void visitRooms(List<List<Integer>> rooms,boolean[] visited,int room){
        if(visited[room]){
            return;
        }else{
        	total--;
            visited[room] = true;
            for(int i =0;i<rooms.get(room).size();i++){
                visitRooms(rooms,visited,rooms.get(room).get(i));
            }
        }
    }  
    
}
