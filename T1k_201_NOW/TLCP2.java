package T1k_201_NOW;

public class TLCP2 {
	
	
//	分式化简
//	从右往左通分
    public int[] fraction(int[] cont) {
        int fenzi = 1;
        int fenmu = cont[cont.length-1];
        
        for(int i=cont.length-2;i>=0;i--){
        	fenzi = cont[i]*fenmu+fenzi;
        	
        	int temp = fenzi;
        	fenzi = fenmu;
        	fenmu = temp;

        }
        return new int[]{fenmu,fenzi};
    }
    
    

}
