package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by bui1 on 1/16/18.
 */

public abstract class MainMood(){
	private String mood; // private variables
	private Date date;
	
	MainMood(String mood){
		this.mood = mood;
		date = new Date();
	}
	
	MainMood(String mood, Date date){
		this.mood = mood;
		this.date = date;
	}
	
	public void getMood(){ return mood;}
	
	public void setMood(String mood) throws MoodException{
        if (mood == "happy"){
            this.mood = "happy";
        }
		else if (mood == "sad"){
			this.mood = "sad";
		}
        else{
            throw new MoodException();
        }
    }

    public Date getDate() { return date;}
	
	public Date setDate(Date date) {
		this.date = date;
	}

    public abstract Boolean isFeelingGood();
	
	
}
