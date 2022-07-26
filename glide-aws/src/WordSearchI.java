
public class WordSearchI {
	
	//same like island for each character going all directions and checking the next leetter present , but not going left and going up down and right.
	   public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				if ((board[i][j] == word.charAt(0)) && dfs(board, i, j, 0, word))
					return true;
		return false;
	  }

	private boolean dfs(char[][] board, int i, int j, int count, String word) {
		if (count == word.length())
			return true;
		if (i == -1 || i == board.length || j == -1 || j == board[0].length || board[i][j] != word.charAt(count)) //if any of those conditions fail we can simple return false.
			return false;
		char temp = board[i][j];
		board[i][j] = '*'; //we  do not want to go same character again what we searching eg:soso
		boolean found = dfs(board, i + 1, j, count + 1, word) ||
				        dfs(board, i - 1, j, count + 1, word) ||
						dfs(board, i, j + 1, count + 1, word) ||
						dfs(board, i, j - 1, count + 1, word);
		board[i][j] = temp;
		return found;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
