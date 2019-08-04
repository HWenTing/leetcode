package T_201_300;

public class T208 {
//	实现 Trie (前缀树)空间换时间 每个节点多都有26个子节点，根节点为空
    /** Initialize your data structure here. */
	
	private class Node{
		Node[] childs=new Node[26];
		boolean ifLeaf;
	}
	
	private Node root = new Node();
    public T208() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(word,root);
    }
    
    private void insert(String word,Node node){
    	if(node==null)
    		return;
    	if(word.length()==0){
    		node.ifLeaf=true;
    		return;
    	}
    	int pos = word.charAt(0)-'a';
    	if(node.childs[pos]==null)
    		node.childs[pos] = new Node();
    	insert(word.substring(1),node.childs[pos]);
    	
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	return search(word,root);
    }
    private boolean search(String word,Node node){
    	if(node==null)
    		return false;
    	if(word.length()==0)
    		return node.ifLeaf;
    	return search(word.substring(1),node.childs[word.charAt(0)-'a']);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	return startsWith(prefix,root);
    }
    
    private boolean startsWith(String word,Node node){
    	if(node==null)
    		return false;
    	if(word.length()==0)
    		return true;
    	return startsWith(word.substring(1),node.childs[word.charAt(0)-'a']);
    }
    
}
