package day02;

public class IntegerDemo2 {
	public static void main(String[] args) {
//		/*
//		 * ��������ת��Ϊ��װ��
//		 */
//		int i = 1;
//		Integer ii = new Integer(i);
//		
//		double d = 123.123;
//		Double dd = new Double(d);
//		
//		/*
//		 * �Ӱ�װ��ת��Ϊ���Ӧ�Ļ�������
//		 * ��װ���ṩһ������ XXXValue()
//		 */
//		int inum = ii.intValue();
//		double dnum = dd.doubleValue();
//		
//		System.out.println(inum);
//		System.out.println(dnum);
		
		/*
		 * java�Ƽ������ڴӻ�������ת��Ϊ
		 * ��װ��ʱ��ʹ�ù��췽���ķ�ʽ
		 * ����ʹ��valueOf�����ķ�ʽ
		 * ���а�װ�඼֧��һ����̬����valueOf()
		 */
		
		Integer i1 = Integer.valueOf(127);
		Integer i2 = Integer.valueOf(127);
		System.out.println(i1==i2);
	}
}


