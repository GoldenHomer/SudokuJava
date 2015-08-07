// A work in progress; code is terrible now. That will change.
import java.util.Arrays;
import java.util.*;

public class SudokuGrid {
    /*
    final static String ONE = "1";
    final static String TWO = "2";
    final static String THREE = "3";
    final static String FOUR = "4";
    final static String FIVE = "5";
    final static String SIX = "6";
    final static String SEVEN = "7";
    final static String EIGHT = "8";
    final static String NINE = "9";
    final static String BLANK = " ";
    */
    
    static Scanner input;
    final static int gridResetNumber = -999999998;
    final static int eEGGNumber = -999999999;
     private static SudokuGrid _gameBoard;
    
    //THE GAMEBOARD IS A 2-Dimensional Array.
    //Again, the ONLY time an MD Array is a good idea is when you have a grid
    //of identical items.  Here, a 9x9 grid of numbers does the trick for us
    static String[][] gameBoard;
    static String[][] solutionBoard;
    
    public static void main(String[] args)
    {
        System.out.println("Welcome to Sudoku!");
        
         _gameBoard = new SudokuGrid();
        System.out.println(_gameBoard.toString());
        
        input = new Scanner(System.in);
        while(!_gameBoard.IsSolved())
        {
            //get user input
            boolean success = GatherInput();
            //print the grid after each entry so the user sees the updates
            System.out.println(_gameBoard.toString());
            if (!success)
            {
                System.out.println("Your last input was invalid.  Please try again!");
            }
        }
        
        //end the program.
        System.out.println("Great job!");
    }
    
   /**
     * Print the current grid with whatever values exist.
     */
    public static void PrintCurrentGrid()
    {
        System.out.println(Stars(50));
        for (int i = 1; i < 10; i++)
        {
            for (int j = 1; j < 10; j++)
            {
                System.out.print(gameBoard[i-1][j-1]);
                if (j % 3 == 0)
                {
                    System.out.print("|");
                }
                else
                {
                    System.out.print(":");
                }
            }
            System.out.println("");
            if (i % 3 == 0)
            {
                System.out.println(HORIZONTAL_LINE);
            }
        }
        System.out.println(Stars(50));
    }
    
     /**
     * Check if the grid is solved.
     * @return 
     */
    public static boolean CheckIfSolved()
    {
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                if (gameBoard[i][j].equals(BLANK) || !gameBoard[i][j].equals(solutionBoard[i][j]))
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Get input from the user for a position to solve
     */
    public static void GatherInput()
    {
        int row = GetIntWithPrompt("Enter coordinate row of "
                + "new value 0 - 8:", 0, 8);
        //int row = input.nextInt();
        int col = GetIntWithPrompt("Enter coordinate column of "
                + "new value 0 - 8:", 0, 8);
        //int col = input.nextInt();
        //input.nextLine();
        
        int userVal = GetIntWithPrompt("Enter the value for this position:", 1, 9);
        
        if (userVal == eEGGNumber)
        {
            //EASTER EGG
            SolveIt();
        }
        else
        {
            String val = String.format("%d", userVal);
            
            //we are not going to validate.  We'll let the user do whatever
            //they want here.  This is more accurate to the game play.
            //Later we'll figure out ways to quickly solve
            //in fact, at this point nothing is locked down so the user can actually
            //overwrite one of the solution items.
            SetItemInGrid(row, col, val);
        }
        //print the grid after each entry so the user sees the updates
        PrintCurrentGrid();
    }
    
    /**
     * Get an integer with a prompt.
     * @param prompt prompt to the user
     * @param minInt range limiter minimum value
     * @param maxInt range limiter max value
     * @return 
     */
    public static int GetIntWithPrompt(String prompt, int minInt, int maxInt)
    {
        int result = -1;
        boolean isValid = false;
        while (!isValid)
        {
            System.out.println(prompt);
            String val = input.nextLine();
            if (val.trim().toUpperCase().equals("SOLVE_FOR_ME"))
            {
                //EASTER EGG
                return eEGGNumber;
            }
            else if (val.trim().toUpperCase().equals("-1"))
            {
                //let the user get out
                return -1;
            }
            else if (val.trim().toUpperCase().equals("RESET"))
            {
                //reset the board to start condition
                return gridResetNumber;
            }
            isValid = Common.ValidateNumber(val);
            if (!isValid)
            {
                continue;
            }
            
            //can parse, but validate by range
            result = Integer.parseInt(val);
            if (result < minInt || result > maxInt)
            {
                isValid = false;
                result = -1;
            }
        }
        return result;
    }
    
    /**
     * Validate a statement with y/n input expected
     * @param prompt Output to user
     * @return true if user response is y, else false
     */
    public static boolean ValidateYN(String prompt)
    {
        boolean isValid = false;
        boolean validated = false;
        while (!isValid)
        {
            System.out.println(prompt);
            String response = input.nextLine();
            String rCharStr = Common.GetFirstCharAsString(response);
            if (rCharStr.toUpperCase().equals("Y"))
            {
                isValid = true; 
                validated = true;
            }
            else if(rCharStr.toUpperCase().equals("N"))
            {
                isValid = true;
                validated = false;
            }
            else
            {
                System.out.println("Invalid response. "
                                        + "Please enter 'Y' or 'N'");
            }
        }
        return validated;
    }
    
}
