package day02;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ���Լ�����ط���
 * @author Administrator
 *
 */
public class CollectionDemo2 {
	public static void main(String[] args) {
		Collection c 
			= new ArrayList();
		
		c.add(new Point(1,2));
		c.add(new Point(1,2));
		c.add(new Point(1,2));
		/*
		 * [(1,2) , (3,4) , (5,6)]
		 * 
		 * ������дtoString�ĸ�ʽ
		 * [Ԫ��1.toString(), Ԫ��2.toString(),...]
		 */
		System.out.println(c);
		
		Point p = new Point(1,2);
		/*
		 * contains�����Ὣ������Ԫ���뼯����
		 * ÿһ��Ԫ��˳�����equals�Ƚϣ�ֻҪ
		 * ��Ԫ�رȽϽ��Ϊtrue,����Ϊ���ϰ���
		 * ��Ԫ��
		 */
		if(c.contains(p)){
			System.out.println("����");
			/*
			 * remove����:
			 * ���ϻ�ʹ�ø���Ԫ���뼯����ÿ��Ԫ��
			 * ���αȽϣ�ɾ������һ���������Ԫ��equals
			 * �Ƚ�Ϊtrue��Ԫ�ء�
			 */
			c.remove(p);
			System.out.println(c);
		}else{
			System.out.println("������");
		}
	}
}





