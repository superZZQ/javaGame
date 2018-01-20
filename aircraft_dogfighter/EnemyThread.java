package com.cl.plane20180112;

import java.awt.Graphics;

import javax.swing.JPanel;

public class EnemyThread implements Runnable{
	Graphics g;
	JPanel jp;
	EnemyAirplane ep;
	EnemyAirplane[] enemy_array;
	int i = 0;
	int ex,ey;
	int enemy_width = 90;
	int enemy_num = 25;
	int enemy_batch = 5;
	
	public EnemyThread(Graphics g, JPanel jp,EnemyAirplane[] enemy_array){
		this.g = g;
		this.jp = jp;
		this.enemy_array = enemy_array;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int k=0;k<enemy_batch;k++){
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int j=0;j<5;j++){
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ex = (int) (Math.random()*Math.floor(jp.getWidth()-enemy_width));
				ey = 0;
				enemy_array[i] = new EnemyAirplane(jp,ex,ey);
				i++;
				
			}
		}
	}
}
