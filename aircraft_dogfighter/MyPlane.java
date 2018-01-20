package com.cl.plane20180112;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author ZZQ
 *类名：我的战机
 *属性：
 *x,y:飞机坐标
 *vx,vy:飞机行驶速度
 *gun:是否开枪
 *plane_width:飞机宽度
 *plane_height:机长
 *bullet_speed:子弹飞行速度
 *bullet_radius:子弹半径
 */ 
public class MyPlane{
	public JPanel jp;
	int x,y;
	int vx,vy;
	ImageIcon plane;
	int plane_width = 100;
	int plane_height = 60;
	//构造方法，传入画笔、面板以及飞机初始坐标
	public MyPlane(int x,int y,JPanel jp){
		this.x = x;
		this.y = y;
		this.jp = jp;
	}
	//定义画飞机方法，用于开始后出现飞机以及线程控制飞机移动
	public void drawMyplane(Graphics g){
		plane = new ImageIcon(this.getClass().getResource("plane.png"));
		g.drawImage(plane.getImage(), x, y, plane_width, plane_height, null);
		//条件判断飞机不飞出边界
		if(x+vx>0&&x+vx<jp.getWidth()-plane_width){
			x+=vx;	
		}else if(x+vx<=0){
			x=0;
		}else if(x+vx>=jp.getWidth()-plane_width){
			x=jp.getWidth()-plane_width;
		}
		if(y+vy>0&&y+vy<jp.getHeight()-plane_height){
			y+=vy;	
		}else if(y+vy<=0){
			y=0;
		}else if(y+vy>=jp.getHeight()-plane_height){
			y=jp.getHeight()-plane_height;
		}
	}
	//获取飞机当前坐标、获取飞机长宽、子弹速度与半径方法
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getPlaneWidth() {
		return plane_width;
	}
	public int getPlaneHeight() {
		return plane_height;
	}
	//设置飞机飞行速度与射击开关
	public void setVx(int vx) {
		this.vx = vx;
	}
	public void setVy(int vy) {
		this.vy = vy;
	}
}
