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
        
        String horizontalLine =  "XXXXXXXXXXXXXXXXXXXXX";
        String one = "1";
        String two = "2";
        String three = "3";
        String four = "4";
        //String five = "5";
        String six = "6";
        String seven = "7";
        String eight = "8";
        String nine = "9";
        //we can use String.format to make a replacement pattern (just like
        // if the pattern was in our printf statement):
        String gridData = "%s:%s:%s";
        
        //String part1 = String.format(gridData, one, two, three);
        
        // Removing all fives
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, one, two, three)
                            , String.format(gridData, four, blank, six)
                            , String.format(gridData, seven, eight, nine));
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, four, blank, six)
                            , String.format(gridData, seven, eight, nine)
                            , String.format(gridData, one, two, three));
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, seven, eight, nine)
                            , String.format(gridData, one, two, three)
                            , String.format(gridData, four, blank, six));
        System.out.println(horizontalLine);
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, two, three, four)
                            , String.format(gridData, blank, six, seven)
                            , String.format(gridData, eight, nine, one));
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, blank, six, seven)
                            , String.format(gridData, eight, nine, one)
                            , String.format(gridData, two, three, four));
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, eight, nine, one)
                            , String.format(gridData, two, three, four)
                            , String.format(gridData, blank, six, seven));
        System.out.println(horizontalLine);
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, three, four, blank)
                            , String.format(gridData, six, seven, eight)
                            , String.format(gridData, nine, one, two));
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, six, seven, eight)
                            , String.format(gridData, nine, one, two)
                            , String.format(gridData, three, four, blank));
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, nine, one, two)
                            , String.format(gridData, three, four, blank)
                            , String.format(gridData, six, seven, eight));
        
        int twoTwo;
        int oneFive;
        int threeEight;
        int fourFour;
        int fiveOne;
        int sixSeven;
        int sevenThree;
        int eightNine;
        int nineSix;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("What is the value for grid one slot five?");
        oneFive = input.nextInt();
        
        System.out.println("What is the value for grid two slot two?");
        twoTwo = input.nextInt();
        
        System.out.println("What is the value for grid three slot eight?");
        threeEight = input.nextInt();
        
        System.out.println("What is the value for grid four slot four?");
        fourFour = input.nextInt();
        
        System.out.println("What is the value for grid five slot one?");
        fiveOne = input.nextInt();
        
        System.out.println("What is the value for grid six slot seven?");
        sixSeven = input.nextInt();
        
        System.out.println("What is the value for grid seven slot three?");
        sevenThree = input.nextInt();
        
        System.out.println("What is the value for grid eight slot nine?");
        eightNine = input.nextInt();
        
        System.out.println("What is the value for grid nine slot six?");
        nineSix = input.nextInt();
        
        //now reprint the grid with user output:
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, one, two, three)
                            , String.format(gridData, four, oneFive, six)
                            , String.format(gridData, seven, eight, nine));
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, four, twoTwo, six)
                            , String.format(gridData, seven, eight, nine)
                            , String.format(gridData, one, two, three));
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, seven, eight, nine)
                            , String.format(gridData, one, two, three)
                            , String.format(gridData, four, threeEight, six));
        System.out.println(horizontalLine);
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, two, three, four)
                            , String.format(gridData, fourFour, six, seven)
                            , String.format(gridData, eight, nine, one));
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, fiveOne, six, seven)
                            , String.format(gridData, eight, nine, one)
                            , String.format(gridData, two, three, four));
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, eight, nine, one)
                            , String.format(gridData, two, three, four)
                            , String.format(gridData, sixSeven, six, seven));
        System.out.println(horizontalLine);
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, three, four, sevenThree)
                            , String.format(gridData, six, seven, eight)
                            , String.format(gridData, nine, one, two));
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, six, seven, eight)
                            , String.format(gridData, nine, one, two)
                            , String.format(gridData, three, four, eightNine));
        System.out.printf("%s | %s | %s\n"
                            , String.format(gridData, nine, one, two)
                            , String.format(gridData, three, four, nineSix)
                            , String.format(gridData, six, seven, eight));
        
        System.out.println("Puzzle complete, did you get it right?");
        input.close();
    }
}
