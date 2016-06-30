package control;

import service.GameService;
import ui.JPanelGame;

/**
 * ������Ҽ����¼�
 * ���ƻ���
 * �����߼�
 * @author RyanXin
 *
 */
public class GameControl {
	
	/**
	 * ��Ϸ�����
	 */
	private JPanelGame panelGame;
	
	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameService;
	
	public GameControl(JPanelGame panelGame,GameService gameService){
		this.panelGame=panelGame;
		this.gameService=gameService;
	}

	/**
	 * ������
	 */
	public void test() {
		this.gameService.gameTest(); 
		this.panelGame.repaint();
	}

	/*
	 * ���Ʒ�������ϣ�
	 */
	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint();
	}

	/*
	 * ���Ʒ�������£�
	 */
	public void keyDown() {
		this.gameService.keyDown();
		this.panelGame.repaint();
	}

	/*
	 * ���Ʒ��������
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}

	/*
	 * ���Ʒ�������ң�
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint();
	}
}
