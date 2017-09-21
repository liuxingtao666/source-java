package day03;
/**
 * 新循环
 * 用于遍历集合或数组
 * @author Administrator
 *
 */
public class NewForDemo {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		for(int i=0;i<array.length;i++){
			int num = array[i];
			System.out.println("第"+i+"个元素是:"+num);
		}
		
		for(int num : array){
			num *= 10;
			System.out.println(num);
		}
	}
}



