package movieDatabaseApp.movie;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;


@Singleton
public class MovieView extends JFrame {

	private JLabel title = new JLabel("2018 Movie Ratings", SwingConstants.CENTER);
	private JLabel highest = new JLabel("Highest Rating: ", SwingConstants.CENTER);
	private JLabel lowest = new JLabel("Lowest Rating: ", SwingConstants.CENTER);
	private JLabel hTitle = new JLabel("Title: ", SwingConstants.CENTER);
	private JLabel lTitle = new JLabel("Title: ", SwingConstants.CENTER);
	private JLabel hYear = new JLabel("Year: ", SwingConstants.CENTER);
	private JLabel lYear = new JLabel("Year: ", SwingConstants.CENTER);
	private JLabel hRating = new JLabel("Rating: ", SwingConstants.CENTER);
	private JLabel lRating = new JLabel("Rating: ", SwingConstants.CENTER);
	private JLabel hLanguage = new JLabel("Language: ", SwingConstants.CENTER);
	private JLabel lLanguage = new JLabel("Language: ", SwingConstants.CENTER);
	private JTextField hTitleField = new JTextField();
	private JTextField hYearField = new JTextField();
	private JTextField hRatingField = new JTextField();
	private JTextField hLanguageField = new JTextField();
	private JTextField lTitleField = new JTextField();
	private JTextField lYearField = new JTextField();
	private JTextField lRatingField = new JTextField();
	private JTextField lLanguageField = new JTextField();
	
	
	
	public MovieView() throws IOException {
		setTitle("Highest Movie Ratings Viewer");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel results = new JPanel();
		results.setLayout(new GridLayout(2,2));
		JPanel resultHigh = new JPanel();
		JPanel resultLow = new JPanel();
		resultHigh.setLayout(new GridLayout(4,2));
		resultLow.setLayout(new GridLayout(4,2));

		panel.add(title, BorderLayout.NORTH);
		panel.add(results, BorderLayout.CENTER);
		
		results.add(highest);
		results.add(resultHigh);
		results.add(lowest);
		results.add(resultLow);
		resultHigh.add(hTitle);
		resultHigh.add(hTitleField);
		resultHigh.add(hYear);
		resultHigh.add(hYearField);
		resultHigh.add(hRating);
		resultHigh.add(hRatingField);
		resultHigh.add(hLanguage);
		resultHigh.add(hLanguageField);
		resultLow.add(lTitle);
		resultLow.add(lTitleField);
		resultLow.add(lYear);
		resultLow.add(lYearField);
		resultLow.add(lRating);
		resultLow.add(lRatingField);
		resultLow.add(lLanguage);
		resultLow.add(lLanguageField);
		
		hTitleField.setEditable(false);
		hYearField.setEditable(false);
		hRatingField.setEditable(false);
		hLanguageField.setEditable(false);
		lTitleField.setEditable(false);
		lYearField.setEditable(false);
		lRatingField.setEditable(false);
		lLanguageField.setEditable(false);
		
		
		add(panel);
		
	}
	
	public JTextField gethTitleField() {
		return hTitleField;
	}
	public JTextField gethYearField() {
		return hYearField;
	}
	public JTextField gethRatingField() {
		return hRatingField;
	}
	public JTextField gethLanguageField() {
		return hLanguageField;
	}
	public JTextField getlTitleField() {
		return lTitleField;
	}
	public JTextField getlYearField() {
		return lYearField;
	}
	public JTextField getlRatingField() {
		return lRatingField;
	}
	public JTextField getlLanguageField() {
		return lLanguageField;
	}
		
	public static void main(String[] args) throws IOException {	
		//Instead of creating the dependencies inside the class, create it outside 
		//use Guice to create objects and wire them together. 

		//the injector creates the view and the controller for me and automatically wires it up
		//to my retrofit and service as described in the EarthquakeModule. 
		Injector injector = Guice.createInjector(new MovieModule());
		
		MovieView view = injector.getInstance(MovieView.class);
		//put in @Singleton before the EarthquakeView name up top in order to make sure there is only one view, because controller also has a view as a member. 
		//So we create 2 views and it doesn't work without the implementation of the Singleton Design Pattern 
		MovieController controller = injector.getInstance(MovieController.class);
		
		controller.refreshData();
		
		view.setVisible(true);	
	}
}
