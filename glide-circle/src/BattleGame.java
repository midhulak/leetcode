import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BattleGame {
	
	public static void play(String PlayerOneShips, List<String> PlayerTwoGuesses) {
	    String[] splitShips = PlayerOneShips.split(" ");
	    Map<Character, Integer> rowToInt = new HashMap<>();
	    rowToInt.put('A', 1);
	    rowToInt.put('B', 2);
	    rowToInt.put('C', 3);
	    rowToInt.put('D', 4);
	    rowToInt.put('E', 5);
	    rowToInt.put('F', 6);
	    
	    Map<Character, Integer> colToInt = new HashMap<>();
	    colToInt.put('1', 1);
	    colToInt.put('2', 2);
	    colToInt.put('3', 3);
	    colToInt.put('4', 4);
	    colToInt.put('5', 5);
	    colToInt.put('6', 6);
	    
	    int[][]board = new int[6][6];
	    for(int i=0;i<6;i++) {
	        for (int j=0;j<6;j++) {
	            board[i][j] = 0;
	        }
	    }
	    
	    int totalTargets = 0;
	    for (int i=0;i<splitShips.length;i=i+2) {
	        int row1 = rowToInt.get(splitShips[i].charAt(0))-1;
	        int col1 = colToInt.get(splitShips[i].charAt(1))-1;
	        
	        int row2 = rowToInt.get(splitShips[i+1].charAt(0))-1;
	        int col2 = colToInt.get(splitShips[i+1].charAt(1))-1;
	        
	        for (int row = row1;row<=row2;row++) {
	            for (int col = col1;col<=col2;col++) {
	                board[row][col] = 1;
	                totalTargets++;
	            }
	        }
	    }
	    
	    System.out.println("Player One entered " + splitShips.length/2 + " ships.");
	    int guesses = 10;
	    int index = 0;
	    int correctGuesses = 0;
	    while (guesses > 0 && index < PlayerTwoGuesses.size()) {
	        System.out.println("Player Two, you have " + guesses + " left.");
	        System.out.println("Board status:");
	        for (int row=0;row<6;row++) {
	            for (int col=0;col<6;col++) {
	                if (board[row][col] == 0) {
	                    System.out.print(".");
	                } else if (board[row][col] == 1) {
	                    System.out.print(".");
	                } else if (board[row][col] == 2) {
	                    System.out.print("X");
	                } else if (board[row][col] == 3) {
	                    System.out.print("O");
	                }
	            }
	            System.out.println();
	        }
	        System.out.print("Player Two, please enter your guess: " + PlayerTwoGuesses.get(index));
	        int row = rowToInt.get(PlayerTwoGuesses.get(index).charAt(0))-1;
	        int col =  colToInt.get(PlayerTwoGuesses.get(index).charAt(1))-1;
	        
	        if (board[row][col] == 0) {
	            board[row][col] = 3;
	            System.out.println("That was a miss!");
	        } else if (board[row][col] == 1) {
	            board[row][col] = 2;
	            correctGuesses++;
	            System.out.println("That was a hit!");
	        }
	        guesses--;
	        index++;
	    }
	    
	    if (correctGuesses == totalTargets) {
	        System.out.println("you win!");
	        return;
	    }
	    System.out.println("you lose!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String PlayerOneShips = "A1 A3 D5 F5";
      List<String> list = new ArrayList<>();
      
		list.add("A2");
		list.add("A3");
		list.add("A4");
		list.add("A3");
		list.add("F4");
		list.add("A1");
		list.add("D5");
		list.add("E5");
		list.add("F5");
		
		
		play(PlayerOneShips , list);
	}

}
