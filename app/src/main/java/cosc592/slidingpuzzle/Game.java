package cosc592.slidingpuzzle;

import java.util.Random;

public class Game {
    private final char BLANK = '0';
    public char[][] board = {};
    public char[][] goal = {};
    private int x,y;

    public Game(){
        board = createBoard();
      goal = createBoard2();
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3; j++){
                if(board[i][j] == BLANK){
                    x = i;
                    y = j;
                }}} }
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
    public char[][] getBoard(){
        return  board;
    }
    public char[][] getGoal(){
        return goal;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void up(){
        if(x - 1 >= 0){
            board[x][y] = board[x-1][y];
            board[x-1][y] = BLANK;
            x = x-1;
        } }
    public void down(){
        if(x+1 <= 2){
            board[x][y] = board[x+1][y];
            board[x+1][y] = BLANK;
            x = x+1;
        } }
    public void right(){
        if(y+1 <= 2){
            board[x][y] = board[x][y+1];
            board[x][y+1] = BLANK;
            y = y+1;
        } }
    public void left(){
        if(y - 1 >= 0){
            board[x][y] = board[x][y-1];
            board[x][y-1] = BLANK;
            y = y-1;
        } }
}