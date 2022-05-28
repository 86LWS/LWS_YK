package application.module.role;
/**
 * 剑士
 * @author Administrator
 *
 */

import application.data.Odata;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Swordsman{
	private int blood=900;
	private int maxBlood=900;
	private int power=100;
	private int maxPower=100;
	private String skill_1="单手剑";
	private String skill_2="双手剑";
	private int hurt_1=24;
	private int hurt_2=40;
	private int usePower_2=20;//技能消耗魔力
	private int recoverPower=7;//每回合恢复魔力
	private boolean ready=false;
	private boolean opanSkills=false;
	private boolean hudun=false;
	private boolean usedrug=false;
	private Image swordsman_1=new Image("application/ui/Swordsman/Swordsman-1.png");
	private Image swordsman_2=new Image("application/ui/Swordsman/Swordsman-2.png");
	private Image swordsman_3=new Image("application/ui/Swordsman/Swordsman-3.png");
	private Image swordsman_4_1=new Image("application/ui/Swordsman/Swordsman-4-1.png");
	private Image swordsman_4_2=new Image("application/ui/Swordsman/Swordsman-4-2.png");
	private Image swordsman_5_1=new Image("application/ui/Swordsman/Swordsman-5-1.png");
	private Image swordsman_5_2=new Image("application/ui/Swordsman/Swordsman-5-2.png");
	private Image maleMage_5=new Image("application/ui/MaleMage/MaleMage-5.png");
	/**
	 * 绘制准备阶段
	 * @param g
	 */
	public void drawReadyState(GraphicsContext g) {
		if(blood>0) {if(num<1)g.drawImage(swordsman_1, 908, 120,180,160);
		}else g.drawImage(swordsman_3, 908, 120,180,160);
		if(hudun)g.drawImage(maleMage_5, 970, 115,170,170);
		if(usedrug) {
			g.setFill(Color.GREEN);
			g.fillPolygon(new double[] {1050,1070,1030}, new double[] {100,120,120}, 3);
		}
	}
	/**
	 * 绘制血条和魔条
	 * @param g
	 */
	public void drawBloodAndPower(GraphicsContext g) {
		//血条
		g.setFill(Color.WHITE);
		g.fillRect(1150, 180, 104, 14);
		g.setLineWidth(2);
		g.setStroke(Color.RED);
		g.beginPath();
		g.strokeRect(1150, 180, 104, 14);
		g.closePath();
		g.setFill(Color.RED);
		g.fillRect(1152, 182, (blood*1.0)/maxBlood*100, 10);
		//魔法条
		g.setFill(Color.WHITE);
		g.fillRect(1150, 200, 104, 14);
		g.setLineWidth(2);
		g.setStroke(Color.CORNFLOWERBLUE);
		g.beginPath();
		g.strokeRect(1150, 200, 104, 14);
		g.closePath();
		g.setFill(Color.CORNFLOWERBLUE);
		g.fillRect(1152, 202, (power*1.0)/maxPower*100, 10);
		//是否准备
		if(ready) {
			g.setFont(new Font(20));
			g.setFill(Color.RED);
			g.fillText("Ready", 1150, 170);
		}
	}
	/**
	 * 绘制技能选择
	 * @param g
	 */
	public void drawKillsSelect(GraphicsContext g) {
		//背景框
		g.setFill(Color.rgb(98, 185, 22,0.5));
		g.fillRect(1080, 150, 80, 60);
		g.setStroke(Color.rgb(98, 185, 22));
		g.setLineWidth(5);
		g.beginPath();
		g.strokeRect(1077.5, 147.5, 85, 65);
		g.closePath();
		//选中背景
		g.setFill(Color.rgb(255,255,255,0.3));
		if(Odata.clickrole==1 && Odata.enterkillsnum==1)g.fillRect(1080, 155, 80, 24);
		else if(Odata.clickrole==1 && Odata.enterkillsnum==2)g.fillRect(1080, 180, 80, 24);
		//文字
		g.setFont(new Font(20));
		g.setFill(Color.WHITE);
		g.fillText(skill_1, 1085, 175);
		g.fillText(skill_2, 1085, 200);
	}
	private int num=0;
	/**
	 * 绘制攻击动画
	 * @param g
	 */
	public boolean drawAnimation(GraphicsContext g,int jineng) {
		//绘制角色动作
		if(num<3)g.drawImage(swordsman_2, 908, 120,180,160);
		else g.drawImage(swordsman_1, 908, 120,180,160);
		//绘制敌人被攻击特效
		Image m=Odata.monsters.get(Odata.map).getIm();
		double w=m.getWidth()*2.5;
		if(num<3)g.drawImage((jineng==1)?swordsman_4_1:swordsman_5_1, 25+w/2, 285,150,150);
		else g.drawImage((jineng==1)?swordsman_4_2:swordsman_5_2, 25+w/2, 285,150,150);
		num++;
		if(num>4) {if(jineng==2) {power-=usePower_2;if(power<0)power=0;}num=0;return true;}
		else{return false;}
	}
	/**
	 * 绘制被攻击
	 * @return
	 */
	public boolean drawHurt(GraphicsContext g) {
		g.drawImage(swordsman_1, 928, 120,180,160);
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
		if(y>120 && y<220 && x>1000 && x<1080) {
			if(Odata.useknapsack==false) {
				if(Odata.clickrole==1)Odata.clickrole=0;
				else Odata.clickrole=1;
			}else {
				for(int i=0;i<Odata.active.size();i++)if(Odata.active.get(i).indexOf("drug:")>-1)return;
				usedrug=true;
				Odata.useknapsack=false;
				Odata.active.add("drug:role1");
			}
		}
	}
	/**
	* 监听菜单点击
	* @param e
	*/
	public void listenClickMenu(MouseEvent e) {
		double x=e.getX(),y=e.getY();
		if(x>1080 && x<1160 && y>155 && y<179) {Odata.active.add("role1:kills1");ready=true;Odata.clickrole=0;}
		else if(x>1080 && x<1160 && y>180 && y<204 && power>=usePower_2) {Odata.active.add("role1:kills2");ready=true;Odata.clickrole=0;}
	}
	/**
	 * 监听鼠标在技能菜单上的移动
	 * @param e
	 */
	public void listenMoveMenu(MouseEvent e) {
		double x=e.getX(),y=e.getY();
		if(x>1080 && x<1160 && y>155 && y<175)Odata.enterkillsnum=1;
		else if(x>1080 && x<1160 && y>180 && y<200)Odata.enterkillsnum=2;
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
	public int getHurt_2() {
		return hurt_2;
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
