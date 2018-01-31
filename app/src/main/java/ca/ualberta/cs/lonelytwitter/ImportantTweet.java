package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bui1 on 1/16/18.
 */
/**
 * Represents a Important Tweet
 *
 * @author bui1
 * @version 1.0
 * @see NormalTweet
 * @see Tweet
 *
 *
 */
public class ImportantTweet extends Tweet {

    ImportantTweet(String message){
        super(message);

    }

    /**
     * Constructs a important tweet
     * @param message tweet message
     * @param date tweet date
     */

    ImportantTweet(String message, Date date){
        super(message,date);
    }


    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }
}
