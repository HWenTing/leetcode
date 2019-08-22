package T_701_800;

public class T771 {

//	public int numJewelsInStones(String J, String S) {
//	    int num = 0;
//	    for (int i = 0; i < S.length(); i++) {
//	        String temp = S.substring(i, i + 1);
//	        if (J.indexOf(temp) != -1) {
//	            //b包含
//	            num++;
//	        }
//	    }
//	    return num;
//	}
	
//	击败95% hash思想
	public int numJewelsInStones(String J, String S) {
	    int num = 0;
        boolean[]  has=new boolean[256];
        for(char c:J.toCharArray())
            has[c]=true;
        
	    for (char c:S.toCharArray()) {
	        if (has[c])  num++;
	    }
	    return num;
	}
	
}
