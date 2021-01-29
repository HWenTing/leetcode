package InterviewBook;

public class T0107 {

	/**
	 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
	 * 
	 * 不占用额外内存空间能否做到？
	 * 
	 * 一次交换四个
	 */

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		if (n <= 1)
			return;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n - i - 1; j++) {
				int up = matrix[i][j];
				int right = matrix[j][n - i - 1];
				int down = matrix[n - i - 1][n - j - 1];
				int left = matrix[n - j - 1][i];

				matrix[i][j] = left;
				matrix[j][n - i - 1] = up;
				matrix[n - i - 1][n - j - 1] = right;
				matrix[n - j - 1][i] = down;
			}
		}
	}

}
