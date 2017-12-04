package edu.pnw.spjarrar.diceroll;

        import android.os.Bundle;
        import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import java.lang.Math;
        import java.util.ArrayList;
        import java.util.Random;

public class DiceRoll extends AppCompatActivity {

    EditText startNum, endNum, customInput;
    TextView rollResult, customResult, customSum;



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
        String startString, endString;
        int startInt, endInt, rollInt;
        boolean errorFlag = false;

        Random dice = new Random();

        startInt = 1;
        endInt = 6;
        //rollInt = 0;

        startString = startNum.getText().toString();
        endString = endNum.getText().toString();

        try{
            startInt = Integer.parseInt(startString);
            endInt = Integer.parseInt(endString);
        }catch(NumberFormatException e){
            errorFlag = true;
        }



        rollInt = dice.nextInt(endInt-startInt+1 ) + startInt;


        if(errorFlag)
            rollResult.setText("Error");

        else
            rollResult.setText(Integer.toString(rollInt));

    }

    public void customRoll(View v){
        Random dice = new Random();

        String customRollString ;
        String outputString = "";
        String[] customRollStringSplit = new String[2];
        ArrayList<Integer> rollResultList = new ArrayList<Integer>();
        int numOfDice = 1;
        int sizeOfDice = 12;
        int rollResultSum = 0;


        boolean errorFlag = false;

        customRollString = customInput.getText().toString();
        if(customRollString.contains("d")){
            customRollStringSplit = customRollString.split("d");
        }
        else {
            errorFlag = true;
        }

        try{
            numOfDice = Integer.parseInt(customRollStringSplit[0]);
            sizeOfDice = Integer.parseInt(customRollStringSplit[1]);
        }catch(NumberFormatException e){
            errorFlag = true;
        }

        if(!errorFlag){
            for(int i = 0; i < numOfDice; i++){
                int newRoll = dice.nextInt(sizeOfDice ) + 1;
                rollResultList.add(newRoll);
            }
        }
        for(int k: rollResultList){
            if(outputString != ""){
                outputString += ", ";
            }
            rollResultSum += k;
            outputString += Integer.toString(k);
        }
        customSum.setText(Integer.toString(rollResultSum));
        customResult.setText(outputString);
    }
    public void clearAll(View v){
        rollResult.setText("");
        startNum.setText("");
        endNum.setText("");
    }

}
