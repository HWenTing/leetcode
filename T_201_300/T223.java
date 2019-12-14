package T_201_300;

public class T223 {

//	在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。每个矩形由其左下顶点和右上顶点坐标表示
//    面积和减去重合的面积
	
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int S1 = (C-A)*(D-B);
        int S2 = (G-E)*(H-F);
    	
        int up = Math.min(D, H);
        int down = Math.max(B, F);
        int left = Math.max(A, E);
        int right = Math.min(C, G);

        if(up>down &&  right>left){//有重合
        	int overlap = (up-down)*(right-left);
        	return S1+S2-overlap;
        }else{
        	return S1+S2;
        }
    }
}

