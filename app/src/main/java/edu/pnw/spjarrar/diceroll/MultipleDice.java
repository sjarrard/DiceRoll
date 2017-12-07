package edu.pnw.spjarrar.diceroll;

//import java.util.ArrayList;

/**
 * Created by spjarrard on 12/6/2017.
 */

public class MultipleDice {
    int numOfDice, sizeOfDice, rollResultSum;
    String outputString;
    boolean properStringFormat;

    public MultipleDice(String rawString) {
        outputString = "";
        String[] splitString = new String[2];
        //ArrayList<Integer> rollList = new ArrayList<>();
        rollResultSum = 0;
        if (rawString.contains("d") | rawString.contains("D")) {
            splitString = rawString.split("(?i)d");
            properStringFormat = true;
        } else {
            properStringFormat = false;
        }

        try {
            numOfDice = Integer.parseInt(splitString[0]);
            sizeOfDice = Integer.parseInt(splitString[1]);
        } catch (NumberFormatException e) {
            properStringFormat = false;
            numOfDice = 0;
            sizeOfDice = 1;
        }
    }

    public void multiDiceRoll(){
        if(this.isValidCustomRoll()){
            for(int i = 0; i < numOfDice; i++){
                if(outputString != "")
                    outputString += ", ";
                Die freshDice = new Die(1,sizeOfDice);
                int newRoll = freshDice.singleRoll();
                //rollList.add(newRoll);
                rollResultSum += newRoll;
                outputString += Integer.toString(newRoll);
            }
        }
    }

    public int getRollResultSum() {
        return rollResultSum;
    }

    public String getOutputString() {
        return outputString;
    }

    public boolean isValidCustomRoll() {
        if(sizeOfDice > 0 & numOfDice > 0 & properStringFormat)
            return true;
        else
            return false;
    }
}
