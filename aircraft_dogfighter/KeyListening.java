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

	// ���췽�� ��PlaneUI�еĻ��ʡ����崫��
	public KeyListening(Graphics g, JPanel jp) {
		this.g = g;
		this.jp = jp;
		// x,yΪ�ɻ���ʼλ�ã���Ļ�׶��м䣩
		this.x = jp.getWidth() / 2 - PLANE_WIDTH / 2;
		this.y = jp.getHeight() - PLANE_HEIGHT;
	}

	public void keyPressed(KeyEvent e) {
		// ��ÿ�ΰ�����Ӧ��ֵ������code������
		int code = e.getKeyCode();
		// �жϰ���ͨ����������plane_speedֵ�ı䷽��
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
		// �ո��������Ϸ��ʼ
		case KeyEvent.VK_SPACE:
			// ��ִ��һ��
			if (mpthread == null) {
				// �ڳ�ʼλ�û����ɻ�
				mp = new MyPlane(x, y, jp);
				// �����̣߳�Ҳ��������Ϸ���߳� ������һ�Σ�
				mpthread = new MyplaneThread(g, jp, mp,bullet_array,enemy_array);
				new Thread(mpthread).start();
				epthread = new EnemyThread(g,jp,enemy_array);
				new Thread(epthread).start();
			}
			break;
		// ����
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
		// ��ÿ���ͷŵļ���Ӧ��ֵ������code������
		int code = e.getKeyCode();
		switch (code) {
		// �߳�ʼ�ռ������ɿ�����ʱ�����߳���ԭ���仯��ֵ���ٱ䶯
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
