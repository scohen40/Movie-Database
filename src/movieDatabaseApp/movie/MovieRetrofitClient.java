package movieDatabaseApp.movie;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieRetrofitClient {
	Retrofit retrofit = new Retrofit.Builder()
			.baseUrl("https://hydramovies.com/api-v2/")
			.addConverterFactory(GsonConverterFactory.create())
			.build();
	MovieService service = 
			retrofit.create(MovieService.class);

}
