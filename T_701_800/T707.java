package T_701_800;

class DListNode{
	int val;
	DListNode next;
	DListNode before;
	public DListNode(int val){
		this.val=val;
	}
}
public class T707 {
//设计双向链表，支持插入删除等操作
	
	DListNode head=null;
	DListNode end=null;
	int size=0;
    /** Initialize your data structure here. */
    public T707() {
    	
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index<0 || index>=size)
        	return -1;
        
        DListNode temp=head;
        while(index>0){
        	temp=temp.next;
        	index--;
        }
        return temp.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
    	if(head==null){
    		head = new DListNode(val);
    		end = head;
    	}else{
    		DListNode tempnext=head;
    		head = new DListNode(val);
    		head.next = tempnext;
    		tempnext.before=head;
    	}
    	size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	if(head==null){
    		head = new DListNode(val);
    		end = head;
    	}else{
    		DListNode tempend = end;
    		end = new  DListNode(val);
    		end.before=tempend;
    		tempend.next=end;
    	}
    	size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index==size){
        	addAtTail(val);
        	return;
        }else if(index<=0){
        	addAtHead(val);
        }else if(index>size){
        	return ;
        }else{
            DListNode temp=head;
            index--;
            while(index>0){
            	temp=temp.next;
            	index--;
            }
            DListNode newNode = new DListNode(val);
            newNode.next=temp.next;
            temp.next.before=newNode;
            temp.next=newNode;
            newNode.before=temp;
            size++;
        }

    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index<0 || index>=size)
        	return ;
        else if(index==0 && index == size-1){
        	head=end=null;
        }else if(index==0){
        	head=head.next;
        }else if(index == size-1){
        	end=end.before;
        }else{
        	DListNode temp=head;
            index--;
            while(index>0){
            	temp=temp.next;
            	index--;
            }
            temp.next.next.before=temp;
            temp.next = temp.next.next;
        }
        size--;
    }
    
}
