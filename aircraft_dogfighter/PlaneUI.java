package com.zzq.aircraft_dogfighter;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PlaneUI extends JPanel{
	public JPanel jp;
	int x,y;
	public PlaneUI(){
		//显示一个窗口
		javax.swing.JFrame jf = new javax.swing.JFrame();
		jf.setDefaultCloseOperation(3);
		jf.setSize(800, 600);
				
		//设定标题与居中
		jf.setTitle("飞机大战");
		jf.setLocationRelativeTo(null);
		//设置界面不可改变大小
		jf.setResizable(false);
		//将面板添加到窗体上
		jp = new JPanel();
		jp.setBackground(Color.black);
		jf.add(jp);
		//设置窗体 可见
		jf.setVisible(true);
		
		//实例化画笔对象
		Graphics g = jp.getGraphics();
		
		//实例化已创建的键盘监听器并添加到其事件源——面板上
		KeyListening planekey = new KeyListening(g,jp);
		jp.addKeyListener(planekey);
		
		try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		//为JPanel获取焦点
		jp.requestFocus();
		
		

	}
	public void paint(Graphics g){
		super.paint(g);
		//重绘 待完成
	}
	
	
	public static void main(String[] args){
		new PlaneUI();
		
	}
	
}

