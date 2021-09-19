package cosc592.slidingpuzzle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import java.text.NumberFormat;

public class AppInterface extends RelativeLayout{
    private TextView[][] board;
    private TextView[][] goal;
    private Button[][] btn;

// up + down code is witch
    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    public AppInterface(Context context, View.OnClickListener buttonHandler) {
        super(context);
        final int DP = (int) (getResources().getDisplayMetrics().density);

        GridLayout gridOne = new GridLayout(context);
        gridOne.setId(GridLayout.generateViewId());
        gridOne.setColumnCount(3);
        gridOne.setRowCount(3);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(0, 0);
        params.width = 270 * DP;
        params.height = 270 * DP;
        params.topMargin = 20 * DP;
        params.addRule(CENTER_HORIZONTAL);
        gridOne.setLayoutParams(params);
        board = new TextView[3][3];
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                board[i][j] = new TextView(context);
                board[i][j].setBackgroundColor(Color.GREEN);
                board[i][j].setText("");

                board[i][j].setTextColor(Color.BLACK);
                board[i][j].setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                board[i][j].setGravity(Gravity.CENTER);
                GridLayout.LayoutParams params1 = new GridLayout.LayoutParams();
                params1.width = 90*DP;
                params1.height = 90*DP;
                params1.bottomMargin = 1;
                params1.rightMargin = 1;
                board[i][j].setLayoutParams(params1);
                gridOne.addView(board[i][j]);
            }
        }
        addView(gridOne);
        GridLayout gridTwo = new GridLayout(context);
        gridTwo.setId(GridLayout.generateViewId());
        gridTwo.setColumnCount(3);
        gridTwo.setRowCount(3);
        RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(0, 0);
        params2.width = 270 * DP;
        params2.height = 270 * DP;
        params2.topMargin = 20 * DP;
        params2.addRule(CENTER_HORIZONTAL);
        params2.addRule(BELOW, gridOne.getId());
        gridTwo.setLayoutParams(params2);
        goal = new TextView[3][3];
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                goal[i][j] = new TextView(context);
                goal[i][j].setBackgroundColor(Color.GREEN);
                goal[i][j].setText(String.valueOf(i+j));
                goal[i][j].setTextColor(Color.BLACK);
                goal[i][j].setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
                goal[i][j].setGravity(Gravity.CENTER);
                GridLayout.LayoutParams params1 = new GridLayout.LayoutParams();
                params1.width = 90*DP;
                params1.height = 90*DP;
                params1.bottomMargin = 1;
                params1.rightMargin = 1;
                goal[i][j].setLayoutParams(params1);
                gridTwo.addView(goal[i][j]); }
        }
        addView(gridTwo);
        GridLayout gridBtn = new GridLayout(context);
        gridBtn.setId(GridLayout.generateViewId());
        gridBtn.setColumnCount(4);
        gridBtn.setRowCount(1);
        RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(0, 0);
        params3.width = 1000*DP;
        params3.height = 600 * DP;
        params3.topMargin = 20 * DP;
        params3.addRule(CENTER_HORIZONTAL);
        params3.addRule(BELOW, gridTwo.getId());
        gridBtn.setLayoutParams(params3);
        btn = new Button[1][4];
        for(int i = 0 ; i < 1 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                btn[i][j] = new Button(context);
                if(j==0){

                btn[i][j].setText("Up");}
                else if(j==1){ btn[i][j].setText("Down");}
                else if (j==2){ btn[i][j].setText("Right");}
                else if (j==3){ btn[i][j].setText("Left");}

                btn[i][j].setTextColor(Color.BLACK);
                btn[i][j].setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
                btn[i][j].setGravity(Gravity.CENTER);
                GridLayout.LayoutParams params1 = new GridLayout.LayoutParams();
                params1.width = 130*DP;
                params1.height = 90*DP;
                params1.bottomMargin = 1;
                params1.rightMargin = 3;
                btn[i][j].setLayoutParams(params1);
                btn[i][j].setOnClickListener(buttonHandler);
                gridBtn.addView(btn[i][j]);}
        }
        addView(gridBtn);
    }
    public void generateInitialBoard(char[][] board){
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if(board[i][j] == '0'){
                    this.board[i][j].setText(' '+ "");
                }else {
                    this.board[i][j].setText(board[i][j] + "");
                }}} }
    public void generateGoalBoard(char[][] goal){
        int sum=1;
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                if (sum!=9){
                    this.goal[i][j].setText(String.valueOf(sum )+ "");}
                    else{
                        this.goal[i][j].setText(String.valueOf(' ' )+ "");
                    } sum+=1; } } }

    public int findButton(Button button){
        if(button.getText().equals("Up")){
            return 2;
        }else if(button.getText().equals("Down")){
            return 1;
        }else if(button.getText().equals("Right")){
            return 3;
        }else{
            return 4;
        }
    }
}