package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bui1 on 1/16/18.
 */

public abstract class Tweet implements tweetTable {
    private String message;
    private Date date;

    Tweet(String message){
        this.message = message;
        date = new Date();
    }

    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }
    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message) throws Tweettoolongexception{
        if (message.length() < 140){
            this.message = message;
        }
        else{
            throw new Tweettoolongexception();
        }
    }

    public Date getDate() { return this.date;}



    public abstract Boolean isImportant();



    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }


}
