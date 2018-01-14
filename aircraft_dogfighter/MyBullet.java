package com.zzq.aircraft_dogfighter;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
	 * @author ZZQ
	 *类名：我的战机子弹
	 *属性：
	 *x,y:子弹坐标
	 *gun:是否开枪
	 *bullet_speed:子弹飞行速度
	 *bullet_radius:子弹半径
	 */ 
public class MyBullet {
		int x,y=0;
		Graphics g;
		int bullet_speed = -5;
		int bullet_radius = 3;
		
		//构造方法，传入画笔、面板以及子弹初始坐标
		public MyBullet(Graphics g,int x,int y){
			this.x = x;
			this.y = y;
			this.g = g;
		}
		//定义画子弹方法，用于开始射击后出现子弹以及线程控制子弹移动
		public void drawMyBullet(){
			y+=bullet_speed;
			g.setColor(Color.white);
			g.fillOval(x, y, bullet_radius*2, bullet_radius*2);
		}
		//获取子弹当前坐标、获取子弹速度与半径方法
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public int getBulletSpeed(){
			return bullet_speed;
		}
		public void setBX(int bx){
			this.x = bx;
		}
		public void setBY(int by){
			this.y = by;
		}
		public void setBulletSpeed(int bullet_speed) {
			this.bullet_speed = bullet_speed;
		}
		public int getBulletRadius() {
			return bullet_radius;
		}
		
}
