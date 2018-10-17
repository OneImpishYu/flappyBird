package day01;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 游戏中的柱子类
 * @author 1
 *
 */
public class Column {

	BufferedImage image;
	int x;
	int y;
	int width;
	int height;
	int gap;//单个柱子之间的缝隙144
	int distance;//两个柱子之间的距离245
	Random random=new Random();
	
	public Column(int i) throws IOException {
		image=ImageIO.read(getClass().getResource("Column.png"));
		distance=245;
		width=image.getWidth();
		height=image.getHeight();
		gap=144;
		x=432+(i-1)*245;
		y=-(random.nextInt(218)+300);//所有的y都应是随机产生
	}
	public void step(){
		x--;
		if(x<-width){
			x=432;
			y=-(random.nextInt(218)+300);
		}
	}
}


















