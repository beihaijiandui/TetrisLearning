package service;

import java.awt.Point;

import dto.GameDto;
import entity.GameAct;

public class GameService {
	private GameDto dto;
	
	public GameService(GameDto dto){
		this.dto=dto;
		GameAct act=new GameAct();
		dto.setGameAct(act);
	}

	/**
	 * 测试用
	 */
	public void gameTest() {
		int temp=dto.getNowPoint();
		dto.setNowPoint(temp+1);
	}
	
	/*
	 * 控制方向键（上）
	 */
	public void keyUp() {
		
		this.dto.getGameAct().round();
		/**
		 * 测试用
		 */
		/*if(this.canMove(0, -1)){
			this.dto.getGameAct().move(0, -1);
		}*/
	}

	/*
	 * 控制方向键（下）
	 */
	public void keyDown() {
			if(!this.dto.getGameAct().move(0, 1)){
				//获得游戏地图对象
				boolean[][] map=this.dto.getGameMap();
				Point[] act=this.dto.getGameAct().getActPoints();
				for(int i=0;i<act.length;i++){
					map[act[i].x][act[i].y]=true;
				}
			}
	}

	/*
	 * 控制方向键（左）
	 */
	public void keyLeft() {
			this.dto.getGameAct().move(-1, 0);
	}

	/*
	 * 控制方向键（右）
	 */
	public void keyRight() {
			this.dto.getGameAct().move(1, 0);
	}
}
