public class SudokuGrid2 {
    public static void main(String[] args)
    {
        //take a look for a repeating pattern in the previous output:
        /*
            1:2:3 | 4:5:6 | 7:8:9
            4:5:6 | 7:8:9 | 1:2:3
            7:8:9 | 1:2:3 | 4:5:6
            ---------------------
            2:3:4 | 5:6:7 | 8:9:1
            5:6:7 | 8:9:1 | 2:3:4
            8:9:1 | 2:3:4 | 5:6:7
            ---------------------
            3:4:5 | 6:7:8 | 9:1:2
            6:7:8 | 9:1:2 | 3:4:5
            9:1:2 | 3:4:5 | 6:7:8
            
            * %s | %s | %s
            * %s:%s:%s
         
         Notice, it is number colon, number colon, number
         if we were doing a printf, this would be "%s:%s:%s", provided
         our data is stored as a string.  Now, obviously this isn't the ONLY
         solution for Sudoku, so we want to be flexible in our output.
         
         Therefore, here we are going to learn a way to format a string, and
         use that format over and over to complete our task!
         
         */
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
