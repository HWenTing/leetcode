package T_101_200;

public class T109 {
	
//	将有序链表转换为	高度平衡bst。
//	第一想法是将链表转换成数组，再做  空间换时间
//	。。。。很慢，空间也很大
	
//    public TreeNode sortedListToBST(ListNode head) {
//        List<Integer> nums = new ArrayList<>();
//        while(head!=null){
//        	nums.add(head.val);
//        	head = head.next;
//        }
//        return subSortedArrayToBST(nums,0,nums.size());
//    }
//    
//    private TreeNode subSortedArrayToBST(List<Integer> nums,int start,int end){
//    	int len = end-start;
//    	if(len<=0)return null;
//    	int mid = (start+end)/2;
//    	TreeNode root = new TreeNode(nums.get(mid));
//    	root.left = subSortedArrayToBST(nums, start, mid);
//    	root.right = subSortedArrayToBST(nums, mid+1, end);
//    	return root;
//    }
	
//	使用快慢指针寻找中点，断开，递归处理左右两个链表为左右连个子树。
	
	public TreeNode sortedListToBST(ListNode head) {
		if(head==null)return null;
		if(head.next==null) return new TreeNode(head.val);
		
		ListNode premid = findpremid(head);
		ListNode mid = premid.next;
		premid.next=null;
		TreeNode root = new TreeNode(mid.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(mid.next);
		return root;
	}
	
	private ListNode findpremid(ListNode head){//快慢指针法寻找链表中点(若偶数个节点返回后一个)的前一个节点

		ListNode fast = head;
		ListNode slow = head;
		ListNode pre = head;
		while(fast!=null && fast.next!=null){
			pre = slow;
			fast = fast.next.next;
			slow=slow.next;
		}
		return pre;
	}
}
