package movieDatabaseApp;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import movieDatabaseApp.movie.Movie;
import movieDatabaseApp.movie.MovieService;
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
		Call<List<Movie>> call = service.getAllMovies();
		
		// when
		Response<List<Movie>> response = call.execute();
		
		// then
		assertNotNull(response.body());
		
		List<Movie> movies = response.body();
		assertTrue(movies.size() > 0);
		
		String title = movies.get(0).getTitle();
		assertNotNull(title);
		
	}
	
	@Test
	public void testGetMovieByTitle() throws IOException {
		
		// given
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://hydramovies.com/api-v2/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		MovieService service = retrofit.create(MovieService.class);
		Call<List<Movie>> call = service.getMovieByTitle("N");
		
		// when
		Response<List<Movie>> response = call.execute();
		
		// then
		assertNotNull(response.body());
	}
		
}
