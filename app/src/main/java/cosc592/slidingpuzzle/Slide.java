package cosc592.slidingpuzzle;

import java.util.Random;

public class Slide
{
    private final char BLANK = ' ';
    private Random random;

    public Slide()
    {
        random = new Random();
    }
    private char[][] createBoard(){
        char[] array = {'0','1','2','3','4','5','6','7','8'};
        char[] shuffledArray = shuffleArray(array);
        char[][]returnArray = {{shuffledArray[0],shuffledArray[1], shuffledArray[2]},{shuffledArray[3],shuffledArray[4], shuffledArray[5]},{shuffledArray[6],shuffledArray[7], shuffledArray[8]}};
        return returnArray;
    }
    private char[][] createBoard2(){
        char[] array = {'0','1','2','3','4','5','6','7','8'};
        char[][]returnArray = {{array[0],array[1], array[2]},{array[3],array[4], array[5]},{array[6],array[7], array[8]}};
        return returnArray;
    }
    public char[][] generateInitialBoard()
    {
        char[][] board = new char[3][3];

        int[] list = createList();

        int k = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
            {
                if (list[k] == 0)
                    board[i][j] = BLANK;
                else
                    board[i][j] = (char)('0' + list[k]);

                k++;
            }

        return board;
    }

    public char[][] generateGoalBoard()
    {
        char[][] board = new char[3][3];

        int k = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = (char)('0' + k + 1);
                k++;
            }

        board[2][2] = BLANK;

        return board;
    }
    private static char[] shuffleArray(char[] array)
    {
        int index;
        char temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }
    private int[] createList()
    {
        int[] list = new int[9];

        for (int i = 0; i < 9; i++)
            list[i] = i;

        int k = 8;
        for (int i = 0; i < 9; i++)
        {
            int j = random.nextInt(k+1);

            int temp = list[j];
            list[j] = list[k];
            list[k] = temp;

            k = k - 1;
        }

        return list;
    }
}
