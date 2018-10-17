package day01;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
//��ɫ Color.class
//���ڿ�
//��� �װ�
//ͼƬ����
//��ȡͼƬ�Ĺ���

public class Demo_01 {
	public static void main(String[] args) throws Exception {
		// ����һ�����ڿ򣬱�frame��������
		JFrame frame = new JFrame();
		// �������,��panel��������
		// new MyPanel()ִ���˹�������װ����Ƭ
		MyPanel panel = new MyPanel();
		// Background ���������ñ���ɫ=��ɫ
		panel.setBackground(Color.BLUE);
		// ��frame���õĿ������panel���õ����
		// ��������
		frame.add(panel);
		frame.setSize(432, 644 + 30);
		// setVisibleִ�е�ʱ�򣬾����ִ����
		// paint ����
		frame.setVisible(true);
		panel.action();
	}
}// Demo01 ��Ľ���
// JPanel����հ����
// MyPanel ��չ(extends) ��Ϊ�̳�
// MyPanel �ڿհ��������չ�� ����ͼƬ
// "������" ����Ҫ��;�ǳ�ʼ������ı�����

class MyPanel extends JPanel {
	// �����˱���(background)ͼ������û��ͼƬ����
	BufferedImage background;
	BufferedImage bird;
	BufferedImage ground;
	int x = 0;
	// ���á�����������ʼ����������ȡͼƬ
	// ����������������һ��
	public MyPanel() throws Exception {
		// ʹ��ImageIO��read����������
		// ��"bg.png"��ȡΪһ��ͼƬ���͵Ķ���
		// background ���������ͼƬ����
		background = ImageIO.read(getClass().getResource("bg.png"));
		bird = ImageIO.read(getClass().getResource("0.png"));
		ground = ImageIO.read(getClass().getResource("ground.png"));
	}
	// �޸�JPanel�Ļ��Ʒ���
	// Graphics ͼ
	// paint Ϳ��
	// draw �� ImageͼƬ

	public void paint(Graphics g) {
		// ��0,0λ�û���backgroundͼƬ
		g.drawImage(background, 0, 0, null);
		g.drawImage(bird, 100, 300, null);
		g.drawImage(ground, x, 500, null);
	}
	// action �ж�
	public void action() throws Exception {
		while (true) {
			x--;// x��ֵȥ��1
			repaint();// �������paint()
			Thread.sleep(1000 / 30);// ����
		}
	}
}
