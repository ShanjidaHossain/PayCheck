package edu.cst.application.dev.midterm.shanjida;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage; 


public class PayCheckMain extends Application {

	public static void main(String[] args) {
		Application.launch(PayCheckMain.class, args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("Midterm.fxml"));
		stage.setTitle("Pay Check");

		Scene scene = new Scene (root);
		stage.setScene(scene);
		
		URL url = this.getClass().getResource("Midterm.css");
		if (url == null) {
			System.out.println("Resources not found. Aborting...");
			System.exit(-1);
		}
		
		String css = url.toExternalForm();
		scene.getStylesheets().add(css);
		stage.show();
	}

}