package T_601_700;

public class T670 {

	
//	给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
	
//	对于第i位，如果该位大于所有后边的数，说明第i位不需要交换，那么i++，处理后边的子字串
//	时间复杂度O(n)  空间复杂度O(n) 
	
    public int maximumSwap(int num) {
    	char[] numstring = (num+"").toCharArray(); 
        int len = numstring.length;
    	if(len<2) return num;
    	
        int[] maxposs = new int[len];
        int maxpos = len-1;
        for(int i=len-1;i>=0;i--){//逆序寻找后i位最大的数所在的位置
        	if(numstring[i]>numstring[maxpos])
        		maxpos = i;
        	maxposs[i] = maxpos;
        }
        
        for(int i=0;i<len-1;i++){
        	if(numstring[i]<numstring[maxposs[i+1]]){//如果i不是后i位最大的数，则交换后能够得到更大的值
        		return exchange(i,maxposs[i+1],numstring);
        	}
        }
        return num;
        
    }

	private int exchange(int i, int j, char[] numstring) {
		char temp = numstring[i];
		numstring[i] = numstring[j];
		numstring[j] = temp;
		String ret = new String(numstring);
		return Integer.parseInt(ret);
	}
    
}
