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
 *面向对象-飞翔的小鸟
 */
public class BirdGame {
	public static void main(String[] args) throws Exception {
		JFrame frame=new JFrame("飞翔的小鸟");
		//设置窗口尺寸 考虑到边界
		frame.setSize(432+12,644+30);
		//带尺寸的窗口居中
		frame.setLocationRelativeTo(null);
		//实例化一个mypanel 画板
		MyPanel mypanel=new MyPanel();
		//将画板添加进画框
		frame.add(mypanel);
		//Defaultm默认 Close关闭 Operation操作  JFrame.EXIT_ON_CLOSE（关闭即退出）
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设定窗体可见
		frame.setVisible(true);
		mypanel.action();

	}
}
class MyPanel extends JPanel{
	int i;
	//背景图片
	BufferedImage background;
	//地面类
	BufferedImage gameover;
	Ground ground;
	Column column1;
	Column column2;
	Bird  bird;
	int score=0;
	boolean flag=true;
	public MyPanel() throws Exception {
		//读取背景图片
		background=ImageIO.read(getClass().getResource("bg.png"));
		gameover=ImageIO.read(getClass().getResource("gameover.png"));
		//地面对象
		ground=new Ground();
		column1=new Column(1);
		column2=new Column(2);
		bird =new Bird();
	}
	@Override
	/**
	 * 重写继承自父类的paint 用于在画板上添加元素
	 * MyPanel对象实例化后会自动调用此方法
	 */
	public void paint(Graphics g){
		//旋转-画-旋转回来
		//控制画笔
		Graphics2D g2=(Graphics2D)g;
		g.drawImage(background,0, 0, null);
		g.drawImage(column1.image,column1.x,column1.y,null);
		g.drawImage(column2.image,column2.x,column2.y,null);
		
		g2.rotate(-bird.alpha,bird.x,bird.y);//旋转
		g.drawImage(bird.image,bird.x-bird.width/2,bird.y-bird.height/2,null);
		g2.rotate(bird.alpha,bird.x,bird.y);//转回
		
		//设置字体黑体40加粗
		Font f=new Font(Font.SANS_SERIF,Font.BOLD,40);
		g.setFont(f);
		//在40,60位置写
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
		 //声明鼠标单机事件处理
		 MouseListener listener=new MouseAdapter() {
			 public void mousePressed(MouseEvent e) {
				 if(flag){
					 bird.flappy(); 
				 }
			 }
		};
		//添加鼠标监听
		addMouseListener(listener);
//		MouseListener listener2=new MouseAdapter() {
//			 public void mousePressed(MouseEvent e) {
//				 if(flag==false){
//					 bird.flappy();
//					 flag=true;
//				 }
//			 }
//		};
//		//添加鼠标监听
//		addMouseListener(listener2);
		while(1==1){
			ground.step();
			column1.step();
			column2.step();
			bird.step();
			bird.fly();//切换图片
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

