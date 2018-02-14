package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by MonicaB on 2018-02-13.
 */

public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testAddTweet(){
        // must have method test name at the beginning
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("adding tweet");
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }
    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));
    }


    public void testGetTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");
        tweets.add(tweet);
        Tweet returned = tweets.getTweet(0);
        assertEquals(returned.getMessage(),tweet.getMessage());
        assertEquals(returned.getDate(),tweet.getDate());
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");
        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));

    }

}
