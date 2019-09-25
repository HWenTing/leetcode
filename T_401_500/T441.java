package T_401_500;

public class T441 {

//	你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。
//	给定一个数字 n，找出可形成完整阶梯行的总行数。
	
//	循环呗
    public int arrangeCoins(int n) {
        int layer=1;
        while(n>=layer){
        	n-=layer;
        	layer++;
        }
        return layer-1;
    }
    
}
