package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.ConfigFactory;
import config.GameConfig;

public class JFrameGame extends JFrame {
	public JFrameGame(JPanelGame panelGame){
		//�����Ϸ����
		GameConfig cfg=ConfigFactory.getGameConfig();
		//���ñ���
		this.setTitle(cfg.getTitle());
		//����Ĭ�Ϲر����ԣ����������
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//���ô��ڴ�С
		this.setSize(cfg.getWidth(), cfg.getHeight());
		//���ò������û��ı䴰�ڴ�С
		this.setResizable(false);
		//����
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		int x=(screen.width-this.getWidth())>>1;//������������ȼ�ʵ���ϵ��ڼӼ��� �˴�����ȥ�����ŵ�
		int y=((screen.height-this.getHeight())>>1)-cfg.getWindowUp();//��΢���һ�� ������ȫ����
		this.setLocation(x, y);
		//����Ĭ��panel
		this.setContentPane(panelGame);
		//Ĭ�ϸô���Ϊ��ʾ
		this.setVisible(true);
	}

}
