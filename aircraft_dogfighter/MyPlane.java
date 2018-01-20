package com.cl.plane20180112;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * @author ZZQ
 *�������ҵ�ս��
 *���ԣ�
 *x,y:�ɻ�����
 *vx,vy:�ɻ���ʻ�ٶ�
 *gun:�Ƿ�ǹ
 *plane_width:�ɻ����
 *plane_height:����
 *bullet_speed:�ӵ������ٶ�
 *bullet_radius:�ӵ��뾶
 */ 
public class MyPlane{
	public JPanel jp;
	int x,y;
	int vx,vy;
	ImageIcon plane;
	int plane_width = 100;
	int plane_height = 60;
	//���췽�������뻭�ʡ�����Լ��ɻ���ʼ����
	public MyPlane(int x,int y,JPanel jp){
		this.x = x;
		this.y = y;
		this.jp = jp;
	}
	//���廭�ɻ����������ڿ�ʼ����ַɻ��Լ��߳̿��Ʒɻ��ƶ�
	public void drawMyplane(Graphics g){
		plane = new ImageIcon(this.getClass().getResource("plane.png"));
		g.drawImage(plane.getImage(), x, y, plane_width, plane_height, null);
		//�����жϷɻ����ɳ��߽�
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
	//��ȡ�ɻ���ǰ���ꡢ��ȡ�ɻ������ӵ��ٶ���뾶����
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
	//���÷ɻ������ٶ����������
	public void setVx(int vx) {
		this.vx = vx;
	}
	public void setVy(int vy) {
		this.vy = vy;
	}
}
