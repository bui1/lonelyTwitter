package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

/**
 * Created by MonicaB on 2018-02-13.
 */


public class TweetListTest extends ActivityInstrumentationTestCase2 {

    public TweetListTest(){
        super(LonelyTwitterActivity.class);
    }

    public void testgetCount(){
        TweetList tweets = new TweetList();
        int sum = 0;
        assertEquals(sum,tweets.getLength());
        Tweet tweet = new NormalTweet("first tweet");
        tweets.add(tweet);
        sum = sum + 1;
        assertEquals(sum,tweets.getLength());
    }

    public void testAddTweet(){
        // must have method test name at the beginning
//        TweetList tweets = new TweetList();
//        Tweet tweet = new NormalTweet("adding tweet");
//        tweets.add(tweet);
//        assertTrue(tweets.hasTweet(tweet));
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("Duplicate");
        tweets.add(tweet);
        if (tweets.hasTweet(tweet)){
            throw new IllegalArgumentException();
        }
        assertFalse(tweets.hasTweet(tweet));
    }
    public void testHasTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");
        assertFalse(tweets.hasTweet(tweet));
        tweets.add(tweet);
        assertTrue(tweets.hasTweet(tweet));

    }


    public void testGetTweet(){
//        TweetList tweets = new TweetList();
//        Tweet tweet = new NormalTweet("hello");
//        tweets.add(tweet);
//        Tweet returned = tweets.getTweet(0);
//        assertEquals(returned.getMessage(),tweet.getMessage());
//        assertEquals(returned.getDate(),tweet.getDate());
        TweetList tweets = new TweetList();
        TweetList tweets2 = new TweetList();
        Tweet tweet = new NormalTweet("hello");
        Tweet tweet2 = new NormalTweet("hello2");
        tweets.add(tweet);
        tweets.add(tweet2);
        Tweet returned = tweets.getTweet(0);
        Tweet returned2 = tweets.getTweet(1);
        tweets2.add(returned);
        tweets2.add(returned2);
        assertEquals(tweets,tweets2); // both lists should equal each other
    }

    public void testDeleteTweet(){
        TweetList tweets = new TweetList();
        Tweet tweet = new NormalTweet("hello");
        tweets.add(tweet);
        tweets.delete(tweet);
        assertFalse(tweets.hasTweet(tweet));

    }

}
