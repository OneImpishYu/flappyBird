package day01;

import java.util.Random;

/**
 * Ëæ»úÊı Math Random
 * 
 * @author 1
 * 
 */
public class Demo_02 {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i = i + 1) {
			Random random=new  Random();
			int number =-(random.nextInt(218)+132);
			System.out.print(number+",");
		}
		
	
//		for (int i = 0; i < 100; i = i + 1) {
//			int  number = (int)(Math.random()*95)+5;
//			System.out.print(number+",");
//		}

	}
}
