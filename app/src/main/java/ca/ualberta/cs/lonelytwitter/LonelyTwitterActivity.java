/* Lonely Twitter Activity
 *
 * Version Number 1.0
 *
 * January 30th 2018
 *
 * Copyright @ 2018 Team X. CMPUT 301 University of Alberta. All rights reserved.
 * You may use, distribute, or modify this code under terms and conditions of the Code of Student Behaviour at University of Alberta. Contact abc.ualberta.ca for more info.
 */


package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Represents the main Lonely Twitter activity
 *
 * @author bui1
 * @version 1.0
 * @see Tweet
 * @see ImportantTweet
 * @see NormalTweet
 *
 *
 */

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "tweets.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		Button clearButton = (Button)findViewById(R.id.clear);


		clearButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				setResult(RESULT_OK);
				clearFile();
				adapter.notifyDataSetChanged();
			}
		});



		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				Tweet tweet = new NormalTweet(text);
				tweetList.add(tweet);

				saveInFile();//text, new Date(System.currentTimeMillis()));

				adapter.notifyDataSetChanged(); // let adapter know we added a new file, to update the UI

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated avdmethod stub
		super.onStart();
		loadFromFile();


		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);

//		NormalTweet normalTweet = new NormalTweet("");
//		try {
//			normalTweet.setMessage("hello wo1111111111111111111111rld");
//		}
//		catch (Tweettoolongexception e){
//			Log.e("asdasd","Errror ---- message too long");
//
//		}
//
//		ImportantTweet importanttweet1 = new ImportantTweet("Hello world, hella important");
//		ImportantTweet importantTweet2 = new ImportantTweet("number 2 important");
//
//		NormalTweet normal1 = new NormalTweet("this is normal tweet 1");
//		NormalTweet normal2 = new NormalTweet("this is not important either");
//
//		ArrayList <Tweet> tweetList = new ArrayList<Tweet>();
//		tweetList.add(normalTweet);
//		tweetList.add(normal1);
//		tweetList.add(normal2);
//		tweetList.add(importanttweet1);
//		tweetList.add(importantTweet2);
//
//		for (Tweet t: tweetList){
//			Log.d("Tweettag",t.isImportant().toString());
//		}
//
//		ArrayList<tweetTable> tweettablelist = new ArrayList<tweetTable>();
//		tweettablelist.add(normalTweet);
//		tweettablelist.add(normal1);
//		tweettablelist.add(normal2);
//		tweettablelist.add(importanttweet1);
//		tweettablelist.add(importantTweet2);
//
//		String onscreen = "";
//
//		for (tweetTable t: tweettablelist){
//			onscreen += t.getMessage() + "\n";
//
//		}
//		Toast.makeText(this, onscreen, Toast.LENGTH_SHORT).show();
	}

	/**
	 * Loads saved tweets from file to the adapter
	 */
	private void loadFromFile() {
		//ArrayList<String> tweets = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));

			Gson gson = new Gson();

			// Taken from stack overflow gson convert to json to type array list
			//2018-01-23
			Type listType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in,listType);


//			String line = in.readLine();
//			while (line != null) {
//				tweets.add(line);
//				line = in.readLine();
//			}

		} catch (FileNotFoundException e) {
			tweetList = new ArrayList<Tweet>();



//			// TODO Auto-generated catch block
//			e.printStackTrace();
		} catch (IOException e) {
			throw new RuntimeException();
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		//return tweets.toArray(new String[tweets.size()]);
	}

	/**
	 * Saves new tweets to file
	 */
	private void saveInFile() {
		try {


			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE); //overwrites the file, not append to the end
			//MODE_APPEND

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson = new Gson();
			gson.toJson(tweetList,out); // write tweetlist to the output file by converting it to JSON
			out.flush();

			//fos.write(new String(date.toString() + " | " + text).getBytes());
			//fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException();
		}
	}

	/**
	 * Clears all the tweets from file
	 */
	private void clearFile() {
		try {


			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE); //overwrites the file, not append to the end
			//MODE_APPEND

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));
			tweetList.clear();

			Gson gson = new Gson();
			gson.toJson(tweetList,out); // write tweetlist to the output file by converting it to JSON
			out.flush();

		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}