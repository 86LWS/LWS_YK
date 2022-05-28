package application.function;

import java.util.Date;

import application.data.Odata;
import javafx.scene.input.MouseEvent;

public class FUNlisten {
	/**
	 * 监听鼠标移动
	 * @param e
	 */
	public void listenMove(MouseEvent e) {
		if(!Odata.gameStart)Odata.menu_listen.listenMoveMasterMenu(e);
		else {
			if(Odata.clickrole==1)Odata.role1.listenMoveMenu(e);
			if(Odata.clickrole==2)Odata.role2.listenMoveMenu(e);
			if(Odata.clickrole==3)Odata.role3.listenMoveMenu(e);
			if(Odata.clickrole==4)Odata.role4.listenMoveMenu(e);
		}
	}
	private long clicktime=0;
	/**
	 * 监听鼠标点击
	 * @param e
	 */
	public void listenClick(MouseEvent e) {
		if(!Odata.gameStart)Odata.menu_listen.listenClickMasterMenu(e);
		else {
			//监听角色
			if(!Odata.role1.isReady())Odata.role1.listenClickRole(e);
			if(!Odata.role2.isReady())Odata.role2.listenClickRole(e);
			if(!Odata.role3.isReady())Odata.role3.listenClickRole(e);
			if(!Odata.role4.isReady())Odata.role4.listenClickRole(e);
			if(!Odata.role1.isReady()&&Odata.clickrole==1)Odata.role1.listenClickMenu(e);
			if(!Odata.role2.isReady()&&Odata.clickrole==2)Odata.role2.listenClickMenu(e);
			if(!Odata.role3.isReady()&&Odata.clickrole==3)Odata.role3.listenClickMenu(e);
			if(!Odata.role4.isReady()&&Odata.clickrole==4)Odata.role4.listenClickMenu(e);
			//监听背包
			if(!Odata.sttackactive)Odata.menu_listen.listenClickKnapsack(e);
			//监听商店
			if(!Odata.sttackactive) {
				long a=new Date().getTime();
				if(a-clicktime<200) {
					Odata.menu_listen.listenClickShop(e);
				}else clicktime=a;
			}
			//检测角色已经准备
			if(Odata.role1.isReady()&&Odata.role2.isReady()&&Odata.role3.isReady()&&Odata.role4.isReady()&&!Odata.sttackactive) {
				Odata.active.add("monster");
				Odata.sttackactive=true;
				Odata.animation.start();
			}
		}
	}
}
