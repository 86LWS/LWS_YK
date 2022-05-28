package application.function;

import application.data.Odata;
import javafx.scene.canvas.GraphicsContext;

public class FUNcan {
	public void drawCanvas(GraphicsContext g) {
		g.clearRect(0, 0, 1280, 720);
		//绘制地图背景
		Odata.mapui.drawBg(g);
		//绘制标题
		if(!Odata.gameStart) {
			Odata.menu_draw.drawTitle(g);
			Odata.menu_draw.drawMasterMenu(g);
		}else {
			//绘制角色
			Odata.role1.drawReadyState(g);
			Odata.role2.drawReadyState(g);
			Odata.role3.drawReadyState(g);
			Odata.role4.drawReadyState(g);
			//绘制血条
			Odata.role1.drawBloodAndPower(g);
			Odata.role2.drawBloodAndPower(g);
			Odata.role3.drawBloodAndPower(g);
			Odata.role4.drawBloodAndPower(g);
			//绘制怪物
			Odata.monsterdraw.drawMonster(g);
			Odata.monsterdraw.drawBlood(g);
			//绘制金币
			Odata.menu_draw.drawMoney(g);
			//绘制背包
			Odata.menu_draw.drawKnapsack(g);
			//绘制商店
			Odata.menu_draw.drawShop(g);
			//绘制角色选择
			if(Odata.clickrole==1)Odata.role1.drawKillsSelect(g);
			if(Odata.clickrole==2)Odata.role2.drawKillsSelect(g);
			if(Odata.clickrole==3)Odata.role3.drawKillsSelect(g);
			if(Odata.clickrole==4)Odata.role4.drawKillsSelect(g);
		}
	}
}
