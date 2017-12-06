package edu.pnw.spjarrar.diceroll;

import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.TextView;

public class DiceRoll extends AppCompatActivity {

    EditText startNum, endNum, customInput;
    TextView rollResult, customResult, customSum;
    String errorMessage = "Error";
    String shortError = "E";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll);

        startNum = findViewById(R.id.editTextMin);
        endNum = findViewById(R.id.editTextMax);
        rollResult = findViewById(R.id.textViewResult);
        customInput = findViewById(R.id.editTextCustom);
        customResult = findViewById(R.id.textViewCustom);
        customSum = findViewById(R.id.textViewSum);
    }

    public void roll(View view){
        String startString = startNum.getText().toString();
        String endString = endNum.getText().toString();
        Die freshDice = new Die(startString, endString);
        if(freshDice.isValidDie()){
            rollResult.setText(Integer.toString(freshDice.singleRoll()));
        }
        else {
            rollResult.setText(errorMessage);
        }
    }
    public void customRoll(View v) {
        String customRollString = customInput.getText().toString();
        MultipleDice customDice = new MultipleDice(customRollString);
        customDice.multiDiceRoll();
        if(customDice.isValidCustomRoll()){
            customSum.setText(Integer.toString(customDice.getRollResultSum()));
            customResult.setText(customDice.getOutputString());
        }
        else{
            customResult.setText(errorMessage);
            customSum.setText(shortError);
        }
    }
}
