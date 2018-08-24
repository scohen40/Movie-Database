package movieDatabaseApp.movie;

import java.awt.event.ActionEvent;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.swing.text.JTextComponent;

import com.google.inject.Inject;

public class MovieController {


	private MovieView view;
	private MovieService service;
	
	@Inject
	public
	MovieController(MovieView view, MovieService service) {
		this.view = view;
		this.service = service;
	}
	
	public void refreshData() {
		requestHighest2018();
		requestLowest2018();
	}
	
	public void requestHighest2018() {
		requestHighestMovies(service.getAllMovies(),
//		requestHighestMovies(service.getMovies2018(),
				view.gethTitleField(),
				view.gethYearField(),
				view.gethRatingField(),
				view.gethLanguageField());			
	}
	void requestLowest2018() {
		requestLowestMovies(service.getAllMovies(),
//		requestLowestMovies(service.getMovies2018(),
				view.getlTitleField(),
				view.getlYearField(),
				view.getlRatingField(),
				view.getlLanguageField());			
	}

	


	private void requestHighestMovies(Call<List<Movie>> call,
		JTextComponent title,
		JTextComponent year,
		JTextComponent rating,
		JTextComponent language) 
	{
		call.enqueue(new Callback<List<Movie>>() {
			@Override
			public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
				List<Movie> list = response.body();

				showHighest(list, title, year, rating, language);

			}

			@Override
			public void onFailure(Call<List<Movie>> arg0, Throwable t) {
				t.printStackTrace();
			}

		});

	}
	
	private void requestLowestMovies(Call<List<Movie>> call,
			JTextComponent title,
			JTextComponent year,
			JTextComponent rating,
			JTextComponent language) 
		{
			call.enqueue(new Callback<List<Movie>>() {
				@Override
				public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
					List<Movie> list = response.body();

					showLowest(list, title, year, rating, language);

				}

				@Override
				public void onFailure(Call<List<Movie>> arg0, Throwable t) {
					t.printStackTrace();
				}

			});

		}

	public void showHighest(List<Movie> list,
			JTextComponent title,
			JTextComponent year,
			JTextComponent rating,
			JTextComponent language) 
	{
		Optional<Movie> highest = list.stream().filter(e -> e!=null)
				.max(Comparator.comparingDouble(e -> Double.parseDouble(e.getImdb_rating())));
		
		
		title.setText(String.valueOf(highest.get().getTitle()));
		year.setText(String.valueOf(highest.get().getMovie_year()));
		rating.setText(String.valueOf(highest.get().getImdb_rating()));
		language.setText(String.valueOf(highest.get().getLanguage()));
	}
	
	void showLowest(List<Movie> list,
			JTextComponent title,
			JTextComponent year,
			JTextComponent rating,
			JTextComponent language) 
	{
		Optional<Movie> lowest = list.stream().filter(a -> a!=null)
				.min(Comparator.comparingDouble(e -> Double.parseDouble(e.getImdb_rating())));
		
		title.setText(String.valueOf(lowest.get().getTitle()));
		year.setText(String.valueOf(lowest.get().getMovie_year()));
		rating.setText(String.valueOf(lowest.get().getImdb_rating()));
		language.setText(String.valueOf(lowest.get().getMovie_year()));
	}
		
}


