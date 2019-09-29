package T_401_500;

public class T475 {

//	给出加热器的位置，确定最小加热半径
//	要注意输入的序号不是连续的
	
	
	
	
	
	
	
	
	
    public int findRadius(int[] houses, int[] heaters) {
    	
    	int ans = 0;
    	if(heaters.length==1)
    		return Math.max(houses[houses.length-1]-heaters[0], heaters[0]-houses[0]);
    	
    	int p1=0;
    	int p2=1;
    	
    	for(int house:houses){
    		if(house<=heaters[p1]){
    			ans=Math.max(ans, heaters[p1]-house);
    		}else if(house>=heaters[p2]){
    			w
    		}
    	}
    	
    }
    
}
