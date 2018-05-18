package movieDatabaseApp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import movieDatabaseApp.movie.Movie;
import movieDatabaseApp.movie.MovieController;
import movieDatabaseApp.movie.MovieService;
import movieDatabaseApp.movie.MovieView;
import retrofit2.Call;

class MovieControllerTest {

	@Test
	public void testRefreshData() {
		// given
		MovieView view = Mockito.mock(MovieView.class);
		MovieService service = Mockito.mock(MovieService.class);
		MovieController controller = new MovieController(view, service);
		Mockito.when(service.getMovies2018()).thenReturn(Mockito.mock(Call.class));
		Mockito.when(view.gethTitleField()).thenReturn((JTextField) Mockito.mock(JTextField.class));

		// when
		controller.requestHighest2018();

		// then
		assertFalse(view.gethTitleField().getText().equals(""));
	}

	@Test
	public void testShowHighest() {
		// given
		MovieView view = Mockito.mock(MovieView.class);
		MovieService service = Mockito.mock(MovieService.class);
		MovieController controller = new MovieController(view, service);
		JTextField title = Mockito.mock(JTextField.class);
		JTextField year = Mockito.mock(JTextField.class);
		JTextField rating = Mockito.mock(JTextField.class);
		JTextField language = Mockito.mock(JTextField.class);

		List<Movie> list = new ArrayList<Movie>();
		list.add(new Movie("bk", "2017", "2", "english"));
		list.add(new Movie("qu", "2018", "6", "spanish"));
		list.add(new Movie("mh", "2018", "1", "hebrew"));

		// when
		controller.showHighest(list, title, year, rating, language);

		// then
		Mockito.verify(title).setText("qu");
		Mockito.verify(year).setText("2018");
		Mockito.verify(rating).setText("6");
		Mockito.verify(language).setText("spanish");

	}

}