package day01;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author 1
 *�������-�����С��
 */
public class BirdGame {
	public static void main(String[] args) throws Exception {
		JFrame frame=new JFrame("�����С��");
		//���ô��ڳߴ� ���ǵ��߽�
		frame.setSize(432+12,644+30);
		//���ߴ�Ĵ��ھ���
		frame.setLocationRelativeTo(null);
		//ʵ����һ��mypanel ����
		MyPanel mypanel=new MyPanel();
		//��������ӽ�����
		frame.add(mypanel);
		//DefaultmĬ�� Close�ر� Operation����  JFrame.EXIT_ON_CLOSE���رռ��˳���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//�趨����ɼ�
		frame.setVisible(true);
		mypanel.action();

	}
}
class MyPanel extends JPanel{
	int i;
	//����ͼƬ
	BufferedImage background;
	//������
	BufferedImage gameover;
	Ground ground;
	Column column1;
	Column column2;
	Bird  bird;
	int score=0;
	boolean flag=true;
	public MyPanel() throws Exception {
		//��ȡ����ͼƬ
		background=ImageIO.read(getClass().getResource("bg.png"));
		gameover=ImageIO.read(getClass().getResource("gameover.png"));
		//�������
		ground=new Ground();
		column1=new Column(1);
		column2=new Column(2);
		bird =new Bird();
	}
	@Override
	/**
	 * ��д�̳��Ը����paint �����ڻ��������Ԫ��
	 * MyPanel����ʵ��������Զ����ô˷���
	 */
	public void paint(Graphics g){
		//��ת-��-��ת����
		//���ƻ���
		Graphics2D g2=(Graphics2D)g;
		g.drawImage(background,0, 0, null);
		g.drawImage(column1.image,column1.x,column1.y,null);
		g.drawImage(column2.image,column2.x,column2.y,null);
		
		g2.rotate(-bird.alpha,bird.x,bird.y);//��ת
		g.drawImage(bird.image,bird.x-bird.width/2,bird.y-bird.height/2,null);
		g2.rotate(bird.alpha,bird.x,bird.y);//ת��
		
		//�����������40�Ӵ�
		Font f=new Font(Font.SANS_SERIF,Font.BOLD,40);
		g.setFont(f);
		//��40,60λ��д
		g.drawString("Score:"+score,40,60);
		g.drawImage(ground.image,ground.x,ground.y,null);
		if(bird.hit(ground)||bird.hit(column1)||bird.hit(column2)){
			flag=false;
//			bird.x--;
			ground.x++;
			column1.x++;
			column2.x++;
			score=0;
			g.drawImage(gameover,0,0, null); 
		}
		
	}
	 public void action() throws Exception{
		 //������굥���¼�����
		 MouseListener listener=new MouseAdapter() {
			 public void mousePressed(MouseEvent e) {
				 if(flag){
					 bird.flappy(); 
				 }
			 }
		};
		//���������
		addMouseListener(listener);
//		MouseListener listener2=new MouseAdapter() {
//			 public void mousePressed(MouseEvent e) {
//				 if(flag==false){
//					 bird.flappy();
//					 flag=true;
//				 }
//			 }
//		};
//		//���������
//		addMouseListener(listener2);
		while(1==1){
			ground.step();
			column1.step();
			column2.step();
			bird.step();
			bird.fly();//�л�ͼƬ
			bird.hit(ground);
			bird.hit(column1);
			bird.hit(column2);
			
			if (bird.score(column1)||bird.score(column2)) {
				score++;
			}
			repaint();
			Thread.sleep(1000/30);
		}
		
		
	}
	
}

