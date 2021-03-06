package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.ConfigFactory;
import config.GameConfig;

public class JFrameGame extends JFrame {
	public JFrameGame(JPanelGame panelGame){
		//获得游戏设置
		GameConfig cfg=ConfigFactory.getGameConfig();
		//设置标题
		this.setTitle(cfg.getTitle());
		//设置默认关闭属性（程序结束）
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//设置窗口大小
		this.setSize(cfg.getWidth(), cfg.getHeight());
		//设置不允许用户改变窗口大小
		this.setResizable(false);
		//居中
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		int x=(screen.width-this.getWidth())>>1;//右移运算符优先级实际上低于加减的 此处可以去掉括号的
		int y=((screen.height-this.getHeight())>>1)-cfg.getWindowUp();//稍微提高一下 不是完全居中
		this.setLocation(x, y);
		//设置默认panel
		this.setContentPane(panelGame);
		//默认该窗口为显示
		this.setVisible(true);
	}

}
