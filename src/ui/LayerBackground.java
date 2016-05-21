package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerBackground extends Layer {
	
	private static Image MG_GB_TEMP=new ImageIcon("graphics/background/Fish.jpg").getImage();

	public LayerBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(MG_GB_TEMP, 0, 0, 1162, 654, null);//��һ�����غ���
	}

}
