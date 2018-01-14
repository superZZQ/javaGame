package com.zzq.aircraft_dogfighter;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyplaneThread implements Runnable {
	private JPanel jp;
	private Graphics g;
	private MyPlane mp;
	private ImageIcon bk;
	int x, y;
	MyBullet[] bullet_array;

	public MyplaneThread(Graphics g, JPanel jp, MyPlane mp,MyBullet[] bullet_array) {
		this.jp = jp;
		this.g = g;
		this.mp = mp;
		this.bullet_array = bullet_array;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			bk = new ImageIcon(this.getClass().getResource("bg.jpg"));
			g.drawImage(bk.getImage(), 0, 0, jp.getWidth(), jp.getHeight(), null);

			mp.drawMyplane();

			for(int i=0;i<bullet_array.length;i++){
				if(bullet_array[i]!=null){
					bullet_array[i].drawMyBullet();
				}
				
			}
			
			
			

		}
	}

}
