package movieDatabaseApp.movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {
	@GET("?source=http://hydramovies.com/api-v2/current-Movie-Data.csv")
	Call<List<Movie>> getAllMovies();
	
	@GET("?source=http://hydramovies.com/api-v2/current-Movie-Data.csv")
	Call<List<Movie>> getMovieByTitle(@Query("range") String range);
	
	@GET("?source=http://hydramovies.com/api-v2/current-Movie-Data.csv&movie_year=2018")
	Call<List<Movie>> getMovies2018();
	
}
