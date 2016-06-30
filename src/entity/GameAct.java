package entity;

import java.awt.Point;

public class GameAct {
	//��������
	private Point[] actPoints;
	
	private static int MIN_X=0;
	private static int MAX_X=9;
	private static int MIN_Y=0;
	private static int MAX_Y=17;
	
	public GameAct(){
		//TODO �����ļ�����ʱӲ���룩
		actPoints=new Point[]{
				new Point(4,0),
				new Point(3,0),
				new Point(5,0),
				new Point(5,1),
		};
	}

	public Point[] getActPoints() {
		return actPoints;
	}
	
	/**
	 * �����ƶ�
	 * 
	 * @param moveX X��ƫ����
	 * @param moveY Y��ƫ����
	 */
	public boolean move(int moveX,int moveY){
		//�߽��ж�
		
		//�ƶ�����
		for(int i=0;i<actPoints.length;i++){
			int newX=actPoints[i].x+moveX;
			int newY=actPoints[i].y+moveY;
			if(this.isOverMap(newX, newY))
				return false;
		}
		
		for(int i=0;i<actPoints.length;i++){
			actPoints[i].x+=moveX;
			actPoints[i].y+=moveY;
		}
		return true;
	}
	
	/**
	 * ������ת
	 * ˳ʱ��(AΪ��ת��ĵ㣬BΪ��תǰ�ĵ�)
	 * A.x=o.y+o.x-B.y
	 * A.y=o.y-o.x+B.x
	 */
	public void round(){
		for(int i=1;i<actPoints.length;i++){
			int newX=actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int newY=actPoints[0].y-actPoints[0].x+actPoints[i].x;
			//TODO �ж��Ƿ������ת
			if(this.isOverMap(newX, newY)){
				return;
			}
		}
		
		for(int i=1;i<actPoints.length;i++){
			int newX=actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int newY=actPoints[0].y-actPoints[0].x+actPoints[i].x;
			actPoints[i].x=newX;
			actPoints[i].y=newY;
		}
	}
	
	/**
	 * �ж��Ƿ񳬳��߽�
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isOverMap(int x,int y){
		return x<MIN_X ||x>MAX_X ||y<MIN_Y ||y>MAX_Y;
	}
}
