package application.function;
//运动逻辑

import java.util.Random;
import java.util.Set;

import application.data.Odata;
import application.module.drugs.drug;
import javafx.scene.canvas.GraphicsContext;
/**
 * 动画控制线程
 * 10帧
 * @author Administrator
 *
 */
public class FUNAttackAnimation extends Thread{
	private GraphicsContext g;
	public FUNAttackAnimation(GraphicsContext g) {
		this.g=g;
	}
	@Override
	public void run() {
		try {
			String active=null;
			int asd=new Random().nextInt(4)+1;
			FUNcan fcan=new FUNcan();
			while(Odata.sttackactive) {
				fcan.drawCanvas(g);
				if(active==null) {//获取动作指令
					int a=new Random().nextInt(Odata.active.size());
					active=Odata.active.get(a);
					Odata.active.remove(a);
				}else {
					if(active.indexOf("role1:")>-1) {//角色1动画
						if(Odata.role1.drawAnimation(g, active.charAt(active.length()-1)-48)) {
							if(active.charAt(active.length()-1)-48==1)Odata.monsters.get(Odata.map).subBlood(Odata.role1.getHurt_1()-Odata.monsters.get(Odata.map).getPhysicalDefense());
							else Odata.monsters.get(Odata.map).subBlood(Odata.role1.getHurt_1()-Odata.monsters.get(Odata.map).getPhysicalDefense());
							if(Odata.active.size()<1)Odata.sttackactive=false;
							active=null;
						}
					}else if(active.indexOf("role2:")>-1) {//角色2动画
						if(Odata.role2.drawAnimation(g, active.charAt(active.length()-1)-48)) {
							if(active.charAt(active.length()-1)-48==1)Odata.monsters.get(Odata.map).subBlood(Odata.role2.getHurt_1()-Odata.monsters.get(Odata.map).getPhysicalDefense());
							else Odata.monsters.get(Odata.map).subBlood(Odata.role2.getHurt_1()-Odata.monsters.get(Odata.map).getPhysicalDefense());
							if(Odata.active.size()<1)Odata.sttackactive=false;
							active=null;
						}
					}else if(active.indexOf("role3:")>-1) {//角色3动画
						if(Odata.role3.drawAnimation(g, active.charAt(active.length()-1)-48)) {
							if(active.charAt(active.length()-1)-48==1)Odata.monsters.get(Odata.map).subBlood(Odata.role3.getHurt_1()-Odata.monsters.get(Odata.map).getMagicDefense());
							if(Odata.active.size()<1)Odata.sttackactive=false;
							active=null;
						}
					}else if(active.indexOf("role4:")>-1) {//角色4动画
						if(Odata.role4.drawAnimation(g, active.charAt(active.length()-1)-48)) {
							if(active.charAt(active.length()-1)-48==1)Odata.monsters.get(Odata.map).subBlood(Odata.role4.getHurt_1()-Odata.monsters.get(Odata.map).getMagicDefense());
							if(Odata.active.size()<1)Odata.sttackactive=false;
							active=null;
						}
					}else if(active.indexOf("monster")>-1){//怪物攻击
						Odata.monsterattack=true;
						if(asd==1)if(Odata.role1.drawHurt(g)) {
							if(Odata.role1.isHudun()) Odata.role1.setHudun(false);
							else Odata.role1.addBlood(-Odata.monsters.get(Odata.map).getAttack());
							if(Odata.active.size()<1)Odata.sttackactive=false;active=null;Odata.monsterattack=false;
						}
						if(asd==2)if(Odata.role2.drawHurt(g)) {
							if(Odata.role2.isHudun()) Odata.role2.setHudun(false);
							else Odata.role2.addBlood(-Odata.monsters.get(Odata.map).getAttack());
							if(Odata.active.size()<1)Odata.sttackactive=false;active=null;Odata.monsterattack=false;
						}
						if(asd==3)if(Odata.role3.drawHurt(g)) {
							if(Odata.role3.isHudun()) Odata.role3.setHudun(false);
							else Odata.role3.addBlood(-Odata.monsters.get(Odata.map).getAttack());
							if(Odata.active.size()<1)Odata.sttackactive=false;active=null;Odata.monsterattack=false;
							}
						if(asd==4)if(Odata.role4.drawHurt(g)) {
							if(Odata.role4.isHudun()) Odata.role4.setHudun(false);
							else Odata.role4.addBlood(-Odata.monsters.get(Odata.map).getAttack());
							if(Odata.active.size()<1)Odata.sttackactive=false;active=null;Odata.monsterattack=false;
							}
					}else {//使用药品
						drug d=null;
						for(int i=0;i<Odata.drugs.size();i++)if(Odata.drugs.get(i).getName().equals(Odata.selectdrug)) {d=Odata.drugs.get(i);break;}
						if(d!=null) {
							switch(active.charAt(active.length()-1)) {
							case '1':
								Odata.role1.addBlood(d.getAddBlood());
								Odata.role1.addPower(d.getAddPower());
								break;
							case '2':
								Odata.role2.addBlood(d.getAddBlood());
								Odata.role2.addPower(d.getAddPower());
								break;
							case '3':
								Odata.role3.addBlood(d.getAddBlood());
								Odata.role3.addPower(d.getAddPower());
								break;
							case '4':
								Odata.role4.addBlood(d.getAddBlood());
								Odata.role4.addPower(d.getAddPower());
								break;
							}
							//扣除物品
							Set<String> a=Odata.knapsack.keySet();
							for(String i:a)if(i.equals(Odata.selectdrug)) Odata.knapsack.put(i, Odata.knapsack.get(i)-1);
							Odata.selectdrug=null;
							Odata.role1.iniUsedrug();
							Odata.role2.iniUsedrug();
							Odata.role3.iniUsedrug();
							Odata.role4.iniUsedrug();
						}
						if(Odata.active.size()<1)Odata.sttackactive=false;
						active=null;
					}
				}
				Thread.sleep(100);
			}
			Odata.role1.setReady();
			Odata.role2.setReady();
			Odata.role3.setReady();
			Odata.role4.setReady();
			Odata.role1.huifumoli();
			Odata.role2.huifumoli();
			Odata.role3.huifumoli();
			Odata.role4.huifumoli();
			//下一关
			if(Odata.monsters.get(Odata.map).getBlood()<=0) {
				//奖励金钱
				Odata.money+=Odata.monsters.get(Odata.map).getMoney();
				//判断掉落物
				if(Odata.monsters.get(Odata.map).getProbability()<new Random().nextDouble()) {
					String a=Odata.monsters.get(Odata.map).getDrop();
				}
				Odata.map++;
			}
			fcan.drawCanvas(g);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
