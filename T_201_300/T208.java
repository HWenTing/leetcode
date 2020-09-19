package T_201_300;

public class T208 {
//	实现 Trie (前缀树)空间换时间 每个节点多都有26个子节点，根节点为空
    /** Initialize your data structure here. */
	private class Node{
		Node[] childs=new Node[26];
		boolean ifLeaf;
	}
	
	private Node root;
    public T208() {
    	root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	return search(word,root,0);
    }
    private boolean search(String word,Node node,int index){
    	if(node==null)
    		return false;
    	if(word.length()==index)
    		return node.ifLeaf;
    	return search(word,node.childs[word.charAt(index)-'a'],index+1);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	return startsWith(prefix,root,0);
    }
    
    private boolean startsWith(String word,Node node,int index){
    	if(node==null)
    		return false;
    	if(word.length()==index)
    		return true;
    	return startsWith(word,node.childs[word.charAt(index)-'a'],index+1);
    }
    
}
