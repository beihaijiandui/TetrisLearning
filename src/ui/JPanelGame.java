package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class JPanelGame extends JPanel{
	
	private Layer[] lays=null;
	
	public JPanelGame(){
		lays=new Layer[]{
				new LayerBackground(0,0,0,0),//这几个坐标实际上没有用到 所以随意选的0 0 0 0
				new LayerDataBase(40,32,334,279),
				new LayerDisk(40,343,334,279),
				new LayerGame(414,32,334,590),
				new LayerButton(788,32,334,124),
				new LayerNext(788,188,176,148),
				new LayerLevel(964,188,158,148),
				new LayerPoint(788,368,334,200),
		};
	}
	
	@Override
	//Graphics是画柄
	public void paintComponent(Graphics g){
		for(int i=0;i<lays.length;i++){
			lays[i].paint(g);;
		}
		
//		g.drawImage(image, 32, 32, null);
//		g.drawImage(image,0,0,1024,1024,0,0,655,655,null);
	}
}
