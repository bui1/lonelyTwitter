/* Tweet
 *
 * Version Number 1.0
 *
 * January 30th 2018
 *
 * Copyright @ 2018 Team X. CMPUT 301 University of Alberta. All rights reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behaviour at University of Alberta. Contact abc.ualberta.ca for more info.
 */


package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bui1 on 1/16/18.
 */

/**
 * Represents a Tweet
 *
 * @author bui1
 * @version 1.0
 * @see NormalTweet
 * @see ImportantTweet
 *
 *
 */
public abstract class Tweet implements tweetTable {

    private String message;
    private Date date;

    Tweet(String message){
        this.message = message;
        date = new Date();
    }

    /**
     * Constructs a tweet object
     *
     * @param message tweet message
     * @param date tweet date
     */

    Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }

    /**
     * Get the tweet message
     * @return tweet message
     */


    public String getMessage(){
        return this.message;
    }

    /**
     * Sets tweet message
     * @param message tweet message
     * @throws Tweettoolongexception the tweet message is over 140 characters
     */
    public void setMessage(String message) throws Tweettoolongexception{
        if (message.length() < 140){
            this.message = message;
        }
        else{
            throw new Tweettoolongexception();
        }
    }

    /**
     * Gets the tweet date
     * @return tweet date
     */

    public Date getDate() { return this.date;}


    /**
     * Provides an abstract for isImportant method checking if the tweet is important or not
     * @return a boolean of an important tweet
     */
    public abstract Boolean isImportant();


    /**
     * Converts tweet object to string representation
     * @return string representation of tweet object
     */
    @Override
    public String toString(){
        return date.toString() + " | " + message;
    }


}
