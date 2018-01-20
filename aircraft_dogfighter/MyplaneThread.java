package com.cl.plane20180112;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyplaneThread implements Runnable {
	private JPanel jp;
	private Graphics g;
	private MyPlane mp;
	private ImageIcon bk;
	int bx, by, ex, ey;
	MyBullet[] bullet_array;
	EnemyAirplane[] enemy_array;
	int bullet_num = 7;

	public MyplaneThread(Graphics g, JPanel jp, MyPlane mp,MyBullet[] bullet_array,EnemyAirplane[] enemy_array) {
		this.jp = jp;
		this.g = g;
		this.mp = mp;
		this.bullet_array = bullet_array;
		this.enemy_array = enemy_array;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//创建缓冲区，设定其大小为面板大小
			BufferedImage buff = new BufferedImage(jp.getWidth(), jp.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
			//获取缓冲区上的画笔
			Graphics buffG = buff.getGraphics();
			
			bk = new ImageIcon(this.getClass().getResource("bg.jpg"));
			buffG.drawImage(bk.getImage(), 0, 0, jp.getWidth(), jp.getHeight(), null);

			mp.drawMyplane(buffG);
			
			for(int i=0;i<enemy_array.length;i++){
				if(enemy_array[i]!=null){
					enemy_array[i].drawEnemyAirplane(buffG);
				}
			}
			for(int i=0;i<bullet_array.length;i++){
				if(bullet_array[i]!=null){
					bullet_array[i].drawMyBullet(buffG);
				}
				
			}
			for(int i=0;i<bullet_array.length;i++){
				if(bullet_array[i]!=null){
					bx = bullet_array[i].getX();
					by = bullet_array[i].getY();
					for(int j=0;j<enemy_array.length;j++){
						if(enemy_array[j]!=null){
							ex = enemy_array[j].getX();
							ey = enemy_array[j].getY();
							if(by>ey&&by<ey+55&&bx>ex&&bx<ex+90){
								bullet_array[i] = null;
								enemy_array[j] = null;
							}
						}
					}
				}
			}
			//将缓冲区添加到画板上
			g.drawImage(buff, 0, 0, null);

		}
		
	}
}
