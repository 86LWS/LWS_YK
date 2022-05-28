package application.frame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Fmaster extends Application{
	@Override
	public void start(Stage ps) throws Exception {
		Parent pa=FXMLLoader.load(this.getClass().getResource("/application/fxml/FXMLmaster.fxml"));
		ps.setScene(new Scene(pa));
		ps.setTitle("浅浅深深大冒险");
		ps.setResizable(false);
		ps.setWidth(1286);
		ps.setHeight(755);//定义分辨率
		ps.show();
	}
}
