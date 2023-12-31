package application;
	

import javafx.application.Application;
import javafx.stage.Stage;
import sql.DatabaseInitializer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			DatabaseInitializer.destroy();
			DatabaseInitializer.init();
			Parent root = FXMLLoader.load(getClass().getResource("/view/principal.fxml"));
			Scene scene = new Scene(root,1200,800);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
