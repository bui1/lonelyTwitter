package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);



		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				saveInFile(text, new Date(System.currentTimeMillis()));
				finish();

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated avdmethod stub
		super.onStart();
		String[] tweets = loadFromFile();
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				R.layout.list_item, tweets);
		oldTweetsList.setAdapter(adapter);

		NormalTweet normalTweet = new NormalTweet("");
		try {
			normalTweet.setMessage("hello wo1111111111111111111111rld");
		}
		catch (Tweettoolongexception e){
			Log.e("asdasd","Errror ---- message too long");

		}

		ImportantTweet importanttweet1 = new ImportantTweet("Hello world, hella important");
		ImportantTweet importantTweet2 = new ImportantTweet("number 2 important");

		NormalTweet normal1 = new NormalTweet("this is normal tweet 1");
		NormalTweet normal2 = new NormalTweet("this is not important either");

		ArrayList <Tweet> tweetList = new ArrayList<Tweet>();
		tweetList.add(normalTweet);
		tweetList.add(normal1);
		tweetList.add(normal2);
		tweetList.add(importanttweet1);
		tweetList.add(importantTweet2);

		for (Tweet t: tweetList){
			Log.d("Tweettag",t.isImportant().toString());
		}

		ArrayList<tweetTable> tweettablelist = new ArrayList<tweetTable>();
		tweettablelist.add(normalTweet);
		tweettablelist.add(normal1);
		tweettablelist.add(normal2);
		tweettablelist.add(importanttweet1);
		tweettablelist.add(importantTweet2);

		String onscreen = "";

		for (tweetTable t: tweettablelist){
			onscreen += t.getMessage() + "\n";

		}
		Toast.makeText(this, onscreen, Toast.LENGTH_SHORT).show();
	}

	private String[] loadFromFile() {
		ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				tweets.add(line);
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tweets.toArray(new String[tweets.size()]);
	}
	
	private void saveInFile(String text, Date date) {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_APPEND);
			fos.write(new String(date.toString() + " | " + text)
					.getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}