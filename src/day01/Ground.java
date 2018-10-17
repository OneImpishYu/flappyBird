package day01;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Fapply Bird 项目的地面类 image 图片 x 控制动作 y 500 用于和背景素材符合
 * 
 * @author 1
 * 
 */
public class Ground {
	BufferedImage image;
	int x;
	int y;
	/**构造器 初始化数据
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
