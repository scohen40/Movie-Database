package movieDatabaseApp.movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRetrofitClient {
	Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://hydramovies.com/api-v2/")
			.addConverterFactory(GsonConverterFactory.create())
			.build();
	MovieService service = retrofit.create(MovieService.class);
	
	Call<List<Movie>> call2018 = service.getMovies2018();

}
