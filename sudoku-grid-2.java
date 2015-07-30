import java.util.*;

public class SudokuGrid {
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
    final static String HORIZONTAL_LINE = "XXXXXXXXXXXXXXXXXXXXX";
    static String GridLine = "%s | %s | %s\n";
    static String GridData = "%s:%s:%s";
    static Scanner input;
    
    public static void main(String[] args)
    {
        System.out.println("Welcome to Sudoku!");
        System.out.println(HORIZONTAL_LINE);
        input = new Scanner(System.in);
        PrintUnsolvedPuzzle(1);
        
        // Gather input a few times, but we aren't solving yet
        // Too hard to track at this point
        GatherInput();
        GatherInput();
        GatherInput();
        GatherInput();
        GatherInput();
        //etc...
        // Doesn't it seem like there should be a better way?
        // How would we possibly know how many gathers
        // If the user gets many wrong?
    }
}
