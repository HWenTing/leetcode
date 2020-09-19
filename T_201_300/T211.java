package T_201_300;


public class T211 {

//	如果数据结构中有任何与word匹配的字符串，则bool search（word）返回true，否则返回false。 单词可能包含点“。” 点可以与任何字母匹配的地方。
//	请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。

//	字典树
	
	private class Node{
		Node[] childs=new Node[26];
		boolean ifLeaf;
	}
	private Node root;
    /** Initialize your data structure here. */
    public T211() {
    	root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	insert(word,root,0);
    }
    private void insert(String word,Node node,int index){
    	if(index==word.length()){
    		node.ifLeaf=true;
    		return;
    	}
    	int pos = word.charAt(index)-'a';
    	if(node.childs[pos]==null)
    		node.childs[pos] = new Node();
    	insert(word,node.childs[pos],index+1);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	return search(word,root,0);
    }
    private boolean search(String word,Node node,int index){
    	if(node==null)
    		return false;
    	if(word.length()==index)
    		return node.ifLeaf;
    	
    	if(word.charAt(index)=='.'){
    		boolean ret = false;
    		for(int i=0;!ret&&i<26;i++){
    			ret = ret | search(word,node.childs[i],index+1);
    		}
    		return ret;
    	}else{
    		return search(word,node.childs[word.charAt(index)-'a'],index+1);
    	}
    	
    }
}
