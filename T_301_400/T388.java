package T_301_400;

public class T388 {

//	给定一个以上述格式表示文件系统的字符串，返回文件系统中文件的最长绝对路径的长度。 如果系统中没有文件，返回 0。
	
//	字符串处理
//	存储最近的每一层的长度即可
    public int lengthLongestPath(String input) {
        
    	int curlen=0;//当前层的长度
    	int[] levellen = new int[30];//记录
    	int max=0;//返回值
    	int curlevel=0;//当前层次
    	boolean hasfile=false;//是否存在文件，即是否包含.
    	
    	for(char c : input.toCharArray()){
    		
    		if(c=='\n'){
    			//-1是统一一下/的计数问题，当前层总长度是上一层的+"/"+当前层的长度
    			levellen[curlevel]=(curlevel>=1?levellen[curlevel-1]:-1)+curlen+1;
    			if(hasfile)//如果文件存在
    				max = Math.max(max, levellen[curlevel]);
    			
//    			恢复状态
    			curlevel=0;
    			curlen=0;
    			hasfile=false;
    		}else if(c=='\t'){//表示层级+1
    			curlevel++;
    		}else{
    			if(c=='.') hasfile=true;//表示存在文件
    			curlen++;//当前层长度+1
    		}
    	}
		if(hasfile)
			max = Math.max(max, (curlevel>=1?levellen[curlevel-1]:-1)+curlen+1);

    	return max;
    	
    }

    
}
