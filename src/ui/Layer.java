package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 绘制窗口  里面有个abstract方法 所以该类成为abstract类（抽象类）
 * @author cc1
 *
 */
public abstract class Layer {
	
	protected static final int PADDING=16;
	private static final int SIZE=7;
	private static Image WINDOW_IMAGE=new ImageIcon("graphics/window/Window.png").getImage();
	private static int WINDOW_W=WINDOW_IMAGE.getWidth(null);
	private static int WINDOW_H=WINDOW_IMAGE.getHeight(null);
	
	//窗口左上角x坐标
	protected int x;
	//窗口左上角x坐标
	protected int y;
	//窗口宽度
	protected int w;
	//窗口高度
	protected int h;
	
	protected Layer(int x,int y,int w,int h){
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
	
	/**
	 * 绘制窗口
	 */
	protected void createWindow(Graphics g){
		
		/*使用9个函数，画出9个部分，完成绘制一幅完整的图*/
		
        //左上
		g.drawImage(WINDOW_IMAGE, x, y, x+SIZE, y+SIZE, 0, 0, SIZE, SIZE, null);
		//中上
		g.drawImage(WINDOW_IMAGE, x+SIZE, y, x+w-SIZE, y+SIZE, SIZE, 0, WINDOW_W-SIZE, SIZE, null);
		//右上
		g.drawImage(WINDOW_IMAGE, x+w-SIZE, y, x+w, y+SIZE, WINDOW_W-SIZE, 0, WINDOW_W, SIZE, null);
		//左中
		g.drawImage(WINDOW_IMAGE, x, y+SIZE, x+SIZE, y+h-SIZE, 0, SIZE, SIZE, WINDOW_H-SIZE, null);
		//中
		g.drawImage(WINDOW_IMAGE, x+SIZE, y+SIZE, x+w-SIZE, y+h-SIZE, SIZE, SIZE, WINDOW_W-SIZE, WINDOW_H-SIZE, null);
		//右中
		g.drawImage(WINDOW_IMAGE, x+w-SIZE, y+SIZE, x+w, y+h-SIZE, WINDOW_W-SIZE, SIZE, WINDOW_W, WINDOW_H-SIZE, null);
		//左下
		g.drawImage(WINDOW_IMAGE, x, y+h-SIZE, x+SIZE, y+h, 0, WINDOW_H-SIZE, SIZE, WINDOW_H, null);
		//中下
		g.drawImage(WINDOW_IMAGE, x+SIZE, y+h-SIZE, x+w-SIZE, y+h, SIZE, WINDOW_H-SIZE, WINDOW_W-SIZE, WINDOW_H, null);
		//右下
		g.drawImage(WINDOW_IMAGE, x+w-SIZE, y+h-SIZE, x+w, y+h, WINDOW_W-SIZE, WINDOW_H-SIZE, WINDOW_W, WINDOW_H, null);
	}
	/*
	 * abstract方法就是为了让子类去重写这个方法，所以自己不必定义方法体
	 * @param g 画笔
	 */
	abstract public void paint(Graphics g);
}
