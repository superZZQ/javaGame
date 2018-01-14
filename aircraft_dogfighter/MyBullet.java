package com.zzq.aircraft_dogfighter;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/**
	 * @author ZZQ
	 *�������ҵ�ս���ӵ�
	 *���ԣ�
	 *x,y:�ӵ�����
	 *gun:�Ƿ�ǹ
	 *bullet_speed:�ӵ������ٶ�
	 *bullet_radius:�ӵ��뾶
	 */ 
public class MyBullet {
		int x,y=0;
		Graphics g;
		int bullet_speed = -5;
		int bullet_radius = 3;
		
		//���췽�������뻭�ʡ�����Լ��ӵ���ʼ����
		public MyBullet(Graphics g,int x,int y){
			this.x = x;
			this.y = y;
			this.g = g;
		}
		//���廭�ӵ����������ڿ�ʼ���������ӵ��Լ��߳̿����ӵ��ƶ�
		public void drawMyBullet(){
			y+=bullet_speed;
			g.setColor(Color.white);
			g.fillOval(x, y, bullet_radius*2, bullet_radius*2);
		}
		//��ȡ�ӵ���ǰ���ꡢ��ȡ�ӵ��ٶ���뾶����
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
