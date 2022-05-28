package application.map;

import application.data.Odata;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
/**
 * 绘制地图
 * @author Administrator
 *
 */
public class map {
	private Image bg1=new Image("application/ui/bg/bg1.png");
	private Image bg2=new Image("application/ui/bg/bg2.png");
	public void drawBg(GraphicsContext g) {
		if(Odata.map<4)g.drawImage(bg1, 0, 0, 1280, 720);
		else g.drawImage(bg2, 0, 0, 1280, 720);
	}
}
