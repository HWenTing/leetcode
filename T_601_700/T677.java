package T_601_700;

public class T677 {

//	字典树的应用
	private class Node{
		Node[] childs=new Node[26];
		int sum;
	}
	
    public T677() {
    	
    }
	private Node root = new Node();
    public void insert(String key, int val) {
    	insert(key,root,val);
    }
    
    private void insert(String word,Node node,int val){//将val赋值到叶节点
    	if(node==null)
    		return;
    	if(word.length()==0){
    		node.sum=val;
    		return;
    	}
    	int pos = word.charAt(0)-'a';
    	if(node.childs[pos]==null)
    		node.childs[pos] = new Node();
    	insert(word.substring(1),node.childs[pos],val);
    	
    }
    public int sum(String prefix) {
    	return sum(prefix,root);
    }
    
    private int  sum(String word,Node node){
    	if(node==null)
    		return 0;
    	if(word.length()!=0){
    		return sum(word.substring(1),node.childs[word.charAt(0)-'a']);//迭代到前缀位置
    	}
    	int sum = node.sum;//先计算前缀的权重
    	for(int i=0;i<26;i++){//再加上以当前前缀为前缀的权重
    		sum+=node.childs[i]==null?0:sum("",node.childs[i]);
    	}
    	return sum;
    }
    
    
}
