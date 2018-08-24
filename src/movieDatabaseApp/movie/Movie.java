package movieDatabaseApp.movie;

public class Movie {
	
	private String Title;
	private String movie_year;
	private double imdb_rating;
	private String language;
	
	public Movie(String title, String movie_year, Double imdb_rating, String language) {
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
	public Double getImdb_rating() {
		return imdb_rating;
	}
	public String getLanguage() {
		return language;
	}
	
	
}
