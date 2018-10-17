package day01;



import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Bird {
	BufferedImage image;
	// 存储小鸟状态图
	BufferedImage[] images;
	// 小鸟状态图的下标
	int index;

	int x, y;
	int size;
	int width, height;// 鸟的长宽
	double g;// 重力加速度
	double t;// 间隔时间
	double s;// 位移
	double v0;// 初始速度
	double speed;// 速度
	double alpha;// 弧度 后期鸟的动作处理

	public Bird() throws Exception {
		image = ImageIO.read(getClass().getResource("0.png"));
		width = image.getWidth();
		height = image.getHeight();// 根据素材获得图片尺寸
		// 开辟一个有8个元素的数组，用来存储状态图
		images = new BufferedImage[8];
		for (int i = 0; i < images.length; i++) {
			images[i] = ImageIO.read(getClass().getResource(i + ".png"));
		}
		x = 132;
		y = 280;
		size = 40;
		g = 9.8;
		t = 0.25;
		v0 = 35;
		s = 0;
		speed = v0;
		alpha = 0;
		index = 0;
	}

	/**
	 * 飞行动作实现
	 */
	public void fly() {
		index++;
		image = images[(index / 12) % 8];
	}

	/**
	 * 小鸟上扬
	 */
	public void flappy() {
		speed = 35;
	}

	/**
	 * 检测碰撞地面
	 * 
	 * @param ground
	 * @return
	 */
	public boolean hit(Ground ground){
		if(y+size/2>ground.y){
			
		}
		return y+size/2>ground.y;
	}

	/**
	 * 检测碰撞柱子
	 * 
	 * @param column
	 * @return
	 */
	public boolean hit(Column column){
		if(x+size/2>column.x&&x-size/2<column.x+column.width){
			if((y-size/2)>(column.y+column.height/2-column.gap/2)
					&&(y+size/2)<(column.y+column.height/2+column.gap/2)){
				return false;
			}else{
				return true;
			}
		}
		return false;
	}
	public boolean score(Column column){
		if((x-size/2)==(column.x+column.width)){
			return true;
		}
		return false;
	}
	public void step() {
		double v0 = speed;
		// 自由落体 竖直上抛
		s = v0 * t + g * t * t * 0.5;
		y = y - (int) s;
		double v = v0 - g * t;
		speed = v;

		if (y > 600) {
			speed = 35;
		}
		// 鸟对象旋转的弧度
		alpha = Math.atan(s / 8);
	}
}
