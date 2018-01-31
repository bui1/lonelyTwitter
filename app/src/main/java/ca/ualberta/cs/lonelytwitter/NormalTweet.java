package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bui1 on 1/16/18.
 */

/**
 * Represents a Normal Tweet
 *
 * @author bui1
 * @version 1.0
 * @see Tweet
 * @see ImportantTweet
 *
 *
 */
public class NormalTweet extends Tweet {
    NormalTweet(String message){
        super(message);
    }

    /**
     * Constructs a normal tweet
     * @param message tweet message
     * @param date tweet date
     */

    NormalTweet(String message, Date date){
        super(message,date);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.FALSE;
    }
}
