package application.control;

import java.net.URL;
import java.util.ResourceBundle;

import application.data.Odata;
import application.function.FUNAttackAnimation;
import application.function.FUNReadData;
import application.function.FUNcan;
import application.function.FUNlisten;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
//初始化 背景
public class Cmaster implements Initializable{
	@FXML
	private Canvas can;
	
	private FUNcan fcan=new FUNcan();
	private FUNlisten lis=new FUNlisten();
	private FUNReadData read=new FUNReadData();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				fcan.drawCanvas(can.getGraphicsContext2D());
				read.readDrugs();
				read.readMonster();
				Odata.animation=new FUNAttackAnimation(can.getGraphicsContext2D());
			}
		});
	}
	public void onMove(MouseEvent e) {
		Platform.runLater(new Runnable() {	
			@Override
			public void run(-) {
				if(!Odata.sttackactive) {
				lis.listenMove(e);
				fcan.drawCanvas(can.getGraphicsContext2D());
				}
			}
		});
	}
	public void onClick(MouseEvent e) {
		Platform.runLater(new Runnable() {	
			@Override
			public void run() {
				if(!Odata.sttackactive) {
					lis.listenClick(e);
					Odata.animation=new FUNAttackAnimation(can.getGraphicsContext2D());
					fcan.drawCanvas(can.getGraphicsContext2D());
				}
			}
		});
	}
}
