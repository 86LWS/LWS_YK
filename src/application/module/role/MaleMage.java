package application.module.role;
/**
 * 男魔法师
 * @author Administrator
 *
 */

import java.util.Random;

import application.data.Odata;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MaleMage {
	private int blood=600;
	private int maxBlood=600;
	private int power=100;
	private int maxPower=100;
	private String skill_1="闪电";
	private String skill_2="护盾";
	private int hurt_1=18;
	private int usePower_2=30;//技能消耗魔力
	private int recoverPower=10;//每回合恢复魔力
	private boolean ready=false;
	private boolean opanSkills=false;
	private boolean hudun=false;
	private boolean usedrug=false;
	private Image maleMage_1=new Image("application/ui/MaleMage/MaleMage-1.png");
	private Image maleMage_2=new Image("application/ui/MaleMage/MaleMage-2.png");
	private Image maleMage_3=new Image("application/ui/MaleMage/MaleMage-3.png");
	private Image maleMage_4=new Image("application/ui/MaleMage/MaleMage-4.png");
	private Image maleMage_5=new Image("application/ui/MaleMage/MaleMage-5.png");
	public void drawReadyState(GraphicsContext g) {
		if(blood>0) {if(num<1)g.drawImage(maleMage_1, 985, 320,100,190);
		}else g.drawImage(maleMage_3, 985, 320,100,190);
		if(hudun)g.drawImage(maleMage_5, 970, 315,170,170);
		if(usedrug) {
			g.setFill(Color.GREEN);
			g.fillPolygon(new double[] {1050,1070,1030}, new double[] {300,320,320}, 3);
		}
	}
	/**
	 * 绘制血条和魔条
	 * @param g
	 */
	public void drawBloodAndPower(GraphicsContext g) {
		//血条
		g.setFill(Color.WHITE);
		g.fillRect(1150, 380, 104, 14);
		g.setLineWidth(2);
		g.setStroke(Color.RED);
		g.beginPath();
		g.strokeRect(1150, 380, 104, 14);
		g.closePath();
		g.setFill(Color.RED);
		g.fillRect(1152, 382, (blood*1.0)/maxBlood*100, 10);
		//魔法条
		g.setFill(Color.WHITE);
		g.fillRect(1150, 400, 104, 14);
		g.setLineWidth(2);
		g.setStroke(Color.CORNFLOWERBLUE);
		g.beginPath();
		g.strokeRect(1150, 400, 104, 14);
		g.closePath();
		g.setFill(Color.CORNFLOWERBLUE);
		g.fillRect(1152, 402, (power*1.0)/maxPower*100, 10);
		//是否准备
		if(ready) {
			g.setFont(new Font(20));
			g.setFill(Color.RED);
			g.fillText("Ready", 1150, 370);
		}
	}
	/**
	 * 绘制技能选择
	 * @param g
	 */
	public void drawKillsSelect(GraphicsContext g) {
		//背景框
		g.setFill(Color.rgb(98, 185, 22,0.5));
		g.fillRect(1080, 350, 80, 60);
		g.setStroke(Color.rgb(98, 185, 22));
		g.setLineWidth(5);
		g.beginPath();
		g.strokeRect(1077.5, 347.5, 85, 65);
		g.closePath();
		//选中背景
		g.setFill(Color.rgb(255,255,255,0.3));
		if(Odata.clickrole==3 && Odata.enterkillsnum==1)g.fillRect(1080, 355, 80, 24);
		else if(Odata.clickrole==3 && Odata.enterkillsnum==2)g.fillRect(1080, 380, 80, 24);
		//文字
		g.setFont(new Font(20));
		g.setFill(Color.WHITE);
		g.fillText(skill_1, 1085, 375);
		g.fillText(skill_2, 1085, 400);
	}
	private int num=0;
	/**
	 * 绘制攻击动画
	 * @param g
	 */
	public boolean drawAnimation(GraphicsContext g,int jineng) {
		//绘制角色动作
		if(num<5)g.drawImage(maleMage_2, 985, 320,100,190);
		else g.drawImage(maleMage_1, 985, 320,100,190);
		//绘制敌人被攻击特效
		if(num>3)
			if(jineng==1) {
				Image m=Odata.monsters.get(Odata.map).getIm();
				double x=m.getWidth()*2.5/2+8;
				double y=360+m.getHeight()*2.5/2-400;
				g.drawImage(maleMage_4, x, y,185,400);
			}else {
				if(num==4) {
					int a=new Random().nextInt(4)+1;
					if(a==1)Odata.role1.setHudun(true);
					else if(a==2)Odata.role2.setHudun(true);
					else if(a==3)Odata.role3.setHudun(true);
					else Odata.role4.setHudun(true);
				}
			}
		num++;
		if(num>5) {if(jineng==2) {power-=usePower_2;if(power<0)power=0;}num=0;return true;}
		else{return false;}
	}
	/**
	 * 绘制被攻击
	 * @return
	 */
	public boolean drawHurt(GraphicsContext g) {
		g.drawImage(maleMage_1, 1005, 320,100,190);
		num++;
		if(num>3) {num=0;return true;}
		else{return false;}
	}
	/**
	 * 监听被点击
	 * @param e
	 */
	public void listenClickRole(MouseEvent e) {
		double x=e.getX(),y=e.getY();
		if(y>320 && y<420 && x>1000 && x<1080) {
			if(Odata.useknapsack==false) {
				if(Odata.clickrole==3)Odata.clickrole=0;
				else Odata.clickrole=3;
			}else {
				for(int i=0;i<Odata.active.size();i++)if(Odata.active.get(i).indexOf("drug:")>-1)return;
				usedrug=true;
				Odata.useknapsack=false;
				Odata.active.add("drug:role3");
			}
		}
	}
	/**
	* 监听菜单点击
	* @param e
	*/
	public void listenClickMenu(MouseEvent e) {
		double x=e.getX(),y=e.getY();
		if(x>1080 && x<1160 && y>355 && y<379) {Odata.active.add("role3:kills1");ready=true;Odata.clickrole=0;}
		else if(x>1080 && x<1160 && y>380 && y<404 && power>=usePower_2) {Odata.active.add("role3:kills2");ready=true;Odata.clickrole=0;}
	}
	/**
	 * 监听鼠标在技能菜单上的移动
	 * @param e
	 */
	public void listenMoveMenu(MouseEvent e) {
		double x=e.getX(),y=e.getY();
		if(x>1080 && x<1160 && y>355 && y<375)Odata.enterkillsnum=1;
		else if(x>1080 && x<1160 && y>380 && y<400)Odata.enterkillsnum=2;
	}
	public void setReady() {
		this.ready = !ready;
	}
	public boolean isReady() {
		return ready;
	}
	public void setOpanSkills() {
		this.opanSkills = !opanSkills;
	}
	public int getHurt_1() {
		return hurt_1;
	}
	public boolean isHudun() {
		return hudun;
	}
	public void setHudun(boolean hudun) {
		this.hudun = hudun;
	}
	public void addBlood(int num) {
		blood+=num;
		if(blood>maxBlood)blood=maxBlood;
		if(blood<0)blood=0;
	}
	public void addPower(int num) {
		power+=num;
		if(power>maxPower)power=maxPower;
		if(power<0)power=0;
	}
	public int getBlood() {
		return blood;
	}
	public int getMaxBlood() {
		return maxBlood;
	}
	public void huifumoli() {
		power+=recoverPower;
		if(power>maxPower)power=maxPower;
	}
	public void iniUsedrug() {
		usedrug=false;
	}
}
