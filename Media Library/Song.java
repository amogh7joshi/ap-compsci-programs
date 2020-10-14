package medialib;

public final class Song {
	private String title, artist;
	private int rating;
	private boolean fav;
	
	public Song() {
		this.title = "";
		this.artist = "";
		this.rating = 0;
		this.fav = true;
	}
	
	public Song(String title, String artist, int rating, boolean fav) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		this.fav = fav;
	}
	
	@Override public String toString() {
		return "Title: " + this.title + ", Author: " + this.artist 
				+ ", Rating: " + Integer.toString(this.rating) 
				+ ", Favorite: " + Boolean.toString(this.fav);
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public int getRating() {
		return this.rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public boolean getFav() {
		return this.fav;
	}
	
	public void setFav(boolean fav) {
		this.fav = fav;
	}
	

}
