package cosc592.slidingpuzzle;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    AppInterface appInterface;
    Game game;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButtonHandler buttonHandler = new ButtonHandler();
        appInterface = new AppInterface(this, buttonHandler);
        setContentView(appInterface);
        game = new Game();
        appInterface.generateInitialBoard(game.board);
        appInterface.generateGoalBoard(game.goal);
    }

    private class ButtonHandler implements View.OnClickListener{
        public void onClick(View v){

            int buttonPressed = appInterface.findButton((Button)v);
            if(buttonPressed == 1){
                game.up();
                appInterface.generateInitialBoard(game.board);
            }else if(buttonPressed == 2){
                game.down();
                appInterface.generateInitialBoard(game.board);
            }else if(buttonPressed == 3){
                game.right();
                appInterface.generateInitialBoard(game.board);
            }else if(buttonPressed == 4){
                game.left();
                appInterface.generateInitialBoard(game.board);
            }else{}
            char[][] gameBoard = game.getBoard();
            char[][] gameGoal = game.getGoal();
            int numCorrect = 0;
            for(int i = 0 ; i< 3 ; i++){
                for(int j = 0 ; j < 3 ; j++){
                    if(gameBoard[i][j] == gameGoal[i][j]){
                        numCorrect = numCorrect+1;
                    }
                    else{
                        numCorrect = numCorrect;
                    }
                }
            if(numCorrect == 9) {
                Toast.makeText( getApplicationContext(), "You won", Toast.LENGTH_SHORT ).show();
            }}}}}