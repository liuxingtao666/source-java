package day03;
/**
 * ��ѭ��
 * ���ڱ������ϻ�����
 * @author Administrator
 *
 */
public class NewForDemo {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		for(int i=0;i<array.length;i++){
			int num = array[i];
			System.out.println("��"+i+"��Ԫ����:"+num);
		}
		
		for(int num : array){
			num *= 10;
			System.out.println(num);
		}
	}
}



