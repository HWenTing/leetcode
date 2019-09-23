package T_1_100;

public class T58 {

//	给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
//	如果不存在最后一个单词，请返回 0 。
//	击败100%
	
    public int lengthOfLastWord(String s) {
        int len = s.length();
        int pos=len-1;
        
        for(;pos>=0;pos--){//找到最后一个不为“ ”的位置
        	if(s.charAt(pos)!=' ')
        		break;
        }
        int end = pos;
        if(pos<0)
        	return 0;
        
        for(;pos>=0;pos--){//找到最后一个“ ”的位置
        	if(s.charAt(pos)==' ')
        		break;
        }
        return end-pos;
    }
    
    
//    相对优雅一些
//    public int lengthOfLastWord(String s) {
//        String tmpStr = s.trim();
//
//        int first = tmpStr.lastIndexOf(' ');
//        if (first==-1)
//            return tmpStr.length();
//        else
//            return tmpStr.length() - 1 - first;
//    }
}
