package com.cl.plane20180112;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EnemyAirplane implements Config{
	JPanel jp;
	ImageIcon enermy_plane;
	int x,y;
	int enemy_num = 10;
	int enemy_width = 90;
	int enemy_height = 55;
	public EnemyAirplane(JPanel jp,int x,int y){
		this.jp = jp;
		this.x = x;
		this.y = y;
	}
	public void drawEnemyAirplane(Graphics g){
		y+=ENEMY_SPEED;
		enermy_plane = new ImageIcon(this.getClass().getResource("enemy_s.png"));
		g.drawImage(enermy_plane.getImage(), x, y, enemy_width, enemy_height,null);
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
}
