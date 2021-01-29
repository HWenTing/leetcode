package T_901_1000;

import java.util.Arrays;
import java.util.Stack;

public class T912 {

	/**
	 * 给你一个整数数组 nums，请你将该数组升序排列。
	 * 
	 */

	/*
	 * 冒泡排序
	 * 
	 * len = 10000 125ms
	 */
	public int[] sortArrayBubble(int[] nums) {
		if (nums.length <= 1)
			return nums;

		int len = nums.length;
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (nums[j] > nums[j + 1]) {// 比较相邻的元素，大的下沉
					int swap = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = swap;
				}
			}
		}
		return nums;
	}

	/**
	 * 插入排序
	 * 
	 * len = 10000 13ms
	 */
	public int[] sortArrayInsert(int[] nums) {
		if (nums.length <= 1)
			return nums;

		int len = nums.length;
		for (int i = 1; i < len; i++) {
			int j = i;
			int cur = nums[j];
			while (j > 0 && cur < nums[j - 1]) {// 拿出当前位置，依次和前面的元素比，直到找到应该的位置
				nums[j] = nums[j - 1];
				j--;
			}
			nums[j] = cur;
		}
		return nums;
	}

	/**
	 * 选择排序
	 * 
	 * len = 10000 31ms
	 */
	public int[] sortArraySelect(int[] nums) {
		if (nums.length <= 1)
			return nums;
		int len = nums.length;

		for (int i = 0; i < len; i++) {
			int minpos = i;
			for (int j = i; j < len; j++) {// 每次选择剩余元素最小的
				if (nums[j] < nums[minpos])
					minpos = j;
			}
			int temp = nums[i];
			nums[i] = nums[minpos];
			nums[minpos] = temp;
		}
		return nums;
	}

	/**
	 * shell排序
	 * 
	 * len = 10000 10ms
	 */

	public int[] sortArrayShell(int[] nums) {
		int[] intervals = new int[] { 5, 3, 1 };
		for (int interval : intervals) {
			for (int i = 0; i < nums.length; i++) {
				select(nums, i, interval);
			}
		}
		return nums;
	}

	private void select(int[] nums, int start, int interval) {
		int cur = nums[start];
		int before = start - interval;
		while (before >= 0 && cur < nums[before]) {
			nums[before + interval] = nums[before];
			before -= interval;
		}
		nums[before + interval] = cur;
	}

	/**
	 * 归并排序
	 * 
	 * len = 10000 2.68ms
	 */

	public int[] sortArrayMerge(int[] nums) {
		if (nums.length <= 1)
			return nums;

		int len = nums.length;
		int[] temp = new int[len];// 备用数组
		mergeSort(nums, 0, len - 1, temp);
		return nums;
	}

	private void mergeSort(int[] nums, int left, int right, int[] temp) {
		if (right <= left)
			return;

		int mid = (right - left) / 2 + left;
		mergeSort(nums, left, mid, temp);// 分而治之
		mergeSort(nums, mid + 1, right, temp);// 分而治之

		int pos = left, l = left, r = mid + 1;

		// 合并
		while (l <= mid && r <= right) {
			if (nums[l] <= nums[r])
				temp[pos++] = nums[l++];
			else
				temp[pos++] = nums[r++];
		}

		while (l <= mid)
			temp[pos++] = nums[l++];
		while (r <= right)
			temp[pos++] = nums[r++];

		// 从备用数组复制回来
		for (int i = left; i <= right; i++)
			nums[i] = temp[i];
	}

	/**
	 * 非递归归并排序
	 * 
	 * len = 10000 3ms
	 */

	public int[] sortArray(int[] nums) {
		int[] copy = new int[nums.length];

		int k = 1;
		while (k <= nums.length) {
			for (int i = 0; i < nums.length; i += 2 * k) {
				int left = i;
				int right = i + k;
				if (right > nums.length)
					continue;
				int end = Math.min(right + k, nums.length);
				merge(nums, copy, left, right, end);
			}
			k *= 2;
		}
		return nums;
	}

	private void merge(int[] nums, int[] copy, int left, int right, int end) {
		int begin = left;
		int pos = left;
		int mid = right;
		while (left < mid && right < end) {
			if (nums[left] <= nums[right])
				copy[pos++] = nums[left++];
			else
				copy[pos++] = nums[right++];
		}
		while (left < mid)
			copy[pos++] = nums[left++];

		for (int i = begin; i < pos; i++)
			nums[i] = copy[i];
	}

	/**
	 * 快排排序
	 * 
	 * len = 10000 1.81ms
	 */

	public int[] sortArrayQuick(int[] nums) {
		if (nums.length <= 1)
			return nums;
		quickSort(nums, 0, nums.length - 1);
		return nums;
	}

	private void quickSort(int[] nums, int begin, int end) {
		if (end <= begin)
			return;

		int x = nums[begin];// 选择基准值，这里选择第一个元素
		int left = begin, right = end;// 两个哨兵
		while (left < right) {
			while (left < right && nums[right] >= x) {// 从右往左找小于基准值的
				right--;
			}
			if (left < right) {// 找到的话放到左边
				nums[left] = nums[right];
				left++;
			}

			while (left < right && nums[left] <= x) {// 从左往右找大于基准值的
				left++;
			}
			if (left < right) {// 找到的话放到右边边
				nums[right] = nums[left];
				right--;
			}
		}
		nums[left] = x;// 将基准值放在应该在的位置
		quickSort(nums, begin, left - 1);
		quickSort(nums, left + 1, end);
	}

	/**
	 * 非递归快排
	 */
	public int[] sortArrayQuickNoRecursion(int[] nums) {
		Stack<int[]> st = new Stack<>();
		st.add(new int[] { 0, nums.length - 1 });
		while (!st.isEmpty()) {
			int[] cur = st.pop();
			int begin = cur[0];
			int end = cur[1];

			if (end <= begin)
				continue;

			int x = nums[begin];// 选择基准值，这里选择第一个元素
			int left = begin, right = end;// 两个哨兵
			while (left < right) {
				while (left < right && nums[right] >= x) {// 从右往左找小于基准值的
					right--;
				}
				if (left < right) {// 找到的话放到左边
					nums[left] = nums[right];
					left++;
				}

				while (left < right && nums[left] <= x) {// 从左往右找大于基准值的
					left++;
				}
				if (left < right) {// 找到的话放到右边边
					nums[right] = nums[left];
					right--;
				}
			}
			nums[left] = x;// 将基准值放在应该在的位置
			st.push(new int[] { begin, left - 1 });
			st.push(new int[] { left + 1, end });
		}
		return nums;
	}

	/**
	 * 堆排序 将无序数组构造成一个大根堆，然后将堆顶元素与末尾元素交换，然后调整成为大根堆，重复交换的步骤
	 * 
	 * len = 10000 1.8ms
	 */
	public int[] sortArrayHeap(int[] nums) {
		if (nums.length <= 1)
			return nums;

		int len = nums.length;
		for (int i = len / 2 - 1; i >= 0; i--) {// 建堆,从第一个有孩子的节点开始
			adjust(nums, i, len - 1);
		}

		for (int i = 0; i < len - 1; i++) {
			swap(nums, 0, len - 1 - i);// 将大根堆的第一个元素（最大）与最后节点交换。
			adjust(nums, 0, len - i - 2);// 调整[0, len - i - 2]范围内为大根堆
		}
		return nums;
	}

	// private void adjust(int[] nums, int pos, int end) {
	// int leftChild = (pos + 1) * 2 - 1 > end ? Integer.MIN_VALUE : nums[(pos +
	// 1) * 2 - 1];// 根据下标找到左孩子
	// int rightChild = (pos + 1) * 2 > end ? Integer.MIN_VALUE : nums[(pos + 1)
	// * 2];// 根据下标找到右孩子
	// if (Math.max(leftChild, rightChild) > nums[pos]) {//
	// 如果小于子孩子，那么与子孩子最大节点交换，并递归构造子树
	// if (leftChild < rightChild) {
	// swap(nums, pos, (pos + 1) * 2);
	// adjust(nums, (pos + 1) * 2, end);
	// } else {
	// swap(nums, pos, (pos + 1) * 2 - 1);
	// adjust(nums, (pos + 1) * 2 - 1, end);
	// }
	// }
	// }

	// 不用递归更快一点
	public static void adjust(int[] nums, int i, int length) {
		int temp = nums[i];// 先取出当前元素i
		for (int k = i * 2 + 1; k <= length; k = k * 2 + 1) {// 从i结点的左子结点开始，也就是2i+1处开始
			if (k + 1 <= length && nums[k] < nums[k + 1]) {// 如果左子结点小于右子结点，k指向右子结点
				k++;
			}
			if (nums[k] > temp) {// 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
				nums[i] = nums[k];
				i = k;
			} else {
				break;
			}
		}
		nums[i] = temp;// 将temp值放到最终的位置
	}

	private void swap(int[] nums, int pos, int i) {
		int temp = nums[pos];
		nums[pos] = nums[i];
		nums[i] = temp;
	}

	/**
	 * 计数排序
	 * 
	 * 1000000范围内len = 10000 6ms 范围越紧凑越快
	 */

	public int[] sortArrayCount(int[] nums) {
		if (nums.length <= 1)
			return nums;
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i : nums) {
			max = Math.max(max, i);
			min = Math.min(min, i);
		}

		int[] box = new int[max - min + 1];
		for (int i : nums)
			box[i - min]++;
		int pos = 0;
		for (int i = 0; i < box.length; i++) {
			while (box[i] > 0) {
				nums[pos++] = i + min;
				box[i]--;
			}
		}
		return nums;
	}

	/**
	 * len = 10000 1.81ms
	 */
	public int[] sortArrayJDK(int[] nums) {
		Arrays.sort(nums);
		return nums;
	}

}
