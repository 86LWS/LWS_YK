package application.data;

import application.module.drugs.drug;
import application.module.menu.menuDraw;
import application.module.menu.menuListen;
import application.module.monster.monster;
import application.module.monster.monsterDraw;
import application.module.role.Archer;
import application.module.role.MaleMage;
import application.module.role.Sorceress;
import application.module.role.Swordsman;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Vector;

import application.function.FUNAttackAnimation;
import application.map.map;

public class Odata {
	//角色
	public static Swordsman role1=new Swordsman();
	public static Archer role2=new Archer();
	public static MaleMage role3=new MaleMage();
	public static Sorceress role4=new Sorceress();
	//菜单相关数据
	public static menuDraw menu_draw=new menuDraw();
	public static menuListen menu_listen=new menuListen();
	public static boolean enterMasterMenuNew=false;
	public static boolean enterMasterMenuLoad=false;
	public static boolean enterMasterMenuSetting=false;
	public static boolean enterMasterMenuExit=false;
	public static boolean openMasterMenuSetting=false;
	public static boolean openKnapsack=false;
	//药品
	public static Vector<drug> drugs=new Vector<>();
	//怪物
	public static TreeMap<Integer, monster> monsters=new TreeMap<>();
	public static monsterDraw monsterdraw=new monsterDraw();
	//背包
	public static HashMap<String, Integer> knapsack=new HashMap<>();
	public static String selectdrug=null;
	public static boolean useknapsack=false;
	//选中
	public static int clickrole=0;//1 剑士，2 弓箭手，3 男法师，4 女法师
	public static int enterkillsnum=0;
	//攻击顺序
	public static Vector<String> active=new Vector<>();
	//攻击动画
	public static boolean sttackactive=false;
	public static FUNAttackAnimation animation;
	public static boolean monsterattack=false;
	
	public static boolean gameStart=false;
	public static boolean ready=true;
	public static int map=1;
	public static map mapui=new map();
	public static int money=100;
	
}
