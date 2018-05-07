package movieDatabaseApp.movie;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRetrofitClient {
	Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("http://api.rottentomatoes.com/")
			.addConverterFactory(GsonConverterFactory.create())
			.build();
	MovieService service = 
			retrofit.create(MovieService.class);

}
