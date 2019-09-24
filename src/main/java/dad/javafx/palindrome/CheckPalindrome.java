package dad.javafx.palindrome;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckPalindrome extends Application {

	private TextField sentenceTxt;
	private Button comprobarBt;
	private Label palindromeLabel;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		sentenceTxt = new TextField();
		sentenceTxt.setPromptText("Introduce una sentencia");
		sentenceTxt.setMaxWidth(200);
		
		comprobarBt = new Button("Comprobar");
		comprobarBt.setDefaultButton(true);
		comprobarBt.setOnAction(evt -> onComprobarBt(evt));
		
		palindromeLabel = new Label();
		
		VBox box = new VBox();
		box.setSpacing(5);
		box.setAlignment(Pos.CENTER);
		box.getChildren().addAll(sentenceTxt, comprobarBt, palindromeLabel);
		
		Scene scene = new Scene(box, 320, 200);
		
		primaryStage.setTitle("CheckPalindrome");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void onComprobarBt( ActionEvent evt ) {
	
		if( isPalindrome(sentenceTxt.getText()) ) {
			
			palindromeLabel.setText("Es palíndromo");
			palindromeLabel.setStyle("-fx-text-fill:green");
		}
		
		else {
			
			palindromeLabel.setText("No es palíndromo");
			palindromeLabel.setStyle("-fx-text-fill:red");
		}
	}
	
	private boolean isPalindrome(String myString) {
		
	    int limit = myString.length();
	    
	    if( limit <= 1 )
	        return true;
	    
	    int j = 1;
	    for( int i = 0; i < (limit / 2); i++ ) {
	            if( myString.charAt(i) != myString.charAt(limit-j))
	                return false;       
	        j++;
	    }
	    
	    return true;
	}

	public static void main(String[] args) {
		launch(args);
	}

}
