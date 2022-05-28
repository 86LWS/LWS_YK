package application.module.role;

import java.util.Random;

import application.data.Odata;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Sorceress {
	private int blood=600;
	private int maxBlood=600;
	private int power=100;
	private int maxPower=100;
	private String skill_1="火焰";
	private String skill_2="回血";
	private int hurt_1=20;
	private int usePower_2=40;//技能消耗魔力
	private int recoverPower=8;//每回合恢复魔力
	private boolean ready=false;
	private boolean opanSkills=false;
	private boolean hudun=false;
	private boolean usedrug=false;
	private Image sorecress_1=new Image("application/ui/Sorceress/Sorceress-1.png");
	private Image sorecress_2=new Image("application/ui/Sorceress/Sorceress-2.png");
	private Image sorecress_3=new Image("application/ui/Sorceress/Sorceress-3.png");
	private Image[] sorecress_4=new Image[]{new Image("application/ui/Sorceress/Sorceress-4-1.png"),
											new Image("application/ui/Sorceress/Sorceress-4-2.png"),
											new Image("application/ui/Sorceress/Sorceress-4-3.png"),
											new Image("application/ui/Sorceress/Sorceress-4-4.png"),
											new Image("application/ui/Sorceress/Sorceress-4-5.png"),
											new Image("application/ui/Sorceress/Sorceress-4-6.png"),
											new Image("application/ui/Sorceress/Sorceress-4-7.png"),
//											new Image("application/ui/Sorceress/Sorceress-4-8.png"),
//											new Image("application/ui/Sorceress/Sorceress-4-9.png"),
//											new Image("application/ui/Sorceress/Sorceress-4-10.png"),
//											new Image("application/ui/Sorceress/Sorceress-4-11.png"),
											new Image("application/ui/Sorceress/Sorceress-4-12.png"),
											new Image("application/ui/Sorceress/Sorceress-4-13.png"),
											new Image("application/ui/Sorceress/Sorceress-4-14.png"),
											new Image("application/ui/Sorceress/Sorceress-4-15.png")
	};
	private Image[] sorecress_5=new Image[] {new Image("application/ui/Sorceress/Sorceress-5-1.png"),
											new Image("application/ui/Sorceress/Sorceress-5-2.png"),
											new Image("application/ui/Sorceress/Sorceress-5-3.png"),
											new Image("application/ui/Sorceress/Sorceress-5-4.png"),
											new Image("application/ui/Sorceress/Sorceress-5-5.png")
	};
	private Image maleMage_5=new Image("application/ui/MaleMage/MaleMage-5.png");
	public void drawReadyState(GraphicsContext g) {
		if(blood>0) {if(num<1)g.drawImage(sorecress_1, 985, 420,120,190);
		}else g.drawImage(sorecress_3, 985, 420,120,190);
		if(hudun)g.drawImage(maleMage_5, 970, 415,170,170);
		if(usedrug) {
			g.setFill(Color.GREEN);
			g.fillPolygon(new double[] {1050,1070,1030}, new double[] {400,420,420}, 3);
		}
	}
	/**
	 * 绘制血条和魔条
	 * @param g
	 */
	public void drawBloodAndPower(GraphicsContext g) {
		//血条
		g.setFill(Color.WHITE);
		g.fillRect(1150, 480, 104, 14);
		g.setLineWidth(2);
		g.setStroke(Color.RED);
		g.beginPath();
		g.strokeRect(1150, 480, 104, 14);
		g.closePath();
		g.setFill(Color.RED);
		g.fillRect(1152, 482, (blood*1.0)/maxBlood*100, 10);
		//魔法条
		g.setFill(Color.WHITE);
		g.fillRect(1150, 500, 104, 14);
		g.setLineWidth(2);
		g.setStroke(Color.CORNFLOWERBLUE);
		g.beginPath();
		g.strokeRect(1150, 500, 104, 14);
		g.closePath();
		g.setFill(Color.CORNFLOWERBLUE);
		g.fillRect(1152, 502, (power*1.0)/maxPower*100, 10);
		//是否准备
		if(ready) {
			g.setFont(new Font(20));
			g.setFill(Color.RED);
			g.fillText("Ready", 1150, 470);
		}
	}
	/**
	 * 绘制技能选择
	 * @param g
	 */
	public void drawKillsSelect(GraphicsContext g) {
		//背景框
		g.setFill(Color.rgb(98, 185, 22,0.5));
		g.fillRect(1080, 450, 80, 60);
		g.setStroke(Color.rgb(98, 185, 22));
		g.setLineWidth(5);
		g.beginPath();
		g.strokeRect(1077.5, 447.5, 85, 65);
		g.closePath();
		//选中背景
		g.setFill(Color.rgb(255,255,255,0.3));
		if(Odata.clickrole==4 && Odata.enterkillsnum==1)g.fillRect(1080, 455, 80, 24);
		else if(Odata.clickrole==4 && Odata.enterkillsnum==2)g.fillRect(1080, 480, 80, 24);
		//文字
		g.setFont(new Font(20));
		g.setFill(Color.WHITE);
		g.fillText(skill_1, 1085, 475);
		g.fillText(skill_2, 1085, 500);
	}
	private int num=0;
	private int select=0;
	/**
	 * 绘制攻击动画
	 * @param g
	 */
	public boolean drawAnimation(GraphicsContext g,int jineng) {
		if(num==0)select=new Random().nextInt(4)+1;
		//绘制角色动作
		if(num<9)g.drawImage(sorecress_2, 985, 420,120,190);
		else g.drawImage(sorecress_1, 985, 420,120,190);
		//绘制敌人被攻击特效
		if(jineng==1) {
			Image m=Odata.monsters.get(Odata.map).getIm();
			double x=m.getWidth()*2.5/2+50;
			double y=360+m.getHeight()*2.5/2-180;
			g.drawImage(sorecress_4[num], x, y,90,180);
		}else {
			if(select==1)g.drawImage(sorecress_5[num/2], 965, 120,160,190);
			else if(select==2)g.drawImage(sorecress_5[num/2], 965, 230,160,190);
			else if(select==3)g.drawImage(sorecress_5[num/2], 965, 335,160,190);
			else g.drawImage(sorecress_5[num/2], 965, 435,160,190);
		}
		num++;
		if(num>9) {
			if(jineng==2) {power-=usePower_2;if(power<0)power=0;}
			if(select==1)Odata.role1.addBlood((Odata.role1.getMaxBlood()-Odata.role1.getBlood())/4);
			else if(select==2)Odata.role2.addBlood((Odata.role2.getMaxBlood()-Odata.role2.getBlood())/4);
			else if(select==3)Odata.role3.addBlood((Odata.role3.getMaxBlood()-Odata.role3.getBlood())/4);
			else Odata.role4.addBlood((Odata.role4.getMaxBlood()-Odata.role4.getBlood())/4);
			num=0;
			return true;
		}else{return false;}
	}
	/**
	 * 绘制被攻击
	 * @return
	 */
	public boolean drawHurt(GraphicsContext g) {
		g.drawImage(sorecress_1, 1005, 420,120,190);
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
		if(y>420 && y<520 && x>1000 && x<1080) {
			if(Odata.useknapsack==false) {
				if(Odata.clickrole==4)Odata.clickrole=0;
				else Odata.clickrole=4;
			}else {
				for(int i=0;i<Odata.active.size();i++)if(Odata.active.get(i).indexOf("drug:")>-1)return;
				usedrug=true;
				Odata.useknapsack=false;
				Odata.active.add("drug:role4");
			}
		}
	}
	/**
	* 监听菜单点击
	* @param e
	*/
	public void listenClickMenu(MouseEvent e) {
		double x=e.getX(),y=e.getY();
		if(x>1080 && x<1160 && y>455 && y<479) {Odata.active.add("role4:kills1");ready=true;Odata.clickrole=0;}
		else if(x>1080 && x<1160 && y>480 && y<504 && power>=usePower_2) {Odata.active.add("role4:kills2");ready=true;Odata.clickrole=0;}
	}
	/**
	 * 监听鼠标在技能菜单上的移动
	 * @param e
	 */
	public void listenMoveMenu(MouseEvent e) {
		double x=e.getX(),y=e.getY();
		if(x>1080 && x<1160 && y>455 && y<475)Odata.enterkillsnum=1;
		else if(x>1080 && x<1160 && y>480 && y<500)Odata.enterkillsnum=2;
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
	public boolean isHudun() {
		return hudun;
	}
	public void setHudun(boolean hudun) {
		this.hudun = hudun;
	}
	public int getHurt_1() {
		return hurt_1;
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
