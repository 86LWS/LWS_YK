package application.module.menu;

import java.util.Set;

import application.data.Odata;
import application.module.drugs.drug;
import javafx.scene.input.MouseEvent;

public class menuListen {
	/**
	 * 监听主菜单鼠标移动
	 * @param e
	 */
	public void listenMoveMasterMenu(MouseEvent e) {
		double x=e.getX();
		double y=e.getY();
		if(x>595 && x<685 && y>340 && y<375)Odata.enterMasterMenuNew=true;
		else Odata.enterMasterMenuNew=false;
		if(x>610 && x<670 && y>440 && y<475)Odata.enterMasterMenuSetting=true;
		else Odata.enterMasterMenuSetting=false;
		if(x>580 && x<700 && y>380 && y<425)Odata.enterMasterMenuLoad=true;
		else Odata.enterMasterMenuLoad=false;
		if(x>580 && x<700 && y>480 && y<525)Odata.enterMasterMenuExit=true;
		else Odata.enterMasterMenuExit=false;
	}
	/**
	 * 监听主菜单鼠标点击
	 * @param e
	 */
	public void listenClickMasterMenu(MouseEvent e) {
		double x=e.getX();
		double y=e.getY();
		if(x>595 && x<685 && y>340 && y<375) {
			for(int i=0;i<Odata.drugs.size();i++)Odata.knapsack.put(Odata.drugs.get(i).getName(), 1);
			Odata.gameStart=true;
		}else if(x>610 && x<670 && y>440 && y<475)Odata.openMasterMenuSetting=true;
		else if(x>580 && x<700 && y>380 && y<425)Odata.enterMasterMenuLoad=true;
		else if(x>580 && x<700 && y>480 && y<525) {
			System.exit(0);
		}
	}
	/**
	 * 监听点击背包
	 * @param e
	 */
	public void listenClickKnapsack(MouseEvent e) {
		if(e.getX()>780 && e.getY()>650) {
			int x=(int)((e.getX()-790)/160);
			int y=(int)((e.getY()-650)/20);
			if(x<0)x=0;
			else if(x>2)x=2;
			if(y<0)y=0;
			else if(y>2)y=0;
			int num=x*3+y;
			Set<String> a=Odata.knapsack.keySet();
			int i=0;
			for(String s:a) {
				if(i==num && Odata.knapsack.get(s)>0) {
					Odata.selectdrug=s;
					Odata.useknapsack=true;
					break;
				}
				i++;
			}
		}
	}
	/**
	 * 监听商店
	 * @param e
	 */
	public void listenClickShop(MouseEvent e) {
		if(e.getX()<700 && e.getY()>650) {
			int x=(int)((e.getX()-5)/200);
			int y=(int)((e.getY()-650)/20);
			if(x<0)x=0;
			else if(x>2)x=2;
			if(y<0)y=0;
			else if(y>2)y=0;
			int num=x*3+y;
			drug d=Odata.drugs.get(num);
			//购买计算
			if(Odata.money>=d.getPrice()) {
				Set<String> a=Odata.knapsack.keySet();
				for(String i:a)if(i.equals(d.getName())) {
					Odata.knapsack.put(i, Odata.knapsack.get(i)+1);
					Odata.money-=d.getPrice();
				}
			}
		}
	}
}
