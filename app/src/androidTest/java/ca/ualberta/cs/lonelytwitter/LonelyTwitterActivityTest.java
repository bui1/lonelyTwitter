package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.ListView;

import com.robotium.solo.Solo;

import junit.framework.TestCase;

/**
 * Created by wz on 14/09/15.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();

    }



    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testAddingTweetToTheList(){
        solo.assertCurrentActivity("Wrong activity",LonelyTwitterActivity.class);
        solo.enterText((EditText)solo.getView(R.id.body),"Test Tweet");
        solo.clickOnButton("Save");
        solo.enterText((EditText)solo.getView(R.id.body),"");
        assertTrue(solo.searchText("Test Tweet"));
        solo.clickOnButton("Clear");
        assertFalse(solo.searchText("Test Tweet"));
    }

    public void testClickTweetList(){
        LonelyTwitterActivity activity = (LonelyTwitterActivity)solo.getCurrentActivity();
        solo.assertCurrentActivity("Wrong activity",LonelyTwitterActivity.class);
        solo.clickOnButton("Clear");
        solo.enterText((EditText)solo.getView(R.id.body),"Tweet Test");
        solo.clickOnButton("Save");
        solo.waitForText("Tweet Test");
        final ListView oldTweetList = activity.getOldTweetsList();
        Tweet tweet = (Tweet) oldTweetList.getItemAtPosition(0);
        assertEquals("Tweet Test",tweet.getMessage());

        solo.clickInList(0);
        solo.assertCurrentActivity("Wrong activity",EditTweetActivity.class);
        assertTrue(solo.waitForText("TextView"));
        solo.goBack();

        solo.assertCurrentActivity("Wrong activity",LonelyTwitterActivity.class);

    }
    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }


}