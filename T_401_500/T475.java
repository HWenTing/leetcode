package T_401_500;

import java.util.Arrays;

public class T475 {

//	给出加热器的位置，确定最小加热半径
//	要注意输入的序号不是连续的
	
//	对于每个房屋，要么用前面的暖气，要么用后面的，二者取近的，得到距离；
//	对于所有的房屋，选择最大的上述距离。
	
	public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int ans = 0;
        int i = 0;
        for (int house : houses) {
            while (i < heaters.length && heaters[i] < house) {
                // 一直找到处于房屋右侧的热水器
                i++;
            }
            if (i == 0)
            	ans = Math.max(ans, heaters[i] - house);
            else if (i == heaters.length)
                // 最后一个热水器
                return Math.max(ans, houses[houses.length-1] - heaters[heaters.length-1]);
            else
                // 房屋右侧的热水器和房屋左侧的热水器，取小的那个
            	ans = Math.max(ans, Math.min(heaters[i] - house, house - heaters[i - 1]));
        }
        return ans;
	}
    
    
    
    
    
    
    
    
    
}
