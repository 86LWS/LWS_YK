package application.function;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.util.Vector;

import application.data.Odata;
import application.module.drugs.drug;
import application.module.monster.monster;
import javafx.scene.image.Image;

public class FUNReadData {
	/**
	 * 加载药品
	 */
	public void readDrugs() {
		try {
			Odata.drugs=new Vector<>();
			BufferedReader re=new BufferedReader(new InputStreamReader(new FileInputStream(new File("data/item/drugs/drugs")), "utf-8"));
			String a=re.readLine();
			while((a=re.readLine())!=null) {
				String aa[]=a.replaceAll(" ", "").split(",");
				Odata.drugs.add(new drug(aa[0], Integer.valueOf(aa[1]), Integer.valueOf(aa[2]), Integer.valueOf(aa[3])));
			}
			re.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 加载怪物
	 */
	public void readMonster() {
		try {
			Odata.monsters=new TreeMap<>();
			BufferedReader re=new BufferedReader(new InputStreamReader(new FileInputStream(new File("data/monster/monster")), "utf-8"));
			String a=re.readLine();
			while((a=re.readLine())!=null) {
				String aa[]=a.replaceAll(" ", "").split(",");
				monster mo=new monster(aa[1],Integer.valueOf(aa[2]),Integer.valueOf(aa[3]),Integer.valueOf(aa[4]),Integer.valueOf(aa[5]),Double.valueOf(aa[6]),aa[7],Double.valueOf(aa[8]),Integer.valueOf(aa[9]));
				mo.setIm(new Image("application/ui/Monster/monster-"+aa[0]+".png"));
				Odata.monsters.put(Integer.valueOf(aa[0]),mo);
			}
			re.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
