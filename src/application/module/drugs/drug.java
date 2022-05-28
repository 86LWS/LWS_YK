package application.module.drugs;

public class drug {
	private String name;
	private int price;
	private int addBlood;
	private int addPower;
	public drug(String name,int price,int addBlood,int addPower) {
		this.name=name;//指向当前构造的一共指针 成员属性
		this.price=price;
		this.addBlood=addBlood;
		this.addPower=addPower;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getAddBlood() {
		return addBlood;
	}
	public int getAddPower() {
		return addPower;
	}
	
}
