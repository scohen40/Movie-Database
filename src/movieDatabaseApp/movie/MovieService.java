package movieDatabaseApp.movie;

import movieDatabaseApp.movie.MovieFeedModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {
	@GET("?source=http://hydramovies.com/api-v2/current-Movie-Data.csv")
	Call<MovieFeedModel> getAllMovies();
	
	@GET("?source=http://hydramovies.com/api-v2/current-Movie-Data.csv")
	Call<MovieFeedModel> getMovieByTitle(@Query("range") String range);
	
}
