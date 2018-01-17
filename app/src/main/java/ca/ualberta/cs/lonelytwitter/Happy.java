package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bui1 on 1/16/18.
 */

public class Happy extends MainMood {
    Happy(String mood){
        super(mood);
    }

    Happy(String mood, Date date){
        super(mood,date);
    }

    @Override
    public Boolean isFeelingGood(){
        return Boolean.TRUE;
    }
}
