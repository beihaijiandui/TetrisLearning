package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerDataBase extends Layer {

	private static Image IMG_DB=new ImageIcon("graphics/string/db.png").getImage();
	public LayerDataBase(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g){
		this.createWindow(g);
		//在LayDataBase这个图片中画出IMG_DB这个图片，位置大约就是this.x+PADDING(静态的)
		g.drawImage(IMG_DB, this.x+PADDING, this.y+Layer.PADDING, null);
	}
}
