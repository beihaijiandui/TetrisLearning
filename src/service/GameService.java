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
	 * ������
	 */
	public void gameTest() {
		int temp=dto.getNowPoint();
		dto.setNowPoint(temp+1);
	}
	
	/*
	 * ���Ʒ�������ϣ�
	 */
	public void keyUp() {
		
		this.dto.getGameAct().round();
		/**
		 * ������
		 */
		/*if(this.canMove(0, -1)){
			this.dto.getGameAct().move(0, -1);
		}*/
	}

	/*
	 * ���Ʒ�������£�
	 */
	public void keyDown() {
			if(!this.dto.getGameAct().move(0, 1)){
				//�����Ϸ��ͼ����
				boolean[][] map=this.dto.getGameMap();
				Point[] act=this.dto.getGameAct().getActPoints();
				for(int i=0;i<act.length;i++){
					map[act[i].x][act[i].y]=true;
				}
			}
	}

	/*
	 * ���Ʒ��������
	 */
	public void keyLeft() {
			this.dto.getGameAct().move(-1, 0);
	}

	/*
	 * ���Ʒ�������ң�
	 */
	public void keyRight() {
			this.dto.getGameAct().move(1, 0);
	}
}
