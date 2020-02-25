package T_401_500;

public class T419 {

//	给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：
//	给你一个有效的甲板，仅由战舰或者空位组成。
//	战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
//	两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。

//	一艘战舰只对右下角进行一次计数即可
    public int countBattleships(char[][] board) {
        
    	int cnt = 0;
    	int row = board.length;
    	int col = board[0].length;
    	for(int i=0;i<row;i++){
    		for(int j=0;j<col;j++){
    			if(board[i][j]=='X'){
    				if((i==row-1|| board[i+1][j]=='.') && (j==col-1 ||board[i][j+1]=='.' ))//判断当前X的下方和右方是否还存在X
    					cnt++;
    			}
    		}
    	}
    	return cnt;
    }
    
}
