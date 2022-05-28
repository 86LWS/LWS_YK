package application.module.monster;

import javafx.scene.image.Image;

public class monster {
	private String name;
	private int blood;
	private int maxBlood;
	private int physicalDefense;
	private int magicDefense;
	private int attack;
	private double groupAttack;
	private String drop;
	private double probability;
	private int money;
	private Image im;
	public monster(String name,int blood,int physicalDefense,int magicDefense,int attack,double groupAttack,String drop,double probability,int money) {
		this.attack=attack;
		this.blood=blood;
		this.maxBlood=blood;
		this.drop=drop;
		this.groupAttack=groupAttack;
		this.magicDefense=magicDefense;
		this.money=money;
		this.name=name;
		this.physicalDefense=physicalDefense;
		this.probability=probability;
	}
	public void subBlood(int sub) {
		this.blood-=sub;
		if(blood<0)blood=0;
	}
	public String getName() {
		return name;
	}
	public int getBlood() {
		return blood;
	}
	public int getPhysicalDefense() {
		return physicalDefense;
	}
	public int getMagicDefense() {
		return magicDefense;
	}
	public int getAttack() {
		return attack;
	}
	public double getGroupAttack() {
		return groupAttack;
	}
	public String getDrop() {
		return drop;
	}
	public double getProbability() {
		return probability;
	}
	public int getMoney() {
		return money;
	}
	public Image getIm() {
		return im;
	}
	public void setIm(Image im) {
		this.im = im;
	}
	public int getMaxBlood() {
		return maxBlood;
	}
}
