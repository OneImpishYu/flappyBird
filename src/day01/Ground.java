package day01;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Fapply Bird ��Ŀ�ĵ����� image ͼƬ x ���ƶ��� y 500 ���ںͱ����زķ���
 * 
 * @author 1
 * 
 */
public class Ground {
	BufferedImage image;
	int x;
	int y;
	/**������ ��ʼ������
	 * @throws IOException */
	public Ground() throws IOException{
		image=ImageIO.read(getClass().getResource("ground.png"));
		x=0;
		y=500;
	}
	public void step(){
		x--;
		if(x==-109){
			x=0;
		}
	}
}
