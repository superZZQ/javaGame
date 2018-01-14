package com.zzq.aircraft_dogfighter;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PlaneUI extends JPanel{
	public JPanel jp;
	int x,y;
	public PlaneUI(){
		//��ʾһ������
		javax.swing.JFrame jf = new javax.swing.JFrame();
		jf.setDefaultCloseOperation(3);
		jf.setSize(800, 600);
				
		//�趨���������
		jf.setTitle("�ɻ���ս");
		jf.setLocationRelativeTo(null);
		//���ý��治�ɸı��С
		jf.setResizable(false);
		//�������ӵ�������
		jp = new JPanel();
		jp.setBackground(Color.black);
		jf.add(jp);
		//���ô��� �ɼ�
		jf.setVisible(true);
		
		//ʵ�������ʶ���
		Graphics g = jp.getGraphics();
		
		//ʵ�����Ѵ����ļ��̼���������ӵ����¼�Դ���������
		KeyListening planekey = new KeyListening(g,jp);
		jp.addKeyListener(planekey);
		
		try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		//ΪJPanel��ȡ����
		jp.requestFocus();
		
		

	}
	public void paint(Graphics g){
		super.paint(g);
		//�ػ� �����
	}
	
	
	public static void main(String[] args){
		new PlaneUI();
		
	}
	
}

