

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
		else if (mood == "mad"){
			this.mood = "mad";
		}
        else{
            throw new MoodException();
        }
    }

    public Date getDate() { return date;}
	
	public Date setDate(Date date) {
		this.date = date;
	}

    public abstract Boolean isImportant();
	
	
}
