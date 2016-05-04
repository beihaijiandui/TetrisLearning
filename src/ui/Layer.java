package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * ���ƴ���  �����и�abstract���� ���Ը����Ϊabstract�ࣨ�����ࣩ
 * @author cc1
 *
 */
public abstract class Layer {
	
	protected static final int PADDING=16;
	private static final int SIZE=7;
	private static Image WINDOW_IMAGE=new ImageIcon("graphics/window/Window.png").getImage();
	private static int WINDOW_W=WINDOW_IMAGE.getWidth(null);
	private static int WINDOW_H=WINDOW_IMAGE.getHeight(null);
	
	//�������Ͻ�x����
	protected int x;
	//�������Ͻ�x����
	protected int y;
	//���ڿ��
	protected int w;
	//���ڸ߶�
	protected int h;
	
	protected Layer(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	
	/**
	 * ���ƴ���
	 */
	protected void createWindow(Graphics g){
		
		/*ʹ��9������������9�����֣���ɻ���һ��������ͼ*/
		
        //����
		g.drawImage(WINDOW_IMAGE, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
		//����
		g.drawImage(WINDOW_IMAGE, x+SIZE, y, x+w-SIZE, y+SIZE, SIZE, 0, WINDOW_W-SIZE, SIZE, null);
		//����
		g.drawImage(WINDOW_IMAGE, x+w-SIZE, y, x+w, y+SIZE, WINDOW_W-SIZE, 0, WINDOW_W, SIZE, null);
		//����
		g.drawImage(WINDOW_IMAGE, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, WINDOW_H-SIZE, null);
		//��
		g.drawImage(WINDOW_IMAGE, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_W-SIZE, WINDOW_H-SIZE, null);
		//����
		g.drawImage(WINDOW_IMAGE, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_W-SIZE, SIZE, WINDOW_W, WINDOW_H-SIZE, null);
		//����
		g.drawImage(WINDOW_IMAGE, x, y+h-SIZE, x+SIZE, y+h, 0, WINDOW_H-SIZE, SIZE, WINDOW_H, null);
		//����
		g.drawImage(WINDOW_IMAGE, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_H-SIZE, WINDOW_W-SIZE, WINDOW_H, null);
		//����
		g.drawImage(WINDOW_IMAGE, x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_W-SIZE, WINDOW_H-SIZE, WINDOW_W, WINDOW_H, null);
	}
	/*
	 * abstract��������Ϊ��������ȥ��д��������������Լ����ض��巽����
	 * @param g ����
	 */
	abstract public void paint(Graphics g);
}
