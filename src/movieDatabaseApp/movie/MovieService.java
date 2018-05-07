package movieDatabaseApp.movie;

import movieDatabaseApp.movie.MovieFeedModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieService {
	@GET("api/public/v1.0/movies.json?apikey=y5mva3zr9rthzfzp5j6xxdea")
	Call<MovieFeedModel> getAllMovies();
	
}
