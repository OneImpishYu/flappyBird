package day01;



import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Bird {
	BufferedImage image;
	// �洢С��״̬ͼ
	BufferedImage[] images;
	// С��״̬ͼ���±�
	int index;

	int x, y;
	int size;
	int width, height;// ��ĳ���
	double g;// �������ٶ�
	double t;// ���ʱ��
	double s;// λ��
	double v0;// ��ʼ�ٶ�
	double speed;// �ٶ�
	double alpha;// ���� ������Ķ�������

	public Bird() throws Exception {
		image = ImageIO.read(getClass().getResource("0.png"));
		width = image.getWidth();
		height = image.getHeight();// �����زĻ��ͼƬ�ߴ�
		// ����һ����8��Ԫ�ص����飬�����洢״̬ͼ
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
	 * ���ж���ʵ��
	 */
	public void fly() {
		index++;
		image = images[(index / 12) % 8];
	}

	/**
	 * С������
	 */
	public void flappy() {
		speed = 35;
	}

	/**
	 * �����ײ����
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
	 * �����ײ����
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
		// �������� ��ֱ����
		s = v0 * t + g * t * t * 0.5;
		y = y - (int) s;
		double v = v0 - g * t;
		speed = v;

		if (y > 600) {
			speed = 35;
		}
		// �������ת�Ļ���
		alpha = Math.atan(s / 8);
	}
}
