package application.module.menu;

import java.util.Set;

import application.data.Odata;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class menuDraw {
	private String title="浅浅深深大冒险";
	/**
	 * 绘制标题
	 * @param g
	 */
	public void drawTitle(GraphicsContext g) {
		g.setFont(new Font(80));
		g.setStroke(Color.YELLOW);
		g.setLineWidth(40);
		g.beginPath();
		g.strokeText(title, (1280-title.length()*80)/2, 180);
		g.closePath();
		g.setFill(Color.rgb(19,79,29));
		g.fillText(title, (1280-title.length()*80)/2, 180);
	}
	/**
	 * 绘制主菜单
	 * @param g
	 */
	public void drawMasterMenu(GraphicsContext g) {
		//背景框
		g.setFill(Color.rgb(98,185,222,0.5));
		g.fillRect(540, 320, 200, 240);
		g.setStroke(Color.rgb(98,185,222));
		g.setLineWidth(10);
		g.beginPath();
		g.strokeRect(535, 315, 210, 250);
		g.closePath();
		//选项后
		g.setFill(Color.rgb(255,255,255,0.5));
		if(Odata.enterMasterMenuNew)g.fillRect(540, 335, 200, 45);
		if(Odata.enterMasterMenuLoad)g.fillRect(540, 385, 200, 45);
		if(Odata.enterMasterMenuSetting)g.fillRect(540, 435, 200, 45);
		if(Odata.enterMasterMenuExit)g.fillRect(540, 485, 200, 45);
		//选项前
		g.setFill(Color.rgb(50,90,110));
		g.setFont(new Font(30));
		g.fillText("新游戏", 595, 370);
		g.fillText("继续游戏", 580, 420);
		g.fillText("设置", 610, 470);
		g.fillText("退出游戏", 580, 520);
	}
	/**
	 * 绘制背包
	 * @param g
	 */
	public void drawKnapsack(GraphicsContext g) {
		//标题
		g.setFill(Color.rgb(98,185,222));
		g.fillRect(775, 600, 240, 45);
		g.setFill(Color.GREEN);
		g.setFont(new Font(20));
		g.fillText("背包:选中后点击角色使用", 780, 630);
		//背景框
		g.setFill(Color.rgb(98, 185, 22,0.5));
		g.fillRect(775, 645, 500, 70);
		g.setStroke(Color.rgb(98,185,222));
		g.setLineWidth(5);
		g.beginPath();
		g.strokeRect(772.5, 642.5, 505, 75);
		g.closePath();
		//内容
		Set<String> a=Odata.knapsack.keySet();
		int i=0;
		g.setFont(new Font(18));
		for(String s:a) {
			if(s.equals(Odata.selectdrug)) {
				g.setFill(Color.rgb(255, 255, 255,0.3));
				g.fillRect(i/3*160+780, 648+i%3*20, 160, 20);
			}
			g.setFill(Color.WHITE);
			g.fillText(s, i/3*160+790, 665+i%3*20);
			g.fillText(Odata.knapsack.get(s)+"", i/3*160+940-(Odata.knapsack.get(s)+"").length()*11, 665+i%3*20);
			i++;
		}
	}
	/**
	 * 绘制商店
	 * @param g
	 */
	public void drawShop(GraphicsContext g) {
		//标题
		g.setFill(Color.rgb(98,185,222));
		g.fillRect(5, 600, 240, 45);
		g.setFill(Color.GREEN);
		g.setFont(new Font(20));
		g.fillText("商店:双击购买", 10, 630);
		//背景框
		g.setFill(Color.rgb(98, 185, 22,0.5));
		g.fillRect(5, 645, 700, 70);
		g.setStroke(Color.rgb(98,185,222));
		g.setLineWidth(5);
		g.beginPath();
		g.strokeRect(2.5, 642.5, 705, 75);
		g.closePath();
		//内容
		g.setFont(new Font(18));
		g.setFill(Color.WHITE);
		for(int i=0;i<Odata.drugs.size();i++) {
			g.fillText(Odata.drugs.get(i).getName(), i/3*200+20, 665+i%3*20);
			g.fillText(Odata.drugs.get(i).getPrice()+"", i/3*200+200-(Odata.drugs.get(i).getPrice()+"").length()*11, 665+i%3*20);
		}
	}
	/**
	 * 绘制金钱
	 * @param g
	 */
	public void drawMoney(GraphicsContext g) {
		//背景框
		g.setFill(Color.rgb(255, 157, 0));
		g.fillRect(1080, 1, 200, 30);
		g.setFill(Color.rgb(212, 209, 108));
		g.fillRect(1085, 6, 190, 20);
		//文字
		g.setFont(new Font(17));
		g.setFill(Color.rgb(200, 120, 0));
		g.fillText("金币", 1087, 23);
		g.fillText(Odata.money+"", 1273-(Odata.money+"").length()*18, 23);
	}
}
