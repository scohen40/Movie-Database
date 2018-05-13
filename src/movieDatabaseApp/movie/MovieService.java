package movieDatabaseApp.movie;

import movieDatabaseApp.movie.MovieFeedModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MovieService {
	@GET("?source=http://hydramovies.com/api-v2/current-Movie-Data.csv")
	Call<MovieFeedModel> getAllMovies();
	
	@GET("?source=http://hydramovies.com/api-v2/current-Movie-Data.csv&title={range}")
	Call<MovieFeedModel> getMovieByTitle(@Path("range") String range);
	
}
