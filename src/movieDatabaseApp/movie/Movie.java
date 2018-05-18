package movieDatabaseApp.movie;

public class Movie {
	
	private String Title;
	private String movie_year;
	private String imdb_rating;
	private String language;
	
	public Movie(String title, String movie_year, String imdb_rating, String language) {
		super();
		Title = title;
		this.movie_year = movie_year;
		this.imdb_rating = imdb_rating;
		this.language = language;
	}
	
	public String getTitle() {
		return Title;
	}
	public String getMovie_year() {
		return movie_year;
	}
	public String getImdb_rating() {
		return imdb_rating;
	}
	public String getLanguage() {
		return language;
	}
	
	
}
