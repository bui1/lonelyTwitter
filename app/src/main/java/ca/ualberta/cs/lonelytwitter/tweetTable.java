package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bui1 on 1/16/18.
 */

/**
 * Represents a Tweet table interface
 *
 * @author bui1
 * @version 1.0
 * @see Tweet
 *
 */

public interface tweetTable {
    /**
     * Get tweet message
     */
    public String getMessage();
    /**
     * Get tweet date
     */
    public Date getDate();

    //public Mood getMood();

}
