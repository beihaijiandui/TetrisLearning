package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class JFrameGame extends JFrame {
	public JFrameGame(){
		//���ñ���
		this.setTitle("Java����˹����");
		//����Ĭ�Ϲر����ԣ����������
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//���ô��ڴ�С
		this.setSize(1168, 680);
		//���ò������û��ı䴰�ڴ�С
		this.setResizable(false);
		//����
		Toolkit toolkit=Toolkit.getDefaultToolkit();
		Dimension screen=toolkit.getScreenSize();
		int x=(screen.width-this.getWidth())/2;
		int y=(screen.height-this.getHeight())/2-32;//��΢���һ�� ������ȫ����
		this.setLocation(x, y);
		//����Ĭ��panel
		this.setContentPane(new JPanelGame());
		
	}

}
