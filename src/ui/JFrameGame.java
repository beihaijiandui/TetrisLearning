package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class JFrameGame extends JFrame {
	public JFrameGame(){
		//设置标题
		this.setTitle("Java俄罗斯方块");
		//设置默认关闭属性（程序结束）
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//设置窗口大小
		this.setSize(1168, 680);
		//设置不允许用户改变窗口大小
		this.setResizable(false);
		//居中
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		int x=(screen.width-this.getWidth())/2;
		int y=(screen.height-this.getHeight())/2-32;//稍微提高一下 不是完全居中
		this.setLocation(x, y);
		//设置默认panel
		this.setContentPane(new JPanelGame());
		
	}

}
