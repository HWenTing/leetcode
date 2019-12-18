package T_201_300;

public class T299 {

//	你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
//	请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
//	请注意秘密数字和朋友的猜测数都可能含有重复数字。

	
    public String getHint(String secret, String guess) {
        int cntA = 0;
        int cntB = 0;
        int[] cntc1 = new int[10];
        int[] cntc2 = new int[10];
        for(int i=0;i<secret.length();i++){
        	if(secret.charAt(i)==guess.charAt(i))
        		cntA++;
        	else{
        		cntc1[secret.charAt(i)-'0']++;
        		cntc2[guess.charAt(i)-'0']++;
        	}
        }
        for(int i=0;i<10;i++)
        	cntB+=Math.min(cntc1[i], cntc2[i]);
        
        return cntA+"A"+cntB+"B";
    }
    
}
