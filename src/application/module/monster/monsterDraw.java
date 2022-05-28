package application.module.monster;

import application.data.Odata;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class monsterDraw {
	private double w,h;
	/**
	 * 怪物准备
	 * @param g
	 */
	public void drawMonster(GraphicsContext g) {
		Image m=Odata.monsters.get(Odata.map).getIm();
		w=m.getWidth()*2.5;
		h=m.getHeight()*2.5;
		if(Odata.monsterattack)g.drawImage(m, 120, (720-h)/2,w,h);
		else g.drawImage(m, 100, (720-h)/2,w,h);
	}
	/**
	 * 怪物血量
	 * @param g
	 */
	public void drawBlood(GraphicsContext g) {
		g.setFill(Color.RED);
		g.fillRect(100+w/4, (720-w)/2-20, w/2,20);
		g.setFill(Color.WHITE);
		g.fillRect(102+w/4, (720-w)/2-18, w/2-4,16);
		g.setFill(Color.RED);
		double a=Odata.monsters.get(Odata.map).getBlood()*1.0/Odata.monsters.get(Odata.map).getMaxBlood();
		g.fillRect(103+w/4, (720-w)/2-17, (w/2-6)*a,14);
	}
}
