package T1k_101_200;

public class T1184 {

//	两条路比长度
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
    	int len = distance.length;
    	int pos = start;
    	int p1=0;
        while(pos!=destination){
        	p1+=distance[pos];
        	pos=(pos+1)%len;
        }

        int p2=0;
        pos = start;
        while(pos!=destination){
        	pos=(pos-1+len)%len;//这里和上边不一样，反过来
        	p2+=distance[pos];
        }
        
        return Math.min(p1, p2);
    }
}
