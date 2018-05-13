package movieDatabaseApp;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import movieDatabaseApp.movie.Movie;
import movieDatabaseApp.movie.MovieFeedModel;
import movieDatabaseApp.movie.MovieService;
import movieDatabaseApp.movie.Movie_Results;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class MovieServiceTest {

	@Test
	public void testGetAllMovies() throws IOException {
		
		// given
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://hydramovies.com/api-v2/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		MovieService service = retrofit.create(MovieService.class);
		Call<MovieFeedModel> call = service.getMovieByTitle("New York Doll");
		
		// when
		Response<MovieFeedModel> response = call.execute();
		
		// then
		assertNotNull(response.body());
		
//		List<Movie> movies = response.body().results();
//		assertTrue(movies.size() > 0);
//		
//		String title = movies.get(0).getResults().getTitle();
//		assertNotNull(title);
//		
	}
}
