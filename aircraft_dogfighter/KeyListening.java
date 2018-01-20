package com.cl.plane20180112;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class KeyListening extends KeyAdapter implements Config {
	private JPanel jp;
	private Graphics g;
	private MyPlane mp;
	private MyplaneThread mpthread;
	private EnemyThread epthread;
	int x, y;
	int bx, by,ex,ey;
	int i = 0;
	MyBullet[] bullet_array = new MyBullet[BULLET_NUM];
	EnemyAirplane[] enemy_array = new EnemyAirplane[ENEMY_NUM];

	// 构造方法 将PlaneUI中的画笔、画板传入
	public KeyListening(Graphics g, JPanel jp) {
		this.g = g;
		this.jp = jp;
		// x,y为飞机初始位置（屏幕底端中间）
		this.x = jp.getWidth() / 2 - PLANE_WIDTH / 2;
		this.y = jp.getHeight() - PLANE_HEIGHT;
	}

	public void keyPressed(KeyEvent e) {
		// 将每次按键对应的值保存在code变量中
		int code = e.getKeyCode();
		// 判断按键通过设置属性plane_speed值改变方向
		switch (code) {
		case KeyEvent.VK_UP:
			mp.setVy(-PLANE_SPEED);
			break;
		case KeyEvent.VK_DOWN:
			mp.setVy(PLANE_SPEED);
			break;
		case KeyEvent.VK_LEFT:
			mp.setVx(-PLANE_SPEED);
			break;
		case KeyEvent.VK_RIGHT:
			mp.setVx(PLANE_SPEED);
			break;
		// 空格键控制游戏开始
		case KeyEvent.VK_SPACE:
			// 仅执行一次
			if (mpthread == null) {
				// 在初始位置画出飞机
				mp = new MyPlane(x, y, jp);
				// 启动线程（也是整个游戏的线程 仅启动一次）
				mpthread = new MyplaneThread(g, jp, mp,bullet_array,enemy_array);
				new Thread(mpthread).start();
				epthread = new EnemyThread(g,jp,enemy_array);
				new Thread(epthread).start();
			}
			break;
		// 开火
		case KeyEvent.VK_ENTER:
			if(i==BULLET_NUM){
				i=0;
			}		
				bx = mp.getX()+PLANE_WIDTH/2-BULLET_RADIUS;
				by = mp.getY()-BULLET_NUM;
				bullet_array[i] = new MyBullet(bx,by);
				i++;
			
			
			
			
		}
	}
	

	public void keyReleased(KeyEvent e) {
		// 将每次释放的键对应的值保存在code变量中
		int code = e.getKeyCode();
		switch (code) {
		// 线程始终继续，松开按键时控制线程中原本变化的值不再变动
		case KeyEvent.VK_UP:
			mp.setVy(0);
			break;
		case KeyEvent.VK_DOWN:
			mp.setVy(0);
			break;
		case KeyEvent.VK_LEFT:
			mp.setVx(0);
			break;
		case KeyEvent.VK_RIGHT:
			mp.setVx(0);
			break;
		case KeyEvent.VK_ENTER:
			break;
		}
	}
}
