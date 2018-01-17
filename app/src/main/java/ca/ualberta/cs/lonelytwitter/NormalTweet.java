package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bui1 on 1/16/18.
 */

public class NormalTweet extends Tweet {
    NormalTweet(String message){
        super(message);
    }

    NormalTweet(String message, Date date){
        super(message,date);
    }

    @Override
    public Boolean isImportant(){
        return Boolean.FALSE;
    }
}
