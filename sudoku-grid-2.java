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
    
    public static void PrintUnsolvedPuzzle (int difficulty)
    {
        PrintGridLine(1, difficulty);
        PrintGridLine(2, difficulty);
        PrintGridLine(3, difficulty);
        System.out.println(HORIZONTAL_LINE);
        PrintGridLine(4, difficulty);
        PrintGridLine(5, difficulty);
        PrintGridLine(6, difficulty);
        System.out.println(HORIZONTAL_LINE);
        PrintGridLine(7, difficulty);
        PrintGridLine(8, difficulty);
        PrintGridLine(9, difficulty);
    }
    
    /**
     * Print a specific grid line by difficulty
     * @param lineNumber
     * @param difficulty 
     */
    public static void PrintGridLine(int lineNumber, int difficulty)
    {
        String firstThree;
        String secondThree;
        String thirdThree;
        
        if (difficulty == 1)
        {
            switch(lineNumber)
            {
                case 1:
                    firstThree = BuildSetOfThree(BLANK, BLANK
                                            , GetSolutionItem(0,2)); 
                    secondThree = BuildSetOfThree(BLANK, BLANK
                                            , GetSolutionItem(0,5));
                    thirdThree = BuildSetOfThree(GetSolutionItem(0,6)
                                            , GetSolutionItem(0,7)
                                            , BLANK);
                    
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
                case 2:
                    firstThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(1,1)
                                    , BLANK);
                    secondThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(1,4)
                                    , BLANK);
                    thirdThree = BuildSetOfThree(BLANK
                                    , BLANK
                                    , GetSolutionItem(1,8));
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    
                    break;
                case 3:
                    firstThree = BuildSetOfThree(BLANK
                                    , BLANK
                                    , GetSolutionItem(2,2));
                    secondThree = BuildSetOfThree(BLANK
                                    , BLANK
                                    , GetSolutionItem(2,5));
                    thirdThree = BuildSetOfThree(BLANK
                                    , BLANK
                                    , BLANK);
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
                case 4:
                    firstThree = BuildSetOfThree(GetSolutionItem(3,0)
                                    , BLANK
                                    , BLANK);
                    secondThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(3,4)
                                    , BLANK);
                    thirdThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(3,7)
                                    , BLANK);
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
                case 5:
                    firstThree = BuildSetOfThree(GetSolutionItem(4,0)
                                    , GetSolutionItem(4,1)
                                    , BLANK);
                    secondThree = BuildSetOfThree(BLANK
                                    , BLANK
                                    , BLANK);
                    thirdThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(4,7)
                                    , GetSolutionItem(4,8));
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
                case 6:
                    firstThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(5,1)
                                    , BLANK);
                    secondThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(5,4)
                                    , BLANK);
                    thirdThree = BuildSetOfThree(BLANK
                                    , BLANK
                                    , GetSolutionItem(5,8));
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
                case 7:
                    firstThree = BuildSetOfThree(BLANK
                                    , BLANK
                                    , BLANK);
                    secondThree = BuildSetOfThree(GetSolutionItem(6,3)
                                    , BLANK
                                    , BLANK);
                    thirdThree = BuildSetOfThree(GetSolutionItem(6,6)
                                    , BLANK
                                    , BLANK);
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
                case 8:
                    firstThree = BuildSetOfThree(GetSolutionItem(7,0)
                                    , BLANK
                                    , BLANK);
                    secondThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(7,4)
                                    , BLANK);
                    thirdThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(7,7)
                                    , BLANK);
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
                case 9:
                    firstThree = BuildSetOfThree(BLANK
                                    , GetSolutionItem(8,1)
                                    , GetSolutionItem(8,2));
                    secondThree = BuildSetOfThree(GetSolutionItem(8,3)
                                    , BLANK
                                    , BLANK);
                    thirdThree = BuildSetOfThree(GetSolutionItem(8,6)
                                    , BLANK
                                    , BLANK);
                    System.out.printf(GridLine, firstThree
                                        , secondThree
                                        , thirdThree);
                    break;
            }
        }
    }
    
    /**
     * Build a set of three numbers
     * @param x the first number
     * @param y the second number
     * @param z the third number
     * @return 
     */
    public static String BuildSetOfThree(String x, String y, String z)
    {
        return String.format(GridData, x, y, z);
    }
}
