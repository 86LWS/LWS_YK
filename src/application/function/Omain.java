package application.function;

import application.frame.Fmaster;
import javafx.application.Application;
import javafx.stage.Stage;

public class Omain extends Application{
	@Override
	public void start(Stage primaryStage) throws Exception {
		new Fmaster().start(new Stage());
	}
	public static void main(String[] args) {
		launch(args);
	}
}
