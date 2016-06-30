package entity;

import java.awt.Point;

public class GameAct {
	//方块数组
	private Point[] actPoints;
	
	private static int MIN_X=0;
	private static int MAX_X=9;
	private static int MIN_Y=0;
	private static int MAX_Y=17;
	
	public GameAct(){
		//TODO 配置文件（暂时硬编码）
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
	 * 方块移动
	 * 
	 * @param moveX X轴偏移量
	 * @param moveY Y轴偏移量
	 */
	public boolean move(int moveX,int moveY){
		//边界判定
		
		//移动处理
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
	 * 方块旋转
	 * 顺时针(A为旋转后的点，B为旋转前的点)
	 * A.x=o.y+o.x-B.y
	 * A.y=o.y-o.x+B.x
	 */
	public void round(){
		for(int i=1;i<actPoints.length;i++){
			int newX=actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int newY=actPoints[0].y-actPoints[0].x+actPoints[i].x;
			//TODO 判断是否可以旋转
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
	 * 判断是否超出边界
	 * @param x
	 * @param y
	 * @return
	 */
	private boolean isOverMap(int x,int y){
		return x<MIN_X ||x>MAX_X ||y<MIN_Y ||y>MAX_Y;
	}
}
