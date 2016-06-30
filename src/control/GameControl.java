package control;

import service.GameService;
import ui.JPanelGame;

/**
 * 接受玩家键盘事件
 * 控制画面
 * 控制逻辑
 * @author RyanXin
 *
 */
public class GameControl {
	
	/**
	 * 游戏界面层
	 */
	private JPanelGame panelGame;
	
	/**
	 * 游戏逻辑层
	 */
	private GameService gameService;
	
	public GameControl(JPanelGame panelGame,GameService gameService){
		this.panelGame=panelGame;
		this.gameService=gameService;
	}

	/**
	 * 测试用
	 */
	public void test() {
		this.gameService.gameTest(); 
		this.panelGame.repaint();
	}

	/*
	 * 控制方向键（上）
	 */
	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint();
	}

	/*
	 * 控制方向键（下）
	 */
	public void keyDown() {
		this.gameService.keyDown();
		this.panelGame.repaint();
	}

	/*
	 * 控制方向键（左）
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}

	/*
	 * 控制方向键（右）
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint();
	}
}
