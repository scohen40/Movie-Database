package movieDatabaseApp.movie;

import com.google.inject.AbstractModule;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieModule extends AbstractModule{

		@Override
		protected void configure() {
			super.configure();
			
			Retrofit retrofit = new Retrofit.Builder()
					.baseUrl("https://hydramovies.com/api-v2/")
					.addConverterFactory(GsonConverterFactory.create())
					.build();
			MovieService service = retrofit.create(MovieService.class);
			
			//every time you want to use the earthquake service, use this on ^^^
			bind(MovieService.class).toInstance(service);
		}
	
}
