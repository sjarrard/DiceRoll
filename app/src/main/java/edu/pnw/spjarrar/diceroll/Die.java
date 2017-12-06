package edu.pnw.spjarrar.diceroll;

import java.util.Random;

/**
 * Created by spjar on 12/6/2017.
 */

public class Die {
    boolean errorFlag;
    int startInt, endInt;
    Random rng = new Random();

    public Die(String start, String end) {
        errorFlag = false;
        try {
            startInt = Integer.parseInt(start);
            endInt = Integer.parseInt(end);
        } catch (NumberFormatException e) {
            errorFlag = true;
            startInt = 0;
            endInt = 0;
        }
    }

    public Die(int start, int end){
        startInt = start;
        endInt = end;
    }



    public int singleRoll(){
        int rollInt = 0;
        if(this.isValidDie()){
           rollInt = rng.nextInt(endInt - startInt + 1) + startInt;
        }
        return rollInt;
    }

    public boolean isValidDie(){
        return (endInt >= startInt) & !errorFlag;
    }

}
